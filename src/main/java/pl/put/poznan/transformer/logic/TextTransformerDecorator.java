package pl.put.poznan.transformer.logic;

/**
 * The TextTransformerDecorator class is a base class for decorators implementing the Transformer interface.
 * It provides a constructor to initialize the decorator with a specified transformer and delegates the transform() method to the decorated transformer.
 */
public class TextTransformerDecorator implements Transformer {
    private final Transformer transformer;

    /**
     * Constructs a TextTransformerDecorator object with the specified transformer.
     *
     * @param transformer the transformer to be decorated
     */
    TextTransformerDecorator(Transformer transformer) {
        this.transformer = transformer;
    }

    /**
     * Transforms the given text by delegating the transformation to the decorated transformer.
     *
     * @param text the text to be transformed
     * @return the transformed text
     */
    @Override
    public String transform(String text) {
        return transformer.transform(text);
    }
}