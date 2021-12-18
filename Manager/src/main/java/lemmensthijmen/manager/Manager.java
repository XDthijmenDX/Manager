package lemmensthijmen.manager;

import lemmensthijmen.manager.enums.GameStates;
import org.bukkit.entity.Player;

public class Manager {

    private Area area;

    public Manager() {
        area = new Area();
    }

    public boolean isPlaying(Player player) {
        return area.getPlayers().contains(player.getUniqueId());
    }

    public boolean isPlayerJoin() {
        return area.getStates() == GameStates.PLAYERJOIN;
    }

    public Area getArea() {
        return area;
    }
}
