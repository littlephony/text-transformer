package pl.put.poznan.transformer.logic.transforms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.transformers.Transformer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.put.poznan.transformer.logic.transformers.TextTransformerErector.erectTransformer;

public class ReplaceAcronymTextTransformerDecoratorTest {

    private Transformer transformer;

    @BeforeEach
    public void setUp() {
        transformer = erectTransformer(new String[]{"replaceAcronyms"});
    }

    @Test
    public void testReplaceAcronyms() {
        // Test replacing word acronyms
        assertEquals("This is e.g. a test.", transformer.transform("This is for example a test."));
        assertEquals("I like apples, bananas, etc..", transformer.transform("I like apples, bananas, and so on."));
        assertEquals("That is correct, i.e. true.", transformer.transform("That is correct, that is true."));
    }

    @Test
    public void testNoAcronyms() {
        // Test text with no word acronyms
        String input = "This is a test.";
        assertEquals(input, transformer.transform(input));
    }

    @Test
    public void testPartialMatch() {
        // Test partial match of word acronyms
        String input = "This is an example.";
        assertEquals(input, transformer.transform(input));
    }

    @Test
    public void testMultipleAcronyms() {
        // Test multiple word acronyms in a sentence
        String input = "I like apples, bananas, etc. That is correct, i.e. true.";
        assertEquals("I like apples, bananas, etc. That is correct, i.e. true.", transformer.transform(input));
    }
}
