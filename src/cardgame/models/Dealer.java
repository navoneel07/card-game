package cardgame.models;
/**
 * An inherited calss of player which represents a new dealer.
 * @author neel
 *
 */
public class Dealer extends Player {
	/**
	 * Constructor of a new dealer.
	 * @param deck Deck used to construct hand of the dealer.
	 */
	public Dealer(Deck deck) {
		super(deck);
	}
}
