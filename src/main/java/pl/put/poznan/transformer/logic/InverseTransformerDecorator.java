package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

/**
 * The InverseTransformerDecorator class is a decorator that performs inverse transformation on a given text,
 * reversing the sequence of characters while retaining the case of letters in specific positions.
 * It extends the TextTransformerDecorator class.
 */
public class InverseTransformerDecorator extends TextTransformerDecorator {

    /**
     * Constructs an instance of the InverseTransformerDecorator class.
     *
     * @param transformer The Transformer object to be decorated.
     */
    public InverseTransformerDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * Transforms the given text by reversing the sequence of characters while retaining the case
     * of letters in specific positions.
     *
     * @param text The input text to be transformed.
     * @return The transformed text.
     */
    @Override
    public String transform(String text) {
        text = super.transform(text);

        char[] characters = text.toCharArray();
        int length = characters.length;
        ArrayList<Integer> upperPositions = findUpperPositions(text);

        reverseWithCaseRetention(characters, length, upperPositions);
        text = new String(characters);
        return text;
    }

    /**
     * Finds the positions of uppercase characters in the given text.
     *
     * @param text The input text.
     * @return An ArrayList containing the positions of uppercase characters.
     */
    private ArrayList<Integer> findUpperPositions(String text) {
        ArrayList<Integer> upperPositions = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                upperPositions.add(i);
            }
        }

        return upperPositions;
    }

    /**
     * Reverses the characters in the given character array while retaining the case of letters
     * at specific positions defined by the upperPositions ArrayList.
     *
     * @param characters     The character array to be reversed and modified.
     * @param length         The length of the character array.
     * @param upperPositions The ArrayList containing the positions of uppercase characters.
     */
    private void reverseWithCaseRetention(char[] characters, int length, ArrayList<Integer> upperPositions) {
        for (int i = 0; i < length / 2; i++) {
            char temp = characters[i];
            characters[i] = characters[length - i - 1];
            characters[length - i - 1] = temp;
        }
        for (int i = 0; i < length; i++) {
            char character = characters[i];
            if (upperPositions.contains(i)) {
                character = Character.toUpperCase(character);
            } else {
                character = Character.toLowerCase(character);
            }
            characters[i] = character;
        }
    }
}
