package pl.put.poznan.transformer.logic.transforms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.transformers.Transformer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.put.poznan.transformer.logic.transformers.TextTransformerErector.erectTransformer;

public class DeduplicateTextTransformerDecoratorTest {

    private Transformer transformer;

    @BeforeEach
    public void setUp() {
        transformer = erectTransformer(new String[]{"deduplicate"});
    }

    @Test
    public void testEliminateDuplicates() {
        // Test eliminating duplicate words
        assertEquals("This is a test.", transformer.transform("This is is a test."));
        assertEquals("I like apples, bananas, and oranges.", transformer.transform("I like apples, bananas, bananas, and oranges."));
    }

    @Test
    public void testNoDuplicates() {
        // Test text with no duplicate words
        String input = "This is a test.";
        assertEquals(input, transformer.transform(input));
    }

    @Test
    public void testSingleWord() {
        // Test text with a single word
        String input = "Hello";
        assertEquals(input, transformer.transform(input));
    }

    @Test
    public void testEmptyText() {
        // Test empty text
        String input = "";
        assertEquals(input, transformer.transform(input));
    }
}
