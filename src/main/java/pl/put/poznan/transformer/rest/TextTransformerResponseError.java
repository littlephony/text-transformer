package pl.put.poznan.transformer.rest;

public class TextTransformerResponseError extends TextTransformerResponse {
    String errorType;
    String message;

    TextTransformerResponseError(String errorType, String message) {
        this.errorType = errorType;
        this.message = message;
    }

    public TextTransformerResponseError(Exception e) {
        this.setErrorType(e.getClass().getName());
        this.setMessage(e.getMessage());
    }

    public String getErrorType() {
        return this.errorType;
    }

    public String getMessage() {
        return this.message;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
