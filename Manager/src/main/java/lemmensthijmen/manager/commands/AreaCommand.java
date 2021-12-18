package lemmensthijmen.manager.commands;

import lemmensthijmen.manager.Main;
import lemmensthijmen.manager.enums.GameStates;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AreaCommand implements CommandExecutor {

    public AreaCommand() {
        Main.getMain().getCommand("area").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            switch (args[0]) {
                case "join" -> {
                    if (Main.getMain().getManager().isPlaying(player)) {
                        player.sendMessage(ChatColor.RED + "you are in the game!");
                    } else {
                        Main.getMain().getManager().getArea().addPlayers(player);
                    }
                }
                case "leave" -> {
                    if (Main.getMain().getManager().getArea().getStates() == GameStates.COUNTDOWN) {
                        Main.getMain().getManager().getArea().removePlayers(player);
                    } else {
                        player.sendMessage(ChatColor.RED + "Game is live!");
                    }
                }
                case "reset" -> {
                    if (player.isOp()) {
                        Main.getMain().getManager().getArea().reset();
                    }
                }
                default -> player.sendMessage(ChatColor.RED + "Wrong command!");
            }
        }

        return false;
    }
}
