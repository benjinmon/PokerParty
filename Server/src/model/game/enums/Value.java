package model.game.enums;

/**
 * Created by Matthias Walk on 10.02.2016.
 * Class of the project: PokerParty
 */

public enum Value {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);
    private int value;
    private Value(int value){
        this.value=value;
    }
};
