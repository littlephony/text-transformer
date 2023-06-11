package pl.put.poznan.transformer.logic.transforms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.transformers.Transformer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.put.poznan.transformer.logic.transformers.TextTransformerErector.erectTransformer;


public class NumberToTextTransformerDecoratorTest {

    private Transformer transformer;

    @BeforeEach
    public void setUp() {
        transformer = erectTransformer(new String[]{"convertNumbers"});
    }

    @Test
    public void testConvertZero() {
        // Test converting zero
        assertEquals("zero", transformer.transform("0"));
    }

    @Test
    public void testConvertSingleDigitNumbers() {
        // Test converting single-digit numbers
        assertEquals("one", transformer.transform("1"));
        assertEquals("two", transformer.transform("2"));
        assertEquals("three", transformer.transform("3"));
        // Add more tests for other single-digit numbers
    }

    @Test
    public void testConvertTeenNumbers() {
        // Test converting teen numbers
        assertEquals("ten", transformer.transform("10"));
        assertEquals("eleven", transformer.transform("11"));
        assertEquals("twelve", transformer.transform("12"));
        // Add more tests for other teen numbers
    }

    @Test
    public void testConvertTensNumbers() {
        // Test converting tens numbers
        assertEquals("twenty", transformer.transform("20"));
        assertEquals("thirty", transformer.transform("30"));
        assertEquals("forty", transformer.transform("40"));
        // Add more tests for other tens numbers
    }

    @Test
    public void testConvertCompositeNumbers() {
        // Test converting composite numbers
        assertEquals("twenty one", transformer.transform("21"));
        assertEquals("thirty five", transformer.transform("35"));
        assertEquals("forty nine", transformer.transform("49"));
        // Add more tests for other composite numbers
    }

    @Test
    public void testConvertHundredNumbers() {
        // Test converting hundred numbers
        assertEquals("one hundred", transformer.transform("100"));
        assertEquals("two hundred", transformer.transform("200"));
        assertEquals("three hundred", transformer.transform("300"));
        // Add more tests for other hundred numbers
    }

    @Test
    public void testConvertThousandsNumbers() {
        // Test converting thousands numbers
        assertEquals("one thousand", transformer.transform("1000"));
        assertEquals("two thousand", transformer.transform("2000"));
        assertEquals("three thousand", transformer.transform("3000"));
        // Add more tests for other thousands numbers
    }

    @Test
    public void testConvertMillionNumbers() {
        // Test converting million numbers
        assertEquals("one million", transformer.transform("1000000"));
        assertEquals("two million", transformer.transform("2000000"));
        assertEquals("three million", transformer.transform("3000000"));
        // Add more tests for other million numbers
    }

    @Test
    public void testConvertBillionNumbers() {
        // Test converting billion numbers
        assertEquals("one billion", transformer.transform("1000000000"));
        assertEquals("two billion", transformer.transform("2000000000"));
    }

    @Test
    public void testNonNumericInput() {
        // Test non-numeric input
        String input = "Donate 100 dollars";
        assertEquals("Donate one hundred dollars", transformer.transform(input));

        input = "Hello World!";
        assertEquals("Hello World!", transformer.transform(input));
    }
}



