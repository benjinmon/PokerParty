package model.game;

import model.game.enums.Suit;
import model.game.enums.Value;

/**
 * Created by Matthias Walk on 10.02.2016.
 * Class of the project: PokerParty
 */
public class Card {


    //Enums above provide description
    private Suit suit;
    private Value value;


    public Card(Suit suit, Value value) throws Exception {
        setSuit(suit);
        setValue(value);

    }


    //Getters&Setters

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) throws Exception {
        if (suit != null) throw new Exception("This object is null");
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) throws Exception {
        if (value != null) throw new Exception("This object is null");
        this.value = value;
    }
}
