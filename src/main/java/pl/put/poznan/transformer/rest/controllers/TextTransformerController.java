package pl.put.poznan.transformer.rest.controllers;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.put.poznan.transformer.logic.transformers.Transformer;
import pl.put.poznan.transformer.logic.transformers.TextTransformerErector;
import pl.put.poznan.transformer.rest.messages.TextTransformerResponse;
import pl.put.poznan.transformer.rest.messages.TextTransformerResponseError;
import pl.put.poznan.transformer.rest.messages.TextTransformerResponseSuccess;


@RestController
@RequestMapping("/")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(path = "/transform", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonNode> get(
            @RequestParam(value="text") String text,
            @RequestParam(value="transforms", defaultValue="") String[] transforms
    ) throws JsonProcessingException {
        logger.debug(String.format("[Request] text = %s", text));
        logger.debug(String.format("[Request] transforms = %s", Arrays.toString(transforms)));

        Transformer transformer;
        TextTransformerResponse response;

        try {
            transformer = TextTransformerErector.erectTransformer(transforms);
        } catch (IllegalArgumentException e) {
            logger.error(String.format(
                    "[Error] failed to erect transformer due to %s: %s",
                    e.getClass().getName(), e.getMessage()
            ));
            return makeJsonResponse(new TextTransformerResponseError(e));
        }

        try {
            String result = transformer.transform(text);
            logger.debug(String.format("[Result] result = %s", result));
            response = new TextTransformerResponseSuccess(result);
        } catch (Exception e) {
            logger.error(String.format("[Error] failed to process string due to %s", e.getClass().getName()));
            response = new TextTransformerResponseError(e);
        }

        return makeJsonResponse(response);
    }

    private ResponseEntity<JsonNode> makeJsonResponse(TextTransformerResponse response) throws JsonProcessingException {
        JsonNode json = mapper.readTree(mapper.writeValueAsString(response));
        logger.info(String.format("Response: %s", json));
        return ResponseEntity.ok(json);
    }
}
