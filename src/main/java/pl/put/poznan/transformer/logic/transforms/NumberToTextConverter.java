package pl.put.poznan.transformer.logic.transforms;

/**
 * The NumberToTextConverter class provides methods to convert numbers into their textual representation.
 */
public class NumberToTextConverter {
    private static final String[] units = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    private static final String[] thousands = {
            "", "thousand", "million", "billion", "trillion"
    };

    /**
     * Converts the given number into its textual representation.
     *
     * @param number the number to be converted
     * @return the textual representation of the number
     */
    public static String convert(int number) {
        if (number == 0) {
            return "zero";
        }

        String text = "";
        int index = 0;

        do {
            int num = number % 1000;
            if (num != 0) {
                String part = convertLessThanThousand(num);
                text = part + " " + thousands[index] + " " + text;
            }
            index++;
            number /= 1000;
        } while (number > 0);

        return text.trim();
    }

    /**
     * Converts a number less than a thousand into its textual representation.
     *
     * @param number the number to be converted
     * @return the textual representation of the number
     */
    private static String convertLessThanThousand(int number) {
        String current;

        if (number % 100 < 20) {
            current = units[number % 100];
            number /= 100;
        } else {
            current = units[number % 10];
            number /= 10;

            current = tens[number % 10] + " " + current;
            number /= 10;
        }

        if (number == 0) {
            return current;
        }

        return units[number] + " hundred " + current;
    }
}
