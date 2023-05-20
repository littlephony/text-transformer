package pl.put.poznan.transformer.logic.transforms;

import pl.put.poznan.transformer.logic.transformers.Transformer;

import java.util.HashMap;
import java.util.Map;

/**
 * The ExpandAcronymTextTransformerDecorator class is a decorator that expands acronyms in the text.
 * It extends the TextTransformerDecorator class.
 */
public class ExpandAcronymTextTransformerDecorator extends TextTransformerDecorator {
    private static final Map<String, String> ACRONYM_EXPANSIONS = new HashMap<>();

    static {
        ACRONYM_EXPANSIONS.put("Ms.", "Miss");
        ACRONYM_EXPANSIONS.put("Mr.", "Mister");
        ACRONYM_EXPANSIONS.put("Prof.", "Professor");
        ACRONYM_EXPANSIONS.put("Dr.", "Doctor");
    }

    /**
     * Constructs an ExpandAcronymTextTransformerDecorator object with the specified transformer.
     *
     * @param transformer the transformer to be decorated
     */
    public ExpandAcronymTextTransformerDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * Transforms the given text by expanding acronyms.
     *
     * @param text the text to be transformed
     * @return the transformed text with acronyms expanded
     */
    @Override
    public String transform(String text) {
        return expandAcronyms(super.transform(text));
    }

    private String expandAcronyms(String text) {
        String[] words = text.split(" ");
        StringBuilder expandedSentence = new StringBuilder();

        for (String word : words) {
            if (ACRONYM_EXPANSIONS.containsKey(word)) {
                expandedSentence.append(ACRONYM_EXPANSIONS.get(word)).append(" ");
            } else {
                expandedSentence.append(word).append(" ");
            }
        }

        return expandedSentence.toString().trim();
    }
}