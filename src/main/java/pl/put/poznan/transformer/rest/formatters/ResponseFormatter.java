package pl.put.poznan.transformer.rest.formatters;

import pl.put.poznan.transformer.rest.messages.TransformationResponse;

public interface ResponseFormatter {
    public String format(TransformationResponse response) throws ResponseFormattingException;
}
