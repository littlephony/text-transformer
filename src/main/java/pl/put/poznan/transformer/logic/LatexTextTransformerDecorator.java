package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;

/**
 * The LatexTextTransformerDecorator class is a decorator that converts special characters in the text to their LaTeX representation.
 * It extends the TextTransformerDecorator class.
 */
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

    /**
     * Constructs a LatexTextTransformerDecorator object with the specified transformer.
     *
     * @param transformer the transformer to be decorated
     */
    public LatexTextTransformerDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * Transforms the given text by converting special characters to their LaTeX representation.
     *
     * @param text the text to be transformed
     * @return the transformed text with special characters converted to LaTeX representation
     */
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
