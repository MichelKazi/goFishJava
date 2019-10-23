import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	public static final int CARDS_IN_DECK = 52;
	private ArrayList<Card> cards = new ArrayList<Card>();

	public Deck() {
		cards.ensureCapacity(CARDS_IN_DECK);
		initialize();
	}

	public void initialize() {
		for (int i = 0; i < CARDS_IN_DECK; i++) {
			cards.add(new GoFishCard(i));
		}
	}

	public String toString() {
		return "No. of cards: " + cards.size() + "\n" + cards.toString();
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card deal() {
		if (!cards.isEmpty())
			return cards.remove(0);
		return null;
	}

	public boolean isEmpty() {
		return cards.isEmpty();
	}
}