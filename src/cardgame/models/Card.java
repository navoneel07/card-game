package cardgame.models;
/**
 * Class to model a card in the game and contains information
 * pertaining to rank and suite of a card.
 * Suite varies as 1: Clubs, 2: Spades, 3: Diamonds, 4:Hearts.
 * Rank varies from 1 to 13, with 1 being Ace, 11 being Jack,
 * 12 being Queen and 13 being King.
 * @author neel
 *
 */
public class Card {
	String suite, rank;
	/**
	 * Constructor for a new card
	 * @param suite The suite of the card 
	 * @param rank The rank of the card
	 */
	public Card(String suite, String rank){
		this.suite = suite;
		this.rank=rank;
	}
	/**
	 * Getter for suite of a card
	 * @return Returns the suite of the card
	 */
	public String getSuite() {return suite;}
	/**
	 * Getter for rank of a card
	 * @return Returns the rank of the card
	 */
	public String getRank() {return rank;}
	/**
	 * Creates a compact representation of a card by concatenation of suite and rank.
	 * @return Returns the string format of a card
	 */
	public String toString() {
		return suite+rank;
	}
}
