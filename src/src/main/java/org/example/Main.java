package org.example;

import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the username:");
        String username= sc.next();
        final String BASE_URL= "https://api.github.com/users/"+username+"/events";
        URI uri= URI.create(BASE_URL);

        HttpRequest.Builder builder = HttpRequest.newBuilder();
        builder.uri(uri);
        builder.GET();
        builder.timeout(Duration.ofMillis(5000));
        HttpRequest request= builder.build();

        HttpClient client= HttpClient.newHttpClient();
        HttpResponse <String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
    }
}