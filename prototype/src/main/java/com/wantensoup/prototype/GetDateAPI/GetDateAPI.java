package com.wantensoup.prototype.GetDateAPI;

/**
 * Last Updated: 11/14/2022
 * Class Purpose: Calls an API that will then parse out and format the current 
 * date and time.
 * @author Kristin Cattell
 */
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetDateAPI extends FormatDate {

    public String parseAPI() throws URISyntaxException, IOException, InterruptedException {
        Time time;
        Gson gson = new Gson();
        String date, dateSubstring;

        //Creates a new Http Request to the API.
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("http://worldtimeapi.org/api/timezone/America/New_York"))
                .build();
        
        //Sends the http request.
        HttpClient httpClient = HttpClient.newHttpClient();

        //Gets the response from the API.
        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

        //Converts the response body from Json to String and parse out the current date and time into String date.
        time = gson.fromJson(getResponse.body(), Time.class);
        date = time.getDatetime();

        //Creates a substring that can be parsed by LocalDateTime.
        dateSubstring = createSubstring(date);

        //Return formatted date to display on page.
        return createFormattedDate(dateSubstring);
    }
    
}
