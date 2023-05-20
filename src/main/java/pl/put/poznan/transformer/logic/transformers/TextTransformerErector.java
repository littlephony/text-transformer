package pl.put.poznan.transformer.logic.transformers;

import pl.put.poznan.transformer.logic.transforms.*;

/**
 * The TextTransformerErector class is responsible for constructing a transformer based on the specified transformations.
 * It provides a static method to erect a transformer by applying the specified transforms in order.
 */
public class TextTransformerErector {
    /**
     * Constructs a transformer based on the specified transformations.
     *
     * @param transforms an array of transformation names
     * @return the constructed transformer
     * @throws IllegalArgumentException if an unknown transformation name is encountered
     */
    public static Transformer erectTransformer(String[] transforms) throws IllegalArgumentException {
        Transformer transformer = new TextTransformer();
        for (String verbose : transforms) {
            TextTransform transform = TextTransform.get(verbose);
            if (transform == null) {
                throw new IllegalArgumentException("Unknown transformation name '" + verbose + "'");
            }

            switch (transform) {
                case CAPITALIZE:
                    transformer = new CapitalizeTextTransformerDecorator(transformer);
                    break;
                case CONVERT_NUMBERS:
                    transformer = new NumberToTextConverterTransformerDecorator(transformer);
                    break;
                case DEDUPLICATE:
                    transformer = new DeduplicateTextTransformerDecorator(transformer);
                    break;
                case EXPAND_ACRONYMS:
                    transformer = new ExpandAcronymTextTransformerDecorator(transformer);
                    break;
                case INVERSE:
                    transformer = new InverseTransformerDecorator(transformer);
                    break;
                case ESCAPE_LATEX:
                    transformer = new LatexTextTransformerDecorator(transformer);
                    break;
                case LOWER:
                    transformer = new LowerTextTransformerDecorator(transformer);
                    break;
                case REPLACE_ACRONYMS:
                    transformer = new ReplaceAcronymTextTransformerDecorator(transformer);
                    break;
                case UPPER:
                    transformer = new UpperTextTransformerDecorator(transformer);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown transformation name '" + verbose + "'");
            }
        }

        return transformer;
    }
}
