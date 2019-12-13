package cardgame.models;
import java.util.ArrayList;
/**
 * Class that represents a Hand, ie a collection of three cards
 * that the dealer and the player use to play.
 * @author neel
 *
 */
public class Hand {
	ArrayList<Card> hand = new ArrayList<Card>();
	/**
	 * Constructor to make a new hand of three cards.
	 * @param deck A deck of cards used to construct a new hand.
	 */
	Hand(Deck deck){
		for(int i = 0;i<3;++i) {
			hand.add(deck.RemoveFromTop());
		}
	}
	/**
	 * Getter to get the Arraylist containing the hand.
	 * @return ArrayList which contains 3 objects of type Card which constitute a hand
	 */
	public ArrayList<Card> getHandArr() {return this.hand;}
	/**
	 * Function to compare another hand to itself using the rules of the game.
	 * @param hand The hand to which to compare the current deck to.
	 * @return Returns true if the current hand is better than the hand to which it is being compared and false otherwise.
	 */
	public boolean HandComp(Hand hand) {
		int SpecialCardsForSelf=0, SpecialCardsForComp=0;
		for(Card card: this.hand) {
			if(Integer.parseInt(card.getRank())>10) {
				SpecialCardsForSelf+=1;
			}
		}
		for(Card card: hand.getHandArr()) {
			if(Integer.parseInt(card.getRank())>10) {
				SpecialCardsForComp+=1;
			}
		}
		if(SpecialCardsForSelf>SpecialCardsForComp) {
			return true;
		}
		else if(SpecialCardsForSelf<SpecialCardsForComp) {
			return false;
		}
		else if(SpecialCardsForSelf==SpecialCardsForComp) {
			int FaceValueForSelf = 0, FaceValueForComp=0;
			for(Card card:this.hand) {
				if(Integer.parseInt(card.getRank())<=10) {
					FaceValueForSelf+=Integer.parseInt(card.getRank());
				}
			}
			for(Card card:hand.getHandArr()) {
				if(Integer.parseInt(card.getRank())<=10) {
					FaceValueForComp+=Integer.parseInt(card.getRank());
				}
			}
			if(FaceValueForSelf%10>FaceValueForComp%10) {
				return true;
			}
			else if(FaceValueForSelf%10<FaceValueForComp%10) {
				return false;
			}
		}
		return false;
	}
	
}
