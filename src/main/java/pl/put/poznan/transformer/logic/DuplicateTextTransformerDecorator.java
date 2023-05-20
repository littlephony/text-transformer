package pl.put.poznan.transformer.logic;

public class DuplicateTextTransformerDecorator extends TextTransformerDecorator {
    DuplicateTextTransformerDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        return eliminateDuplicates(super.transform(text));
    }

    private String eliminateDuplicates(String text) {
        StringBuilder processedText = new StringBuilder();
        String[] words = text.split(" ");

        for (int i = 0; i < words.length; ++i) {
            if (i == words.length  - 1 || !words[i].equals(words[i + 1])) {
                processedText.append(words[i]).append(" ");
            }
        }

        return processedText.toString().trim();
    }
}
