package model.game;

import model.game.Deck;
import model.game.Gamemode;
import model.game.Player;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Matthias Walk on 10.02.2016.
 * Class of the project: PokerParty
 * All the action takes place in this class.
 */
public class Table {
    ArrayList<Player> players;
    private int bigBlind;
    private int smallBlind;
    private Gamemode gamemode;
    private Deck deck;
    private long pot;
    private HashMap<Player, Card[]> hands;



    public Table(Gamemode gamemode, ArrayList<Player> players) throws Exception {
        setGamemode(gamemode);                          //Gamemode determines everything else.
        this.deck=new Deck();
        setBigBlind(getGamemode().getBigBlind(0));      //Determined by starting blinds in gamemode.
        setSmallBlind(getGamemode().getSmallBlind(0));  //

        if (players.size()>getGamemode().getMaxPlayers() || players.size()<getGamemode().getMinPlayers()) {
            throw new Exception("Invalid amount of players!");
        }
        for (Player player : this.players){
            player.setStack(getGamemode().getBuyIn());
            this.players.add(player);
        }




        playRound();
    }

    /**
     * All the acion takes place in this method.
     */
    public void playRound() throws Exception {
        deck.prepare();
        deal();


    }

    /**
     * Deals two cards to all players.
     */
    private void deal(){
        hands.clear();
        Card[] hand=new Card[2];
        for (Player player : players){
            hand[1]=deck.draw();
            hand[2]=deck.draw();
            hands.put(player, hand);
        }
    }




    public Gamemode getGamemode() {
        return gamemode;
    }

    public void setGamemode(Gamemode gamemode) throws Exception {
        if (gamemode != null) throw new Exception("This object is null");
        this.gamemode = gamemode;
    }

    public int getSmallBlind() {
        return smallBlind;
    }

    public void setSmallBlind(int smallBlind) throws Exception {
        if (smallBlind<1)throw new Exception("The small blint must not be below 1!");
        this.smallBlind = smallBlind;
    }

    public int getBigBlind() {
        return bigBlind;
    }

    public void setBigBlind(int bigBlind) throws Exception {
        if (bigBlind<1)throw new Exception("The big blind must not be below 1!");
        this.bigBlind = bigBlind;
    }
}

