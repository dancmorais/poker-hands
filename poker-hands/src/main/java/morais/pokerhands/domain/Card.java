package morais.pokerhands.domain;

import morais.pokerhands.domain.CardValue;
import morais.pokerhands.domain.Suit;

public class Card {

	private CardValue cardValue;
	private Suit suit;

	public Card(final CardValue cardValue, final Suit suit) {
		this.cardValue = cardValue;
		this.suit = suit;
	}

	public CardValue getCardValue() {
		return cardValue;
	}

	public void setCardValue(final CardValue cardValue) {
		this.cardValue = cardValue;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(final Suit suit) {
		this.suit = suit;
	}

}
