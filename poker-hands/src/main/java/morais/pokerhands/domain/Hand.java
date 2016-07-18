package morais.pokerhands.domain;

import java.util.List;

public class Hand {

	private List<Card> handCards;
	private Rank rank;
	
	public List<Card> getHandCards() {
		return this.handCards;
	}

	public void setHandCards(List<Card> handCards) {
		this.handCards = handCards;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}
}
