package morais.pokerhands.domain;

import java.util.List;

import morais.pokerhands.domain.Card;

public class Deck {

	private List<Card> deck;

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(final List<Card> deck) {
		this.deck = deck;
	}
}
