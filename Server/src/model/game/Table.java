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
    LinkedList<Player> players;                 //List of players in the correct order
    private HashMap<Player, Integer> stakes;    //List of players and their respective stakes
    private byte dealer;                        //Iterator, who is the dealer
    private int bigBlind;
    private int smallBlind;
    private Gamemode gamemode;                  //Class where all the settings are stored
    private Deck deck;                          //Deck
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
        dealer=0;
    }

    /**
     * All the action takes place in this method.
     *
     */
    public void playRound() throws Exception {
        Player dealer=null;

        //Deals cards to all players.
        deck.prepare();
        deal();

        //Determines who is dealer.
        if (this.dealer>=players.size()){
            this.dealer=0;
        }else {
            this.dealer++;
        }
        dealer=players.get(this.dealer);

        //Puts the Blinds on the table
        for (Player a:players){
            stakes.put(a,0);
        }
        putBlinds();

        //Starts betting
        bettingRound(getBigBlind());

        //

    }

    /**
     * Determines the blinds.
     * Finished
     */
    private void putBlinds(){
        byte smallBlind=0;
        byte bigBlind=0;
        if (dealer==players.size()){
            bigBlind=1;
        }else if ((dealer+1) == players.size()){
            smallBlind=(byte) (dealer+1);
            bigBlind=0;
        }else {
            smallBlind=dealer++;
            bigBlind=smallBlind++;
        }
        updateStakes(players.get(bigBlind), getBigBlind());
        updateStakes(players.get(smallBlind), getSmallBlind());
    }


    /**
     * Deals two cards to all players.
     * Finished
     */
    public void deal() throws Exception {
        Card[] hand=new Card[2];
        for (Player player : players){
            hand[0]=deck.draw();
            hand[1]=deck.draw();
            players.remove(player);
            player.setHand(hand);
            players.add(player);
        }
    }

    /**
     * Lets players bet on rounds.
     *TODO:WIP
     * Why?
     */
    public void bettingRound(int blind) throws Exception {
        int stake=blind;                                        //The amount wh
        int i=dealer+3;                                         //Betting starts with the player next to the big blind
        int option=0;                                           //-1 --> fold/check, 0--> Call, Any positive Amount-->Bet/Raise
        if (i>players.size()) i=i-players.size();               //Makes shure we don't access a player that doesn't exist.


        for(boolean openCalls=(blind!=0);openCalls;i++){        //If positions are still to be decided, the loop runs until everyone is set.
            if (i==players.size()) i = 0;
            option= players.get(i).setAmount(stake);            //Sends the decision request to the client.

            switch (option){                                    //Evaluates the options returned by the client.
                case-1:
                    pot+=stakes.get(players.get(i));
                    stakes.remove(players.get(i));
                    break;
                case 0:
                    break;

                default:
                    pot+=option;
                    //stakes.
                    break;
            }


        }

    }


    /**
     * Updates the stakes in a round for a specific player.
     * @param player
     * @param value
     * @return
     */
    private boolean updateStakes(Player player, int value){
        if (!stakes.containsKey(player))return false;
        stakes.replace(player, value);
        return true;
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

