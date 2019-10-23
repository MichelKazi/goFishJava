public class GoFishCard extends Card implements Comparable<GoFishCard> {
	public GoFishCard() {
		super();
	}

	public GoFishCard(int n) {
		super(n);
	}

	public GoFishCard(int r, int s) {
		super(r, s);
	}

	public int compareTo(GoFishCard otherCard) {
		return compareByRank((Card) otherCard);
	}

	public boolean equals(GoFishCard otherCard) {
		return (getRank() == otherCard.getRank());
	}

	public boolean equals(Object otherCard) {
		return (getRank() == ((GoFishCard) otherCard).getRank() && getSuit() == ((GoFishCard) otherCard).getSuit());
	}

	public static int convertToRank(String str) {

		String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		for (int i = 0; i < ranks.length; i++)
			if (ranks[i].equalsIgnoreCase(str))
				return i;
		if (str == null) return -2;
		return -1;
	}
}