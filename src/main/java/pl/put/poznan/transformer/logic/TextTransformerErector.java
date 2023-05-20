package pl.put.poznan.transformer.logic;

public class TextTransformerErector {
    public static Transformer erectTransformer(String[] transforms) {
        Transformer transformer = new TextTransformer();
        for (String transform : transforms) {
            switch (transform) {
                case "expandAcronyms":
                    transformer = new ExpandAcronymTextTransformerDecorator(transformer);
                    break;
                case "replaceAcronyms":
                    transformer = new ReplaceAcronymTextTransformerDecorator(transformer);
                    break;
                case "capitalize":
                    transformer = new CapitalizeTextTransformerDecorator(transformer);
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
