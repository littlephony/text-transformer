package pl.put.poznan.transformer.logic.transforms;

import pl.put.poznan.transformer.logic.transformers.Transformer;

/**
 * The DeduplicateTextTransformerDecorator class is a decorator that eliminates duplicate words in the text.
 * It extends the TextTransformerDecorator class.
 */
public class DeduplicateTextTransformerDecorator extends TextTransformerDecorator {
    /**
     * Constructs a DeduplicateTextTransformerDecorator object with the specified transformer.
     *
     * @param transformer the transformer to be decorated
     */
    public DeduplicateTextTransformerDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * Transforms the given text by eliminating duplicate words.
     *
     * @param text the text to be transformed
     * @return the transformed text with duplicate words removed
     */
    @Override
    public String transform(String text) {
        return eliminateDuplicates(super.transform(text));
    }

    private String eliminateDuplicates(String text) {
        StringBuilder processedText = new StringBuilder();
        String[] words = text.split(" ");

        for (int i = 0; i < words.length; ++i) {
            if (i == words.length - 1 || !words[i].equals(words[i + 1])) {
                processedText.append(words[i]).append(" ");
            }
        }

        return processedText.toString().trim();
    }
}
