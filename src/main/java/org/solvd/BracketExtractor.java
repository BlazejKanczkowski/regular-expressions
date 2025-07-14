package org.solvd;

public class BracketExtractor {

    public static String extractBetweenBrackets(String input) {
        int start = input.indexOf('[');
        int end = input.indexOf(']');

        if (start != -1 && end != -1 && start < end) {
            return input.substring(start + 1, end);
        }
        return "";
    }

    public static void main(String[] args) {
        String input = "ignore me [extract:me] ignore me!";
        String extracted = extractBetweenBrackets(input);
        System.out.println("text: " + extracted);
    }
}

