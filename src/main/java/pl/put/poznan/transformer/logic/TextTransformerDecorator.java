package pl.put.poznan.transformer.logic;

public class TextTransformerDecorator implements Transformer {
    private final Transformer transformer;

    TextTransformerDecorator(Transformer transformer) {
        this.transformer = transformer;
    }

    @Override
    public String transform(String text) {
        return transformer.transform(text);
    }
}
