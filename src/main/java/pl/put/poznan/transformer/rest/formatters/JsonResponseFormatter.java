package pl.put.poznan.transformer.rest.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.put.poznan.transformer.rest.messages.TransformationResponse;

public class JsonResponseFormatter implements ResponseFormatter {
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String format(TransformationResponse response) throws ResponseFormattingException {
        try {
            return mapper.readTree(mapper.writeValueAsString(response)).toString();
        } catch (JsonProcessingException e) {
            throw new ResponseFormattingException(e.getMessage());
        }
    }
}
