package model;

import java.util.ArrayList;

/**
 * Created by Matthias Walk on 10.02.2016.
 * Class of the project: PokerParty
 */
public class Table {
    ArrayList<Player> players;
    private int bigBlind;
    private int smallBlind;
    private Gamemode gamemode;


    public Table(Gamemode gamemode) {

    }

    public Gamemode getGamemode() {
        return gamemode;
    }

    public void setGamemode(Gamemode gamemode) throws Exception {
        if (gamemode != null) throw new Exception("This object is null");
        this.gamemode = gamemode;
    }
}

