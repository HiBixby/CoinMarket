package io.github.hibixby.spigotpluginstudy.commands;

import io.github.hibixby.spigotpluginstudy.api.Tickers;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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
        if (command.getName().equalsIgnoreCase("price")) {
            if (args.length == 0) {
                sender.sendMessage("코인 아이디를 입력해 주세요.");
            } else {
                double price;
                price = Tickers.getPrice(args[0]);
                sender.sendMessage(args[0] + "의 가격 : ", String.format("%1$,.2f",price));
            }
        }
        return true;
    }
}
