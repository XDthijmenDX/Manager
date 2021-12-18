package lemmensthijmen.manager;

import lemmensthijmen.manager.enums.GameStates;

public class Game {

    private Area area;

    public Game(Area area) {
        this.area = area;
    }

    public void begin() {
        area.setStates(GameStates.LIVE);
        /*
         * hier moet je je game in doen en een arparte class maken voor de @eventhandler
         * hier moet je ook neer zetten hoe de game stopt
         */
    }
}
