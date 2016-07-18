package morais.pokerhands.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import morais.pokerhands.domain.Card;
import morais.pokerhands.domain.Hand;
import morais.pokerhands.domain.Rank;

public class HandService {

	public static Rank checkHand(Hand hand) {
		
		Integer currentCardValue;
		Boolean isFlush = true;
		Boolean isStraight = true;
		Integer sameValueCounter = 0;
		Map<Integer, Integer> sameValueMap = new HashMap<Integer, Integer>();

		Collections.sort(hand.getHandCards());
		Iterator<Card> it = hand.getHandCards().iterator();
		Card currentCard = null;
		
		if (it.hasNext())
			currentCard = it.next();

		while (it.hasNext()) {
			currentCardValue = currentCard.getCardValue().getCardValue();
			Card nextCard = it.next();
			if (currentCard.getSuit() != nextCard.getSuit()) {
				isFlush = false;
			}
			
			/* Is it a sequence? */
			if (currentCardValue == (nextCard.getCardValue().getCardValue() - 1)) {
				currentCard = nextCard;
				sameValueCounter = 0;
				continue;
			}

			isStraight = false;
			if (currentCardValue == nextCard.getCardValue().getCardValue()) {
				sameValueMap.put(currentCardValue, ++sameValueCounter);
			} else {
				sameValueCounter = 0;
			}

			currentCard = nextCard;
		}
		if (isFlush && isStraight) {
			return Rank.STRAIGHT_FLUSH;
		} else if (sameValueMap.containsValue(3)) {
			return Rank.FOUR_OF_A_KIND;
		} else if (sameValueMap.containsValue(2) && sameValueMap.containsValue(1)) {
			return Rank.FULL_HOUSE;
		} else if (isFlush) {
			return Rank.FLUSH;
		} else if (isStraight) {
			return Rank.STRAIGHT;
		} else if (sameValueMap.containsValue(2)) {
			return Rank.THREE_OF_A_KIND;
		} else if (sameValueMap.size() > 1 && sameValueMap.containsValue(1)) {
			return Rank.TWO_PAIRS;
		} else if (sameValueMap.containsValue(1)) {
			return Rank.PAIR;
		} else
			return Rank.HIGH_CARD;

	}
}
