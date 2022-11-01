package com.wantensoup.prototype.GetDateAPI;

/**
 * Last Updated: 10/31/2022 Class Purpose: Create a formatted String to display
 * the current date and time.
 * @author Kristin Cattell
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDate {

    public String createSubstring(String date) {
        String formattedDate = null;

        for (int i = date.length() - 1; i >= 0; i--) {
            if (date.charAt(i) == '-') {
                formattedDate = date.substring(0, i);
                break;
            }
        }

        return formattedDate;
    }

    public String createFormattedDate(String date) {
        LocalDateTime dateTime = LocalDateTime.parse(date);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM dd, YYYY h:mm a");

        return dateFormat.format(dateTime);
    }
    
}
