package org.solvd;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.*;

public class PhoneNumberExtractor {

    private static final Set<String> ALLOWED_PREFIXES = Set.of(
            "1", "86", "91", "62", "55", "92", "234", "880", "7", "52",
            "81", "63", "20", "49", "33"
    );

    public static List<String> extractPhoneNumbers(String text) {
        List<String> phoneNumbers = new ArrayList<>();

        String phoneRegex = "\\+?\\d{1,4}[\\s-]?(\\(?\\d{1,4}\\)?[\\s-]?)*\\d{3,4}";

        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String rawNumber = matcher.group();
            String cleanedNumber = rawNumber.replaceAll("[^\\d]", ""); // tylko cyfry

            for (String prefix : ALLOWED_PREFIXES) {
                if (cleanedNumber.startsWith(prefix)) {
                    phoneNumbers.add(cleanedNumber);
                    break;
                }
            }
        }

        return phoneNumbers;
    }

    public static void main(String[] args) {
        String input = "Call +1 (123) 456-7890, +91-98765-43210, or +44 20 7946 0958.";    // +44 not allowed
        List<String> result = extractPhoneNumbers(input);
        for (String number : result) {
            System.out.println(number);
        }
    }
}


