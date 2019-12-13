package cardgame.models;
/**
 * An inherited class of player to represent the human player in the game.
 * Contains bet amount for each round and static bank as the amount of money
 * player has in the whole duration of the game.
 * @author neel
 *
 */
public class Human extends Player {
	int bet;
	public static int bank = 100;
	/**
	 * Constructs a new Human player.
	 * @param deck Deck with whic to build hand of player.
	 */
	public Human(Deck deck){
		super(deck);
		bet = 0;
	}
	/**
	 * Getter to get bank.
	 * @return Current money in bank
	 */
	public int getBank() {
		return bank;
	}
	/**
	 * Updates the bank in case the player wins by adding bet amount.
	 */
	public void updateBankOnWin() {
		bank+=this.bet;
	}
	/**
	 * Updates the bank in case the player loses by subtracting bet amount.
	 */
	public void updateBankOnLoss() {
		bank-=this.bet;
	}
	/**
	 * Setter to set the bet of the current round.
	 * @param bet The bet amount to set.
	 */
	public void setBet(int bet) {
		this.bet=bet;
	}
	/**
	 * Getter to get current bet.
	 * @return Returns current bet
	 */
	public int getBet() {return bet;}
	/**
	 * Replaces one card of the players hand with the top cards from the deck.
	 * @param index Which card to replace
	 * @param deck Deck whose top card is to be used
	 * @return Returns the string representation of the card which is used to replace.
	 */
	public String replaceCard(int index, Deck deck) {
		Card card = deck.RemoveFromTop();
		this.hand.getHandArr().set(index, card);
		return card.toString();
	}
}
