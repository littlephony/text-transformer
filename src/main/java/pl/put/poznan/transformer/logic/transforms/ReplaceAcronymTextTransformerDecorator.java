package pl.put.poznan.transformer.logic.transforms;

import pl.put.poznan.transformer.logic.transformers.Transformer;

import java.util.HashMap;
import java.util.Map;

/**
 * The ReplaceAcronymTextTransformerDecorator class is a decorator that replaces specified word acronyms in the text.
 * It extends the TextTransformerDecorator class.
 */
public class ReplaceAcronymTextTransformerDecorator extends TextTransformerDecorator {
    private static final Map<String, String> WORD_ACRONYMS = new HashMap<>();

    static {
        WORD_ACRONYMS.put("for example", "e.g.");
        WORD_ACRONYMS.put("and so on", "etc.");
        WORD_ACRONYMS.put("that is", "i.e.");
    }

    /**
     * Constructs a ReplaceAcronymTextTransformerDecorator object with the specified transformer.
     *
     * @param transformer the transformer to be decorated
     */
    public ReplaceAcronymTextTransformerDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * Transforms the given text by replacing word acronyms.
     *
     * @param text the text to be transformed
     * @return the transformed text with word acronyms replaced
     */
    @Override
    public String transform(String text) {
        return replaceAcronyms(super.transform(text));
    }

    /**
     * Replaces word acronyms in the given text with their corresponding values.
     *
     * @param text the text to be transformed
     * @return the transformed text with word acronyms replaced
     */
    private String replaceAcronyms(String text) {
        for (Map.Entry<String, String> entry : WORD_ACRONYMS.entrySet()) {
            String word = entry.getKey();
            String acronym = entry.getValue();
            text = text.replace(word, acronym);
        }

        return text;
    }
}
