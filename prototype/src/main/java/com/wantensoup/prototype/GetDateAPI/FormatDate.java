package com.wantensoup.prototype.GetDateAPI;

/**
 * Last Updated: 11/01/2022
 * Class Purpose: Create a formatted String to display the current date and time.
 * @author Kristin Cattell
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDate {

    public String createSubstring(String _date) {
        String formattedDate = null;

        for (int i = _date.length() - 1; i >= 0; i--) {
            if (_date.charAt(i) == '-') {
                formattedDate = _date.substring(0, i);
                break;
            }
        }

        return formattedDate;
    }

    public String createFormattedDate(String _date) {
        LocalDateTime dateTime = LocalDateTime.parse(_date);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM dd, YYYY h:mm a");

        return dateFormat.format(dateTime);
    }
    
}
