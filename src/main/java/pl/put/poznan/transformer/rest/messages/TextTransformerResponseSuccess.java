package pl.put.poznan.transformer.rest.messages;

public class TextTransformerResponseSuccess extends TextTransformerResponse {
    String result;

    public TextTransformerResponseSuccess(String message) {
        this.result = message;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
