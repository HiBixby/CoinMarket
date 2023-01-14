package io.github.hibixby.coinmarket.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.hibixby.coinmarket.CoinMarket;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Tickers {
    private static final Plugin coinMarket = CoinMarket.getPlugin(CoinMarket.class);
    private static final String currency = coinMarket.getConfig().getString("currency");

    public static BigDecimal getPrice(String coin_id) {
        BigDecimal price = BigDecimal.valueOf(-1);
        URI uri = URI.create("https://api.coinpaprika.com/v1/tickers/" + coin_id + "?quotes=" + currency);
        HttpResponse<String> response = CoinpaprikaAPI.GET(uri);
        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        if (response.statusCode() == 200) {
            price = jsonObject.get("quotes").getAsJsonObject().get(currency).getAsJsonObject().get("price").getAsBigDecimal();
        } else {
            throw new RuntimeException(jsonObject.get("error").getAsString());
        }
        return price;
    }
}
