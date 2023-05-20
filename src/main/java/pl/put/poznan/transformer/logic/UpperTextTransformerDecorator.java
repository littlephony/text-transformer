package pl.put.poznan.transformer.logic;

public class UpperTextTransformerDecorator extends TextTransformerDecorator {
    public UpperTextTransformerDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        return super.transform(text).toUpperCase();
    }
}
