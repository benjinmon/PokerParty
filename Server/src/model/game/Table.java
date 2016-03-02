package model.game;

import model.game.Deck;
import model.game.Gamemode;
import model.game.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.function.Consumer;

/**
 * Created by Matthias Walk on 10.02.2016.
 * Class of the project: PokerParty
 * All the action takes place in this class.
 */
public class Table {
    LinkedList<Player> players;
    private int bigBlind;
    private int smallBlind;
    private Gamemode gamemode;
    private Deck deck;
    private long pot;
    private int time;



    public Table(Gamemode gamemode, ArrayList<Player> players) throws Exception {
        setGamemode(gamemode);                          //Gamemode determines everything else.
        this.deck=new Deck();
        setBigBlind(getGamemode().getBigBlind(0));      //Determined by starting blinds in gamemode.
        setSmallBlind(getGamemode().getSmallBlind(0));  //

                                                        //Gives each player a stack of predetermined size and substracts it from his/her total money
        for (Player a: players){
            a.setStack(getGamemode().getBuyIn());
            a.setTotalMoney(a.getStack()-getGamemode().getBuyIn());
        }
    }

    /**
     * All the acion takes place in this method.
     *
     */
    public void playRound() throws Exception {
        deck.prepare();
        deal();
        bettingRound();     //Pre-Flop
        flop();             //Flop
        bettingRound();     //Post-Flop
        oneCard();          //Turn
        bettingRound();     //Turn
        oneCard();          //River
        bettingRound();     //River
        showdown();         //Showdown


    }

    /**
     * WIP
     */
    private void showdown(){

    }

    /**
     * WIP
     */
    private void oneCard(){

    }

    /**
     * WIP
     */
    private void flop(){

    }

    /**
     *WIP
     */
    private void bettingRound() throws Exception {
        long pot=getGamemode().getBigBlind(time);
        long amount=0;
        for (Player player:players){
            amount=player.setAmount();
            if (pot==0){
                //
            }else if (amount>=(pot*2)) {

            }
        }
    }






    /**
     * Deals two cards to all players.
     * Finished
     */
    private void deal() throws Exception {
        Card[] hand=new Card[2];
        for (Player player : players){
            hand[0]=deck.draw();
            hand[1]=deck.draw();
            players.remove(player);
            player.setHand(hand);
            players.add(player);
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

