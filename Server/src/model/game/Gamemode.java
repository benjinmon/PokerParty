package model.game;

/**
 * Created by Matthias Walk on 10.02.2016.
 * Class of the project: PokerParty
 */
public class Gamemode {
    private String name;
    private int buyIn;                  //Amount of initial money each player gets.
    private int nrOfReBuys;             //How often a player can re-buy, no negative v allowed, except for -1, which is infinite.
    private int reBuy;                  //Amount
    private boolean open;
    private int[] bigBlind;
    private int[] smallBlind;
    private int maxPlayers;
    private int minPlayers;

    /**
     * Returns the bigBlind at the specified incease, if exceeds returns biggest latest value.
     * @param time
     * @return
     */
    public int getBigBlind(int time) throws Exception {
        if (time >= bigBlind.length){
            return bigBlind[bigBlind.length-1];
        }
        if (time<0)throw new Exception("The time cannot be negative!");
        return bigBlind[time];
    }




    public int getSmallBlind(int time) throws Exception {
        if (time >= smallBlind.length){
            return smallBlind[smallBlind.length-1];
        }
        if (time<0)throw new Exception("The time cannot be negative!");
        return smallBlind[time];
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name != null) throw new Exception("This object is null");
        this.name = name;
    }

    public int getBuyIn() {
        return buyIn;
    }

    public void setBuyIn(int buyIn) {
        this.buyIn = buyIn;
    }

    public int getNrOfReBuys() {
        return nrOfReBuys;
    }

    public void setNrOfReBuys(int nrOfReBuys) {
        this.nrOfReBuys = nrOfReBuys;
    }

    public int getReBuy() {
        return reBuy;
    }

    public void setReBuy(int reBuy) {
        this.reBuy = reBuy;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int[] getBigBlind() {
        return bigBlind;
    }

    public void setBigBlind(int[] bigBlind) throws Exception {
        if (bigBlind != null) throw new Exception("This object is null");
        this.bigBlind = bigBlind;
    }

    public int[] getSmallBlind() {
        return smallBlind;
    }

    public void setSmallBlind(int[] smallBlind) throws Exception {
        if (smallBlind != null) throw new Exception("This object is null");
        this.smallBlind = smallBlind;
    }
}
