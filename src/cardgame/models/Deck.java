package cardgame.models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 * Class to represent a new deck composed of an ArrayList of objects
 * of the Card class.
 * @author neel
 *
 */
public class Deck {
	ArrayList<Card> deck = new ArrayList<Card>();
	/**
	 * Constructor of a new shuffled deck.
	 */
	public Deck(){
		for(int i=1;i<=4;++i) {
			for(int j=1;j<=13;++j) {
				deck.add(new Card(Integer.toString(i), Integer.toString(j)));
			}
		}
		Collections.shuffle(deck, new Random());
	}
	/**
	 * Removes the card from the top of the deck.
	 * @return Returns the top card of the deck.
	 */
	public Card RemoveFromTop() {
		return deck.remove(0);
	}
}
