package cardgame.models;
/**
 * Represents an abstraction of a Player.
 * @author neel
 *
 */
abstract public class Player {
	Hand hand;
	/**
	 * Constructs a new player using a deck.
	 * @param deck Deck from which to initialize the players hand with.
	 */
	public Player(Deck deck){
		hand = new Hand(deck);
	}
	/**
	 * Getter to get players hand
	 * @return The hand of the player
	 */
	public Hand getHand() {
		return hand;
	}
}
