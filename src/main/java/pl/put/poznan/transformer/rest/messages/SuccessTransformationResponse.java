package pl.put.poznan.transformer.rest.messages;

public class SuccessTransformationResponse extends TransformationResponse {
    String result;

    public SuccessTransformationResponse(String message) {
        this.result = message;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
