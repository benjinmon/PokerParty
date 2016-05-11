package model.game;

/**
 * Created by Matthias Walk on 10.02.2016.
 * Class of the project: PokerParty
 */
public class Player {
    private String name;
    private int stack;
    private int totalMoney;
    private Table table;
    private Card[] hand;


    public Card[] getHand() {
        return hand;
    }

    public void setHand(Card[] hand) throws Exception {
        if (hand != null) throw new Exception("This object is null");
        this.hand = hand;
    }

    /**
     * TODO: Make this method gain information from the clinets.
     * @param stake
     * @return
     * @throws Exception
     */
    public int setAmount(int stake) throws Exception {
        int value=-1;


        if (value<-1)throw new Exception("The player \""+this.getName()+"\" tried to set a negative amount.");
        return value;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name != null) throw new Exception("This object is null");
        this.name = name;
    }

    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
