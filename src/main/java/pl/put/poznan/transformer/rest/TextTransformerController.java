package pl.put.poznan.transformer.rest;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.put.poznan.transformer.logic.Transformer;
import pl.put.poznan.transformer.logic.TextTransformerErector;


@RestController
@RequestMapping("/")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<JsonNode> get(
            @RequestParam(value="text") String text,
            @RequestParam(value="transforms", defaultValue="upper") String[] transforms
    ) throws JsonProcessingException {

        logger.debug(String.format("[Request] text = %s", text));
        logger.debug(String.format("[Request] transforms = %s", Arrays.toString(transforms)));

        Transformer transformer = TextTransformerErector.erectTransformer(transforms);
        String result = transformer.transform(text);

        logger.debug(String.format("[Response] result = %s", result));

        JsonNode json = mapper.readTree(String.format("{\"result\": \"%s\"}", result));
        return ResponseEntity.ok(json);
    }
}
