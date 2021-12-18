package lemmensthijmen.manager;

import lemmensthijmen.manager.enums.GameStates;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable {

    private Area area;
    private int seconds;

    public Countdown(Area area) {
        this.area = area;
        seconds = 30;
    }

    public void begin() {
        area.setStates(GameStates.COUNTDOWN);
        this.runTaskTimer(Main.getMain(), 0, 20);
    }

    @Override
    public void run() {
        if (seconds == 0) {
            cancel();
            Main.getMain().getManager().getArea().start();
            return;
        }

        if (seconds % 30 == 0 || seconds <= 10) {
            if (seconds == 1) {
                Main.getMain().getManager().getArea().sendMessage(ChatColor.GREEN + "game is starting");
            } else {
                Main.getMain().getManager().getArea().sendMessage(ChatColor.GREEN + "game is starting in " + seconds);
            }
        }

        if (Main.getMain().getManager().getArea().getPlayers().size() < 1) {
            cancel();
            Main.getMain().getManager().getArea().setStates(GameStates.PLAYERJOIN);
            Main.getMain().getManager().getArea().sendMessage(ChatColor.RED + "game canceld!");
            return;
        }

        seconds--;
    }
}
