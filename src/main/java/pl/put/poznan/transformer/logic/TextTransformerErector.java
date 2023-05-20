package pl.put.poznan.transformer.logic;

public class TextTransformerErector {
    public static Transformer erectTransformer(String[] transforms) {
        Transformer transformer = new TextTransformer();
        for (String transform : transforms) {
            switch (transform) {
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
