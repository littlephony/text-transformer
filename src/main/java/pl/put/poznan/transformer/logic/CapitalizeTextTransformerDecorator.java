package pl.put.poznan.transformer.logic;

public class CapitalizeTextTransformerDecorator extends TextTransformerDecorator {
    public CapitalizeTextTransformerDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        text = super.transform(text);
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}
