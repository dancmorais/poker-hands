package morais.pokerhands.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import morais.pokerhands.domain.Card;
import morais.pokerhands.domain.Deck;
import morais.pokerhands.domain.Hand;

public class InputOutputUtils {
	
	public final static Scanner scanner = new Scanner(System.in);
	
	private static String inputPattern1 = "([2-9]|[TtJjQqKkAa])[CcDdHhSs]";
	private static String inputPattern2 = "[CcDdHhSs]([2-9]|[TtJjQqKkAa])";

	public static Hand readInputCards(Deck deck, int handNumber) {
		Hand hand = new Hand();
		List<Card> cardList = new ArrayList<Card>();
		String cardString;
		int i = 0;
		Boolean isInDeck = false;
		String cardSuit;
		String cardValue;
		
		System.out.println("Please provide 5 cards for Hand #" + handNumber);

		while (i < 5 && scanner.hasNext()) {
			isInDeck = false;
			if (scanner.hasNext(inputPattern1)) {
				cardString = scanner.next();
				cardValue = cardString.substring(0, 1).toUpperCase();
				cardSuit = cardString.substring(1, 2).toUpperCase();
				for (Card card : deck.getDeck()) {
					if (card.getCardValue().getCardId().equals(cardValue)
							&& card.getSuit().getSuitId().equals(cardSuit)) {
						isInDeck = true;
						cardList.add(card);
						deck.getDeck().remove(card);
						i++;
						break;
					}
				}
				if(!isInDeck){
					System.out.println("Card " + cardValue + cardSuit + " already drawn. Please pick a different card");
				}

			} else if (scanner.hasNext(inputPattern2)) {
				cardString = scanner.next();
				cardSuit = cardString.substring(0, 1).toUpperCase();
				cardValue = cardString.substring(1, 2).toUpperCase();
				for (Card card : deck.getDeck()) {
					if (card.getSuit().getSuitId().equals(cardSuit)
							&& card.getCardValue().getCardId().equals(cardValue)) {
						isInDeck = true;
						cardList.add(card);
						deck.getDeck().remove(card);
						i++;
						break;
					}
				}
				if(!isInDeck){
					System.out.println("Card " + cardSuit + cardValue + " already drawn. Please pick a different card");
				}

			} else {
				System.out.println("Incorrect input detected. Please pick a valid card");
				scanner.next();
			}

		}
		hand.setHandCards(cardList);
		return hand;
	}
}
