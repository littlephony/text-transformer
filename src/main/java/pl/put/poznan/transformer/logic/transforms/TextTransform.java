package pl.put.poznan.transformer.logic.transforms;

import java.util.HashMap;
import java.util.Map;

public enum TextTransform {
    CAPITALIZE("capitalize"),
    CONVERT_NUMBERS("convertNumbers"),
    DEDUPLICATE("deduplicate"),
    ESCAPE_LATEX("escape"),
    EXPAND_ACRONYMS("expandAcronyms"),
    INVERSE("inverse"),
    LOWER("lower"),
    REPLACE_ACRONYMS("replaceAcronyms"),
    UPPER("upper");

    private final String transform;
    private static final Map<String, TextTransform> lookup = new HashMap<String, TextTransform>();

    static {
        for (TextTransform transform : TextTransform.values()) {
            lookup.put(transform.toString(), transform);
        }
    }

    TextTransform(final String transform) {
        this.transform = transform;
    }

    public static TextTransform get(String verbose) {
        return lookup.get(verbose);
    }

    @Override
    public String toString() {
        return this.transform;
    }
}
