package io.github.hibixby.spigotpluginstudy.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Tickers {
    public static double getPrice(String coin_id) {
        double price = 0.0;
        String currency = "KRW";
        URI uri = URI.create("https://api.coinpaprika.com/v1/tickers/" + coin_id + "?quotes=" + currency);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.body());
        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        if(response.statusCode()==200) {
            price = jsonObject.get("quotes").getAsJsonObject().get("KRW").getAsJsonObject().get("price").getAsDouble();
        }
        else{
            throw new RuntimeException(jsonObject.get("error").getAsString());
        }
        return price;
    }
}
