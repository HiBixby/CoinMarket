package io.github.hibixby.coinmarket;

import io.github.hibixby.coinmarket.commands.BuyCommand;
import io.github.hibixby.coinmarket.commands.PriceCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class CoinMarket extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("플러그인 로딩됨.");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("coinprice").setExecutor(new PriceCommand());
        getCommand("coinbuy").setExecutor(new BuyCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("플러그인 종료됨.");
    }
}
