package model;

/**
 * Created by Matthias Walk on 10.02.2016.
 * Class of the project: PokerParty
 */
public class Gamemode {
    private String name;
    private int buyIn;                  //Amount of initial money each player gets.
    private int nrOfReBuys;             //How often a player can re-buy, no negative v allowed, except for -1, which is infinite.
    private int reBuy;
    private boolean open;
    private int[][] blindStructure;     //

}
