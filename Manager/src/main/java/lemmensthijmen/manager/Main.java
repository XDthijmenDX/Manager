package lemmensthijmen.manager;

import lemmensthijmen.manager.commands.AreaCommand;
import lemmensthijmen.manager.commands.TestCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main main;
    private Manager manager;

    @Override
    public void onEnable() {
        Main.main = this;
        manager = new Manager();

        new AreaCommand();
        new TestCommand();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getMain() {
        return main;
    }

    public Manager getManager() {
        return manager;
    }
}
