package pl.put.poznan.transformer.logic.transforms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import pl.put.poznan.transformer.logic.transformers.Transformer;

public class CapitalizeTextTransformerDecoratorTest {
    @Test
    public void testTransform() {
        // create a mock Transformer
        Transformer mockTransformer = mock(Transformer.class);

        // set up behavior
        when(mockTransformer.transform(anyString())).thenReturn("hello world");

        // create a CapitalizeTextTransformerDecorator with the mock Transformer
        CapitalizeTextTransformerDecorator capitalizeTextTransformer = new CapitalizeTextTransformerDecorator(mockTransformer);

        // test the transform() method
        String result = capitalizeTextTransformer.transform("hello world");
        assertEquals("Hello world", result);

        // verify that transform method of mockTransformer was called exactly once with the argument "hello world"
        verify(mockTransformer, times(1)).transform("hello world");
    }
}

