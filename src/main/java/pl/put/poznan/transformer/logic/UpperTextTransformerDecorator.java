package pl.put.poznan.transformer.logic;

/**
 * The UpperTextTransformerDecorator class is a decorator that transforms the text to uppercase.
 * It extends the TextTransformerDecorator class.
 */
public class UpperTextTransformerDecorator extends TextTransformerDecorator {
    /**
     * Constructs an UpperTextTransformerDecorator object with the specified transformer.
     *
     * @param transformer the transformer to be decorated
     */
    public UpperTextTransformerDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * Transforms the given text to uppercase.
     *
     * @param text the text to be transformed
     * @return the transformed text in uppercase
     */
    @Override
    public String transform(String text) {
        return super.transform(text).toUpperCase();
    }
}
