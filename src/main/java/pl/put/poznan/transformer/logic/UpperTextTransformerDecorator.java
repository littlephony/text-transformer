package pl.put.poznan.transformer.logic;

public class UpperTextTransformerDecorator extends TextTransformerDecorator {
    public UpperTextTransformerDecorator(TextTransformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        return super.transform(text).toUpperCase();
    }
}
