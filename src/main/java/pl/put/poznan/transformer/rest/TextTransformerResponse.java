package pl.put.poznan.transformer.rest;

public class TextTransformerResponse {
    String result;

    TextTransformerResponse(String message) {
        this.result = message;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
