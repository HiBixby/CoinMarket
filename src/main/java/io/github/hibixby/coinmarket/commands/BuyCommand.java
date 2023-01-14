package io.github.hibixby.coinmarket.commands;

import io.github.hibixby.coinmarket.api.Tickers;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.math.BigDecimal;

public class BuyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "This command must be executed by a player");
            return true;
        }
        if (args.length < 2) {
            return false;
        } else {
            BigDecimal price = Tickers.getPrice(args[0]);
            int amount = Integer.parseInt(args[1]);
            sender.sendMessage(args[0] + " " + args[1] + "개의 가격 : " + price.multiply(BigDecimal.valueOf(amount)));
        }
        return true;
    }
}
