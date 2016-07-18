package morais.pokerhands.services;

import morais.pokerhands.domain.Deck;

import java.util.ArrayList;

import morais.pokerhands.domain.Card;
import morais.pokerhands.domain.CardValue;
import morais.pokerhands.domain.Suit;

public class DeckService {

	public static Deck generateDeck() {
		ArrayList<Card> cardArray = new ArrayList<Card>();
		Deck deck = new Deck();

		for (CardValue value : CardValue.values()) {
			for (Suit suit : Suit.values()) {
				Card card = new Card(value, suit);
				cardArray.add(card);
			}
		}

		deck.setDeck(cardArray);
		return deck;
	}

}
