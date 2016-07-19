package morais.pokerhands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import morais.pokerhands.domain.Card;
import morais.pokerhands.domain.Deck;
import morais.pokerhands.domain.Hand;
import morais.pokerhands.domain.Rank;
import morais.pokerhands.services.DeckService;
import morais.pokerhands.services.HandService;

public class App {
	public static void main(String[] args) {

		Deck deck = new Deck();
		deck = DeckService.generateDeck();
		Hand hand1 = new Hand();
		Hand hand2 = new Hand();

		/* Testing section */
		Collections.shuffle(deck.getDeck());

		List<Card> list1 = new ArrayList<Card>();
		List<Card> list2 = new ArrayList<Card>();
		for (int i = 0; i < 5; i++) {
			list1.add(deck.getDeck().remove(i));
			list2.add(deck.getDeck().remove(i));

		}

		hand1.setHandCards(list1);
		hand2.setHandCards(list2);

		HandService.rankHand(hand1);
		HandService.rankHand(hand2);

		int rankValue1 = hand1.getRank().getRankValue();
		int rankValue2 = hand2.getRank().getRankValue();
		System.out.println("Hand #1");
		for (Card card : hand1.getHandCards()) {
			System.out.println(card.getCardValue().getCardValue() + " of " + card.getSuit());
		}
		System.out.println();
		System.out.println("Hand #2");
		for (Card card : hand2.getHandCards()) {
			System.out.println(card.getCardValue().getCardValue() + " of " + card.getSuit());
		}
		System.out.println();
		if (rankValue1 > rankValue2) {
			System.out.println("Hand #1 wins with " + hand1.getRank());
		} else if (rankValue1 < rankValue2) {
			System.out.println("Hand #2 wins with " + hand2.getRank());
		} else {
			int i = 0;
			while (i < 5) {
				int cardValue1 = hand1.getHandCards().get(i).getCardValue().getCardValue();
				int cardValue2 = hand2.getHandCards().get(i).getCardValue().getCardValue();

				if (cardValue1 > cardValue2) {
					System.out.println("Hand #1 wins with higher " + hand1.getRank());
					break;
				} else if (cardValue1 < cardValue2) {
					System.out.println("Hand #2 wins with higher " + hand2.getRank());
					break;
				}
				i++;
			}
			if (i == 5)
				System.out.println("Hands Tie with " + hand1.getRank());
		}
		/* end testing section */

	}
}
