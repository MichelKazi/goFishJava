import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Hand {

	private LinkedList<GoFishCard> hand;
	
	public Hand() {
		//initialize instances
		hand = new LinkedList<GoFishCard>();
	}
	
	public int countRank(int rank) {
		//enhanced for loop
		int count = 0;
		for (GoFishCard gfc: hand) {
			//use the getRank() from the Card.java
			if (gfc.getRank() == rank) count++;
		}
		return count;
	}
	
	public int evaluate() {
		//checks whther four cards of same rank is in hand
		//returns 1 if yes
		//returns 0 if no
		int count;
		for (int i = 0; i < 13; i++) {
			count = countRank(i);
			if (count==4) {
				LinkedList<GoFishCard> list = new LinkedList<GoFishCard>();
				for (GoFishCard gfc: hand) {
					if (gfc.getRank() == i) list.add(gfc);
				}
				System.err.println("[Book: " + list);
				hand.removeAll(findRank(i));
				return 1;
			}
		}
		return 0;
	}
	
	public LinkedList<GoFishCard> findRank(int rank) {
		//returns a linked list of cards of the same rank
		//in the hand
		//don't remove thsoe cards!
		LinkedList<GoFishCard> list = new LinkedList<GoFishCard>();
		for (GoFishCard gfc: hand) {
			if (gfc.getRank() == rank) list.add(gfc);
		}
		return list;
		//create new LinkedList
		//use getRank()
		//use add() from LinkedList
	}
	
	public GoFishCard getCardAt(int index) {
		//get the card at the index #
		//in the hand
		return hand.get(index);
	}
	
	public LinkedList<GoFishCard> getCards(int rank) {
		//returns a linked list of cards of the same rank
		//in the hand
		//now you DO remove the cards
		LinkedList<GoFishCard> list = new LinkedList<GoFishCard>();
		for (GoFishCard gfc: hand) {
			if (gfc.getRank() == rank) list.add(gfc);
		}
		hand.removeAll(findRank(rank));
		return list;
		//use the findRank() method
		//use removeAll from the Collections class
	}
	
	public int getCount() {
		//look into the linkedlist and return the 
		//size of the list
		return hand.size();
	}
	
	public LinkedList<GoFishCard> getHand() {
		//return the Hand
		return hand;
	}
	
	public boolean hasRank(int rank) {
		//checks whether a card of the rank paramenter is
		//in the hand
		for (GoFishCard gfc: hand) {
			if (gfc.getRank() == rank) return true;
		}
		return false;
	}
	
	public void insertByRank(GoFishCard card) {
		//this is when you draw a card and insert it by rank
		//add the card parameter to the hand
		hand.add(card);
		//call the sort method from Collections
		Collections.sort(hand);
	}
	
	public void insertHand(Collection <? extends GoFishCard> otherHand) {
		//add the cards to the hand
		for(GoFishCard gfc: otherHand) {
			hand.add(gfc);
		}
		Collections.sort(hand);
		//call the sort method from the collections class
	}
	
	public boolean isEmpty() {
		//lol
		return hand.isEmpty();
	}
	
	public String toString() {
		String str = "";
		for (GoFishCard gfc: hand) {
			str+=gfc.getRankAsString()+gfc.getSuitAsString() + " ";
		}
		return str;
	}
	

}
