package pl.put.poznan.transformer.logic.transforms;

import pl.put.poznan.transformer.logic.Transformer;

/**
 * The NumberToTextConverterTransformerDecorator class is a decorator that converts numbers in a text to their textual representation.
 * It extends the TextTransformerDecorator class.
 */
public class NumberToTextConverterTransformerDecorator extends TextTransformerDecorator {

    /**
     * Constructs a NumberToTextConverterTransformerDecorator object with the specified transformer.
     *
     * @param transformer the transformer to be decorated
     */
    public NumberToTextConverterTransformerDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * Transforms the given text by converting numbers to their textual representation.
     *
     * @param text the text to be transformed
     * @return the transformed text with numbers converted to text
     */
    @Override
    public String transform(String text) {
        text = super.transform(text);

        String[] words = text.split("\\s+");
        StringBuilder transformedText = new StringBuilder();

        for (String word : words) {
            if (isNumeric(word)) {
                try {
                    int number = Integer.parseInt(word);
                    String convertedText = NumberToTextConverter.convert(number);
                    transformedText.append(convertedText).append(" ");
                } catch (NumberFormatException e) {
                    // If the input is not a valid number, simply append the original word
                    transformedText.append(word).append(" ");
                }
            } else {
                transformedText.append(word).append(" ");
            }
        }

        return transformedText.toString().trim();
    }

    /**
     * Checks if a given word is numeric.
     *
     * @param word the word to be checked
     * @return true if the word is numeric, false otherwise
     */
    private boolean isNumeric(String word) {
        return word.matches("\\d+");
    }

}