package pl.put.poznan.transformer.logic;

/**
 * The CapitalizeTextTransformerDecorator class is a decorator that capitalizes the first letter of the text.
 * It extends the TextTransformerDecorator class.
 */
public class CapitalizeTextTransformerDecorator extends TextTransformerDecorator {
    /**
     * Constructs a CapitalizeTextTransformerDecorator object with the specified transformer.
     *
     * @param transformer the transformer to be decorated
     */
    public CapitalizeTextTransformerDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * Transforms the given text by capitalizing the first letter.
     *
     * @param text the text to be transformed
     * @return the transformed text with the first letter capitalized
     */
    @Override
    public String transform(String text) {
        text = super.transform(text);
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}
