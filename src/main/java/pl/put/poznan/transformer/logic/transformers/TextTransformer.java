package pl.put.poznan.transformer.logic.transformers;

/**
 * The TextTransformer class is an example implementation of the Transformer interface.
 * It simply returns the input text without any transformation.
 * This class serves as a demonstration that the logic should be separated from the REST service.
 */
public class TextTransformer implements Transformer {
    /**
     * Transforms the given text without making any changes.
     *
     * @param text the text to be transformed
     * @return the unmodified input text
     */
    @Override
    public String transform(String text) {
        return text;
    }
}
