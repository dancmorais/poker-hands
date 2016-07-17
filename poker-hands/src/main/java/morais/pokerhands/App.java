package morais.pokerhands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import morais.pokerhands.domain.Card;
import morais.pokerhands.domain.Deck;
import morais.pokerhands.domain.Hand;
import morais.pokerhands.services.DeckService;

public class App {
	public static void main(String[] args) {

		Deck deck = new Deck();
		DeckService deckService = new DeckService();
		deck = deckService.generateDeck();


	}
}
