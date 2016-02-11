package model.game.enums;

/**
 * Created by Matthias Walk on 10.02.2016.
 * Class of the project: PokerParty
 */
public enum Suit {
    SPADE(2), HEART(2), DIAMOND(3), CLUB(4);
    private int value;
    private Suit(int value){
        this.value=value;
    }
}
