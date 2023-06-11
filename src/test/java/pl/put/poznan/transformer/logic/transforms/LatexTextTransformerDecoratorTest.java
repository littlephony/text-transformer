package pl.put.poznan.transformer.logic.transforms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.transformers.Transformer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.put.poznan.transformer.logic.transformers.TextTransformerErector.erectTransformer;

public class LatexTextTransformerDecoratorTest {

    private Transformer transformer;

    @BeforeEach
    public void setUp() {
        transformer = erectTransformer(new String[]{"escape"});
    }

    @Test
    public void testConvertSpecialCharacters() {
        // Test converting special characters to LaTeX representation
        assertEquals("\\&", transformer.transform("&"));
        assertEquals("\\%", transformer.transform("%"));
        assertEquals("\\$", transformer.transform("$"));
        assertEquals("\\#", transformer.transform("#"));
        assertEquals("\\_", transformer.transform("_"));
        assertEquals("\\{", transformer.transform("{"));
        assertEquals("\\}", transformer.transform("}"));
        assertEquals("\\textasciitilde", transformer.transform("~"));
        assertEquals("\\textasciicircum", transformer.transform("^"));
    }

    @Test
    public void testNoSpecialCharacters() {
        // Test text with no special characters
        String input = "This is a test.";
        assertEquals(input, transformer.transform(input));
    }

    @Test
    public void testMixedText() {
        // Test text with mixed characters
        String input = "Special & characters ^ need % to $ be escaped.";
        String expectedOutput = "Special \\& characters \\textasciicircum need \\% to \\$ be escaped.";
        assertEquals(expectedOutput, transformer.transform(input));
    }

    // Add more test methods to cover different special characters and edge cases

    @Test
    public void testNonNumericInput() {
        // Test non-numeric input
        String input = "Hello World!";
        assertEquals("Hello World!", transformer.transform(input));
    }
}
