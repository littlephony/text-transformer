package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;

public class LatexTextTransformerDecorator extends TextTransformerDecorator {
    private static final Map<String, String> SPECIAL_CHARACTERS = new HashMap<>();

    static {
        SPECIAL_CHARACTERS.put("&", "\\&");
        SPECIAL_CHARACTERS.put("%", "\\%");
        SPECIAL_CHARACTERS.put("$", "\\$");
        SPECIAL_CHARACTERS.put("#", "\\#");
        SPECIAL_CHARACTERS.put("_", "\\_");
        SPECIAL_CHARACTERS.put("{", "\\{");
        SPECIAL_CHARACTERS.put("}", "\\}");
        SPECIAL_CHARACTERS.put("~", "\\textasciitilde");
        SPECIAL_CHARACTERS.put("^", "\\textasciicircum");
    }

    public LatexTextTransformerDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        return convertToLatex(super.transform(text));
    }

    private String convertToLatex(String text) {
        StringBuilder convertedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            String character = String.valueOf(text.charAt(i));
            if (SPECIAL_CHARACTERS.containsKey(character)) {
                convertedText.append(SPECIAL_CHARACTERS.get(character));
            } else {
                convertedText.append(character);
            }
        }
        return convertedText.toString();
    }
}
