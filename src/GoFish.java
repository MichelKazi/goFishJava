
/**
 * @author michel kazi
 */
import java.awt.Dimension;
import java.awt.Font;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class GoFish {

	private Player[] players;
	private Deck deck;

	public GoFish() {

		players = new Player[2];
		deck = new Deck();
		deck.shuffle();
	}

	public void getNames() {
		// Ask for player name use JOptionPane
		players[0] = new Player(JOptionPane.showInputDialog("Enter your name"));
		// SetPlayer1 name
		players[1] = new Player("CPU");
		// (P1: Human, P2: computer)
	}

	public void dealCards() {
		// deal each player 7 cards from deck
		// use the deal method
		// use addCard to add those cards
		for (int i = 0; i < players.length; i++) {
			while (players[i].getTotalCards() < 7)
				players[i].addCard((GoFishCard) deck.deal());
		}

		// remember when you call the deal method t he cards are returned as a Card
		// type.
		// So you may want to cast the card
	}

	public void playGame() {
		// let the game begin???
		// use the methods provided to shorten the code here
		// know how to call the other methods in this class
		UIManager.put("OptionPane.minimumSize",new Dimension(750,250));
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 36));
		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 36));
		
		UIManager.put("TextField.font", new FontUIResource(
				new Font("Verdana", Font.BOLD, 36) ) );
		getNames();
		dealCards();
		Player current = players[0];
		Player otherPlayer = players[1];
		
		while (!current.getHand().isEmpty() || !otherPlayer.getHand().isEmpty() || !deck.isEmpty()) {

			for (int i = 0; i < 2; i++) {
				current = players[i];
				otherPlayer = players[(i + 1) % 2];
				System.out.println("--------------------------------------------------\n" + current.getName() + "'s turn" + "\n\n" + current + "\n");
				int gotAny = getRank(current);
				System.out.println(current.getName() + " says: \"Hey " + otherPlayer.getName() + ", got any "
						+ (gotAny + 2) + "s?\"");

				if (otherPlayer.hasRank(gotAny)) {
					System.out.println(otherPlayer.getName() + " says: \"yes!\"");

					current.addCards(otherPlayer.getHand().getCards(gotAny));
					System.out.println(
							otherPlayer.getName() + " gave " + current.getName() + " their " + (gotAny + 2) + "s.");
				} else {
					System.out.println(otherPlayer.getName() + " says: \"No, Go Fish!\"\n" + current.getName()
							+ " drew a card from the deck!\n");

					current.addCard((GoFishCard) deck.deal());
				}
				if (current.getHand().evaluate() == 1) {
					current.setPoints(current.getPoints() + 1);
				}
				
			}
			if (deck.isEmpty() || current.getHand().isEmpty() || otherPlayer.getHand().isEmpty())
				gameResults(); 
				
		}

	}

	public void displayHands() {
		// display the hands of all the players
		for (Player i : players) {
			// prnt hands
			System.out.println(i);
			// display name, num of books, and cards
		}
	}

	public int getRank(Player p) {
		// if p is p1 then have user enter the rank in their hand
		// if a card user enters is not in the rank it'll prompt to try again
		// use the convertToRank method
		//
		int rank;
		if (!p.getName().equals("CPU")) {
			rank = GoFishCard.convertToRank(JOptionPane.showInputDialog("Choose a rank from your hand."));
			while (!p.getHand().hasRank(rank)) {
				if (rank == -2) {
					System.exit(1);
					break;
				}
				rank = GoFishCard.convertToRank(JOptionPane.showInputDialog("You don't have that card."));
			}
			return rank;
		}
		// if p is p2 (CPU), select a rank from their hand at random
		// class Random, nextInt(), randomly select a random card from its hand
		// then ask other player if they have that rank
		// in both cases return the rank
		rank = p.getCardAt(new Random().nextInt(p.getHand().getCount())).getRank();
		return rank;

	}

	public void gameResults() {
		// print the results from each player and who won
		for (int i = 0; i < players.length; i++) {
			System.out.println(players[i]);
		}

		System.out.println(players[0].getPoints() > players[1].getPoints() ? players[0].getName() + " won!"
				: players[1].getName() + " won!");
		JOptionPane.showMessageDialog(null, players[0].getPoints() > players[1].getPoints() ? players[0].getName() + " won!"
				: players[1].getName() + " won!");
		System.exit(1);
	}

}
