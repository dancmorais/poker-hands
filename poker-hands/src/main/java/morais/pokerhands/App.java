package morais.pokerhands;

import morais.pokerhands.domain.Deck;
import morais.pokerhands.domain.Hand;
import morais.pokerhands.services.DeckService;
import morais.pokerhands.services.HandService;
import morais.pokerhands.utils.InputOutputUtils;

public class App {
	public static void main(String[] args) {

		Deck deck = new Deck();
		deck = DeckService.generateDeck();
		
		Hand hand1 = new Hand();
		Hand hand2 = new Hand();

		hand1 = InputOutputUtils.readInputCards(deck, 1);
		hand2 = InputOutputUtils.readInputCards(deck, 2);

		InputOutputUtils.scanner.close();

		HandService.rankHand(hand1);
		HandService.rankHand(hand2);

		HandService.chooseWinner(hand1, hand2);
		
	}
}
