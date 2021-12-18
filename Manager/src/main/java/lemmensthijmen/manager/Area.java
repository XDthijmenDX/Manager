package lemmensthijmen.manager;

import lemmensthijmen.manager.enums.GameStates;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class Area {

    private ArrayList<UUID> players;
    private GameStates states;
    private Game game;
    private Countdown countdown;

    public Area() {
        players = new ArrayList<>();
        states = GameStates.PLAYERJOIN;
        game = new Game(this);
        countdown = new Countdown(this);
    }

//    start the game

    public void start() {
        game.begin();
    }

//    reset the whole game

    public void reset() {
        for (UUID uuid : players) {
            Bukkit.getPlayer(uuid).teleport(new Location(Bukkit.getWorld("world"), 0 ,0 ,0)); // hier moet je loc zetten
        }

        players.clear();
        states = GameStates.PLAYERJOIN;
        countdown = new Countdown(this);
        game = new Game(this);
    }

//    sends a message

    public void sendMessage(String message) {
        for (UUID uuid : players) {
            Bukkit.getPlayer(uuid).sendMessage(message);
        }
    }

//    adds a player to the list

    public void addPlayers(Player player) {
        players.add(player.getUniqueId());

        player.teleport(new Location(Bukkit.getWorld("world"), 10 , 10 ,10)); // hier moet je loc zetten

        if (players.size() >= 2) {
            countdown.begin();
        }
    }

//    removed player

    public void removePlayers(Player player) {
        players.remove(player.getUniqueId());

        player.teleport(new Location(Bukkit.getWorld("world"), 0, 0,0)); // hier moet je loc zetten
    }

    public ArrayList<UUID> getPlayers() {
        return players;
    }

    public GameStates getStates() {
        return states;
    }

    public void setStates(GameStates states) {
        this.states = states;
    }
}
