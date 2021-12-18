package lemmensthijmen.manager.commands;

import lemmensthijmen.manager.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {

    public TestCommand() {
        Main.getMain().getCommand("test").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        player.sendMessage(String.valueOf(Main.getMain().getManager().getArea().getPlayers()));

        return false;
    }
}
