package io.github.hibixby.spigotpluginstudy;

import io.github.hibixby.spigotpluginstudy.commands.PriceCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class SpigotPluginStudy extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("플러그인 로딩됨.");
        getCommand("price").setExecutor(new PriceCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("플러그인 종료됨.");
    }
}
