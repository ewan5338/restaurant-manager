package com.wantensoup.prototype.GetDateAPI;

/**
 * Last Updated: 10/31/2022 Class Purpose: Calls an API that will then parse out
 * and format the current date and time.
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

        //Sends Http Request to the API.
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://world-clock.p.rapidapi.com/json/est/now"))
                .headers("X-RapidAPI-Key", "4113e34ee0msh81c36da3c7bb166p1f439ejsn1e4374254c55",
                        "X-RapidAPI-Host", "world-clock.p.rapidapi.com")
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        //Gets the reponse from the API.
        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

        //Converts the reponse from Json to String and parses out the current date and time into String date.
        time = gson.fromJson(getResponse.body(), Time.class);
        date = time.getCurrentDateTime();

        //Creates a substring that can be parsed by LocalDateTime.
        dateSubstring = createSubstring(date);

        //Return formatted date to display on page.
        return createFormattedDate(dateSubstring);
    }
    
}
