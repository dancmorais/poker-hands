package morais.pokerhands.domain;

import java.util.List;

public class Hand {

	private List<Card> handCards;

	public List<Card> getHandCards() {
		return this.handCards;
	}

	public void setHandCards(List<Card> handCards) {
		this.handCards = handCards;
	}
}
