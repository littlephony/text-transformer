package pl.put.poznan.transformer.rest.controllers;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.put.poznan.transformer.logic.transformers.Transformer;
import pl.put.poznan.transformer.logic.transformers.TextTransformerErector;
import pl.put.poznan.transformer.rest.formatters.ResponseFormattingException;
import pl.put.poznan.transformer.rest.messages.TransformationResponse;
import pl.put.poznan.transformer.rest.messages.ErrorTransformationResponse;
import pl.put.poznan.transformer.rest.messages.SuccessTransformationResponse;
import pl.put.poznan.transformer.rest.formatters.JsonResponseFormatter;


@RestController
@RequestMapping("/")
public class TextTransformerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextTransformerController.class);
    private static final JsonResponseFormatter JSON_RESPONSE_FORMATTER = new JsonResponseFormatter();

    @RequestMapping(path = "/transform", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> get(
            @RequestParam(value="text") String text,
            @RequestParam(value="transforms", defaultValue="") String[] transforms
    ) throws ResponseFormattingException {
        LOGGER.debug(String.format("[Request] text = %s", text));
        LOGGER.debug(String.format("[Request] transforms = %s", Arrays.toString(transforms)));

        Transformer transformer;
        TransformationResponse response;

        try {
            transformer = TextTransformerErector.erectTransformer(transforms);
        } catch (IllegalArgumentException e) {
            LOGGER.error(String.format(
                    "[Error] failed to erect transformer due to %s: %s",
                    e.getClass().getName(), e.getMessage()
            ));
            return formatResponse(new ErrorTransformationResponse(e));
        }

        try {
            String result = transformer.transform(text);
            LOGGER.debug(String.format("[Result] result = %s", result));
            response = new SuccessTransformationResponse(result);
        } catch (Exception e) {
            LOGGER.error(String.format("[Error] failed to process string due to %s", e.getClass().getName()));
            response = new ErrorTransformationResponse(e);
        }

        return formatResponse(response);
    }

    private ResponseEntity<String> formatResponse(TransformationResponse response) throws ResponseFormattingException {
        String responseString = JSON_RESPONSE_FORMATTER.format(response);
        LOGGER.info(String.format("Response: %s", responseString));
        return ResponseEntity.ok(responseString);
    }
}
