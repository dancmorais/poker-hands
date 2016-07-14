package morais.pokerhands.domain;

public enum Suit {
	CLUBS("C"), DIAMONDS("D"), HEARTS("H"), SPADES("S");

	private String suitId;

	private Suit(final String suitId) {
		this.suitId = suitId;
	}

	public String getSuitId() {
		return suitId;
	}

}
