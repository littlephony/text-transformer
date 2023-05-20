package pl.put.poznan.transformer.logic;

public class LowerTextTransformerDecorator extends TextTransformerDecorator {
    public LowerTextTransformerDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        return super.transform(text).toLowerCase();
    }
}
