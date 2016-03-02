package model.game;

/**
 * Created by Matthias Walk on 10.02.2016.
 * Class of the project: PokerParty
 */
public class Player {
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

    //TODO:WIP
    public int setAmount(){
        return -1;
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
