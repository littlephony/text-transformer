package pl.put.poznan.transformer.logic;

import org.w3c.dom.Text;

public class TextTransformerDecorator implements Transformer {
    private final TextTransformer transformer;

    TextTransformerDecorator(TextTransformer transformer) {
        this.transformer = transformer;
    }

    @Override
    public String transform(String text) {
        return transformer.transform(text);
    }
}
