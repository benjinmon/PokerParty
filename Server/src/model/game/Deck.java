package model.game;

import model.game.enums.Suit;
import model.game.enums.Value;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Matthias Walk on 10.02.2016.
 * Class of the project: PokerParty
 */
public class Deck {
    private LinkedList<Card> deck;

    public Deck() throws Exception {
        deck=new LinkedList<Card>();
        prepare();
    }

    /**
     * Draws one card and removes it from the List.
     * @return
     */
    public Card draw(){
        Card draw=deck.pollFirst();
        return draw;
    }

    /**
     * Prepares the deck for the next round.
     */
    public void prepare() throws Exception {
        deck.removeAll(deck);         //Deletes all entries.

        for (Suit suit : Suit.values()){
            for(Value value : Value.values()){
                deck.add(new Card(suit, value));
            }
        }
        Collections.shuffle(deck);//*insert shuffle noise*
    }
}
