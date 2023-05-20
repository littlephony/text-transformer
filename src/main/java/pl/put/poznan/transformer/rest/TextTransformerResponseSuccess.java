package pl.put.poznan.transformer.rest;

public class TextTransformerResponseSuccess extends TextTransformerResponse {
    String result;

    TextTransformerResponseSuccess(String message) {
        this.result = message;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
