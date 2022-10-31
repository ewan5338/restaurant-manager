package com.wantensoup.prototype.GetDateAPI;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Kristin Cattell
 */
public class GetDateAPI {
    public String parseAPI() throws URISyntaxException, IOException, InterruptedException {

        Time time;
        Gson gson = new Gson();
        String date;
        String formattedDate = null;

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://world-clock.p.rapidapi.com/json/est/now"))
                .headers("X-RapidAPI-Key", "4113e34ee0msh81c36da3c7bb166p1f439ejsn1e4374254c55",
                        "X-RapidAPI-Host", "world-clock.p.rapidapi.com")
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(getResponse.body());

        time = gson.fromJson(getResponse.body(), Time.class);
        date = time.getCurrentDateTime();
        
        for (int i = date.length() - 1; i >= 0; i--) {
            if(date.charAt(i) == '-') {
                formattedDate = date.substring(0, i);
                break;
            }
        }
        
        LocalDateTime dateTime = LocalDateTime.parse(formattedDate);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM dd, YYYY h:mm a");
        
        return dateFormat.format(dateTime);
    }
}

