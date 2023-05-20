package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;

public class ReplaceAcronymTextTransformerDecorator extends TextTransformerDecorator{
    private static final Map<String, String> WORD_ACRONYMS = new HashMap<>();

    static {
        WORD_ACRONYMS.put("for example", "e.g.");
        WORD_ACRONYMS.put("and so on", "etc.");
        WORD_ACRONYMS.put("that is", "i.e.");
    }

    public ReplaceAcronymTextTransformerDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        return replaceAcronyms(super.transform(text));
    }

    private String replaceAcronyms(String text) {
        for (Map.Entry<String, String> entry : WORD_ACRONYMS.entrySet()) {
            String word = entry.getKey();
            String acronym = entry.getValue();
            text = text.replace(word, acronym);
        }

        return text;
    }
}
