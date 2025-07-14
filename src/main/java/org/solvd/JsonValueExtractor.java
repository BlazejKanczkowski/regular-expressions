package org.solvd;

import java.util.regex.*;

public class JsonValueExtractor {

    public static String extractJsonValue(String json, String key) {
        String escapedKey = Pattern.quote(key);

        String regex = "\""+ escapedKey + "\"\\s*:\\s*(\"[^\"]*\"|'[^']*'|\\d+(\\.\\d+)?)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(json);

        if (matcher.find()) {
            String value = matcher.group(1);
            if ((value.startsWith("\"") && value.endsWith("\"")) || (value.startsWith("'") && value.endsWith("'"))) {
                value = value.substring(1, value.length() - 1);
            }
            return value;
        }

        return null;
    }

    public static void main(String[] args) {
        String json = "{\"key1\": 11, \"key2\": 'asd', \"key3\": 342}";
        String key = "key3";
        String value = extractJsonValue(json, key);
        System.out.println("Extracted value: " + value);  // expected 342
    }
}

