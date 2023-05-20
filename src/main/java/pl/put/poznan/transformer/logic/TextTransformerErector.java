package pl.put.poznan.transformer.logic;

public class TextTransformerErector {
    public static Transformer erectTransformer(String[] transforms) {
        Transformer transformer = new TextTransformer();
        for (String transform : transforms) {
            switch (transform) {
                case "capitalize":
                    transformer = new CapitalizeTextTransformerDecorator(transformer);
                    break;
                case "convertNumbers":
                    transformer = new NumberToTextConverterTransformerDecorator(transformer);
                case "expandAcronyms":
                    transformer = new AcronymTextTransformerDecorator(transformer);
                    break;
                case "inverse":
                    transformer = new InverseTransformerDecorator(transformer);
                case "lower":
                    transformer = new LowerTextTransformerDecorator(transformer);
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
