package pl.put.poznan.transformer.logic;

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
    public static Transformer erectTransformer(String[] transforms) {
        Transformer transformer = new TextTransformer();
        for (String transform : transforms) {
            switch (transform) {
                case "capitalize":
                    transformer = new CapitalizeTextTransformerDecorator(transformer);
                    break;
                case "convertNumbers":
                    transformer = new NumberToTextConverterTransformerDecorator(transformer);
                    break;
                case "expandAcronyms":
                    transformer = new ExpandAcronymTextTransformerDecorator(transformer);
                    break;
                case "inverse":
                    transformer = new InverseTransformerDecorator(transformer);
                    break;
                case "lower":
                    transformer = new LowerTextTransformerDecorator(transformer);
                    break;
                case "replaceAcronyms":
                    transformer = new ReplaceAcronymTextTransformerDecorator(transformer);
                    break;
                case "upper":
                    transformer = new UpperTextTransformerDecorator(transformer);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown transformation name '" + transform + "'");
            }
        }
        return transformer;
    }
}
