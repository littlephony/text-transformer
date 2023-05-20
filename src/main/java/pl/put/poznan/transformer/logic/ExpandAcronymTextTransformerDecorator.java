package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;

public class ExpandAcronymTextTransformerDecorator extends TextTransformerDecorator {
    private static final Map<String, String> ACRONYM_EXPANSIONS = new HashMap<>();

    static {
        ACRONYM_EXPANSIONS.put("Ms.", "Miss");
        ACRONYM_EXPANSIONS.put("Mr.", "Mister");
        ACRONYM_EXPANSIONS.put("Prof.", "Professor");
        ACRONYM_EXPANSIONS.put("Dr.", "Doctor");
    }

    public ExpandAcronymTextTransformerDecorator(Transformer transformer) {
        super(transformer);
    }

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
