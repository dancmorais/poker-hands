package morais.pokerhands.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import morais.pokerhands.domain.Card;
import morais.pokerhands.domain.Hand;
import morais.pokerhands.domain.Rank;

public class HandService {

	public static Hand rankHand(final Hand hand) {

		Boolean isFlush = true;
		Boolean isStraight = true;

		Collections.sort(hand.getHandCards());
		Iterator<Card> it = hand.getHandCards().iterator();
		Card pastCard = null;

		List<Card> pairedCards = new ArrayList<Card>();
		List<Card> regularCards = new ArrayList<Card>();
		Boolean pairAdded = false;

		if (it.hasNext())
			pastCard = it.next();

		while (it.hasNext()) {
			Card currentCard = it.next();

			Integer pastCardValue, currentCardValue;
			pastCardValue = pastCard.getCardValue().getCardValue();
			currentCardValue = currentCard.getCardValue().getCardValue();

			if (pastCard.getSuit() != currentCard.getSuit()) {
				isFlush = false;
			}

			if (pastCardValue != (currentCardValue) - 1)
				isStraight = false;

			if (pastCardValue == currentCardValue) {
				/*Special condition for full house*/
				if (pairedCards.size() == 3 && pairedCards.get(0).getCardValue().getCardValue() != currentCardValue) {
					pairedCards.add(pastCard);
					pairedCards.add(currentCard);
				} else {
					if (!pairAdded) {
						pairedCards.add(0, pastCard);
					}
					pairedCards.add(0, currentCard);
					pairAdded = true;
				}

			} else {
				if (pairAdded) {
					pairAdded = false;
				} else {
					regularCards.add(0, pastCard);
				}
				if (!it.hasNext()) {
					regularCards.add(0, currentCard);
				}

			}
			pastCard = currentCard;
		}
		Integer pairedCardsSize = pairedCards.size();
		pairedCards.addAll(regularCards);

		hand.setHandCards(pairedCards);

		if (isFlush && isStraight) {
			hand.setRank(Rank.STRAIGHT_FLUSH);
		} else if (pairedCardsSize == 4 && pairedCards.get(0).getCardValue() == pairedCards.get(pairedCardsSize - 1).getCardValue()) {
			hand.setRank(Rank.FOUR_OF_A_KIND);
		} else if (pairedCardsSize == 5) {
			hand.setRank(Rank.FULL_HOUSE);
		} else if (isFlush) {
			hand.setRank(Rank.FLUSH);
		} else if (isStraight) {
			hand.setRank(Rank.STRAIGHT);
		} else if (pairedCardsSize == 3) {
			hand.setRank(Rank.THREE_OF_A_KIND);
		} else if (pairedCardsSize == 4) {
			hand.setRank(Rank.TWO_PAIRS);
		} else if (pairedCardsSize == 2) {
			hand.setRank(Rank.PAIR);
		} else
			hand.setRank(Rank.HIGH_CARD);

		return hand;

	}
	
	public static void chooseWinner(Hand hand1, Hand hand2){
		
		int rankValue1 = hand1.getRank().getRankValue();
		int rankValue2 = hand2.getRank().getRankValue();
		
		System.out.println("Hand #1");
		for (Card card : hand1.getHandCards()) {
			System.out.println(card.getCardValue().getCardId() + " of " + card.getSuit());
		}
		System.out.println("Rank: " + hand1.getRank());
		System.out.println();
		System.out.println("Hand #2");
		for (Card card : hand2.getHandCards()) {
			System.out.println(card.getCardValue().getCardId() + " of " + card.getSuit());
		}
		System.out.println("Rank: " + hand2.getRank());
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
	}
}
