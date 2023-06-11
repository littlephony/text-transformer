package pl.put.poznan.transformer.logic.transforms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.transformers.Transformer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.put.poznan.transformer.logic.transformers.TextTransformerErector.erectTransformer;

public class ExpandAcronymTextTransformerDecoratorTest {

    private Transformer transformer;

    @BeforeEach
    public void setUp() {
        transformer = erectTransformer(new String[]{"expandAcronyms"});
    }

    @Test
    public void testExpandAcronyms() {
        // Test expanding acronyms
        assertEquals("Miss", transformer.transform("Ms."));
        assertEquals("Mister", transformer.transform("Mr."));
        assertEquals("Professor", transformer.transform("Prof."));
        assertEquals("Doctor", transformer.transform("Dr."));
    }

    @Test
    public void testNoAcronyms() {
        // Test text with no acronyms
        String input = "This is a test.";
        assertEquals(input, transformer.transform(input));
    }

    @Test
    public void testMultipleAcronyms() {
        // Test multiple acronyms in a sentence
        String input = "Hello, Mr. Smith! How are you, Dr. Johnson?";
        assertEquals("Hello, Mister Smith! How are you, Doctor Johnson?", transformer.transform(input));
    }

    @Test
    public void testUnknownAcronyms() {
        // Test unknown acronyms
        String input = "I met a UFO and saw an ET.";
        assertEquals(input, transformer.transform(input));
    }
}
