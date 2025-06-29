package com.nivila;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import org.json.JSONObject;
public class WeatherApp 
{
    public static void main(String[] args) 
    {
        String apiKey = "ace460cc0b3cfe15474efc72decb1549";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter city name: ");
        String city = scanner.nextLine().trim();
        scanner.close();
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city +"&appid=" + apiKey + "&units=metric";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))[].build();
        try 
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            System.out.println("Raw response:\n" + responseBody);
            JSONObject json = new JSONObject(responseBody);
            if (json.has("cod")) 
            {
                String code = json.get("cod").toString();
                if (!code.equals("200")) 
                {
                    String message = json.has("message") ? json.getString("message") : "Unknown error";
                    System.out.println("API Error: " + message);
                    return;
                }
            }
            String cityName = json.getString("name");
            JSONObject main = json.getJSONObject("main");
            double temp = main.getDouble("temp");
            double feelsLike = main.getDouble("feels_like");
            JSONObject weather = json.getJSONArray("weather").getJSONObject(0);
            String description = weather.getString("description");
            System.out.println("\n--- Weather Report ---");
            System.out.println("City: " + cityName);
            System.out.println("Temperature: " + temp + " °C");
            System.out.println("Feels Like: " + feelsLike + " °C");
            System.out.println("Weather: " + description);
        } 
        catch (Exception e) 
        {
            System.out.println("❌ Error fetching weather data: " + e.getMessage());
        }
    }
}
