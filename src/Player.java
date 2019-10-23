import java.util.LinkedList;

public class Player {

	private Hand hand;
	private String name;
	private int points;
	
	public Player (String n) {
		//instances
		setName(n);
		hand = new Hand();
		setPoints(0);
	}
	
	public void addCard(GoFishCard card) {
		//adds one card to the hand
		//use insertbyrank
		hand.insertByRank(card);
	}
	
	public void addCards(LinkedList<GoFishCard> card) {
		hand.insertHand(card);
	}
	
	public LinkedList<GoFishCard> findRank(int rank) {
		return hand.findRank(rank);
	}
	
	public GoFishCard getCard(int rank) {
		for (int i = 0; i < hand.getCount(); i++) {
			if (hand.getCardAt(i).getRank() == rank)
				return hand.getCardAt(i);
		}
		return null;
				
	}
	
	public GoFishCard getCardAt(int index) {
		return hand.getCardAt(index);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String capName = name.substring(0, 1).toUpperCase() + name.substring(1);
		this.name = capName;
	}

	public int getPoints() {
		return points;
	}
	
	public int getTotalCards() {
		return hand.getCount();
	}
	
	public boolean hasRank(int rank) {
		return hand.hasRank(rank);
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public void setHand(Hand h) {
		this.hand = h;
	}
	
	public String showHand() {
		return hand.toString();
	}
	
	public String toString() {
		return name + " [BOOKS: " + points + "]\nHAND:" + hand;
	}
	
}
