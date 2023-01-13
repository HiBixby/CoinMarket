package io.github.hibixby.coinmarket.commands;

import io.github.hibixby.coinmarket.api.Tickers;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.math.BigDecimal;

public class PriceCommand implements CommandExecutor {


    /**
     * Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("coinprice")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.DARK_RED + "코인 아이디를 입력해 주세요.");
            } else {
                try {
                    BigDecimal price = Tickers.getPrice(args[0]);
                    sender.sendMessage(ChatColor.GOLD + args[0] + "의 가격 : " + String.format("%1$,.2f", price));
                } catch (RuntimeException e) {
                    sender.sendMessage(ChatColor.DARK_RED + e.getMessage());
                }
            }
        }
        return true;
    }
}
