package pl.put.poznan.transformer.logic;

/**
 * The Transformer interface defines the contract for text transformation operations.
 */
public interface Transformer {
    /**
     * Transforms the given text.
     *
     * @param text the text to be transformed
     * @return the transformed text
     */
    String transform(String text);
}
