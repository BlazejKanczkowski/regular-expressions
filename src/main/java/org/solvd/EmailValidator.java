package org.solvd;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmailValidator {

    public static boolean isValidAutomationEmail(String email) {
        String currentDate = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);

        String regex = "^automation_" + currentDate + "_[a-zA-Z0-9]+@solvd\\.com$";

        return email.matches(regex);
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(isValidAutomationEmail("automation_20250711_a1b2c3@solvd.com")); // true (today's date is July 11, 2025)
        System.out.println(isValidAutomationEmail("automation_test_email@solvd.com"));       // false
    }
}