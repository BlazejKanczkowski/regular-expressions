package org.solvd;

public class RepeatingCharacterGrouper {

    public static String groupRepeatingCharacters(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        char lastChar = input.charAt(0);
        result.append(lastChar);

        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current != lastChar) {
                result.append(current);
                lastChar = current;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "qqqqqqqweeeeerrtyyyyyyUUUUuuiTT";
        String grouped = groupRepeatingCharacters(input);
        System.out.println("Grouped characters: " + grouped);
    }
}

