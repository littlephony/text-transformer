package pl.put.poznan.transformer.logic.transforms;

import pl.put.poznan.transformer.logic.Transformer;

/**
 * The LowerTextTransformerDecorator class is a decorator that converts the text to lowercase.
 * It extends the TextTransformerDecorator class.
 */
public class LowerTextTransformerDecorator extends TextTransformerDecorator {
    /**
     * Constructs a LowerTextTransformerDecorator object with the specified transformer.
     *
     * @param transformer the transformer to be decorated
     */
    public LowerTextTransformerDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * Transforms the given text by converting it to lowercase.
     *
     * @param text the text to be transformed
     * @return the transformed text in lowercase
     */
    @Override
    public String transform(String text) {
        return super.transform(text).toLowerCase();
    }
}