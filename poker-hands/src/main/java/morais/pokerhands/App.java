package morais.pokerhands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import morais.pokerhands.domain.Card;
import morais.pokerhands.domain.Deck;
import morais.pokerhands.domain.Hand;
import morais.pokerhands.domain.Rank;
import morais.pokerhands.services.DeckService;
import morais.pokerhands.services.HandService;

public class App {
	public static void main(String[] args) {

		Deck deck = new Deck();
		deck = DeckService.generateDeck();
		Hand hand1 = new Hand();
		Hand hand2 = new Hand();
		
		/*Testing section*/
		Collections.shuffle(deck.getDeck());

		List<Card> list1 = new ArrayList<Card>();
		List<Card> list2 = new ArrayList<Card>();
		for (int i = 0; i < 5; i++) {
			list1.add(deck.getDeck().remove(i));
			list2.add(deck.getDeck().remove(i));

		}
		
		hand1.setHandCards(list1);
		hand2.setHandCards(list2);
		
		Rank rankHand1 = HandService.checkHand(hand1);
		Rank rankHand2 = HandService.checkHand(hand2);
		
		if(rankHand1.getRankValue() > rankHand2.getRankValue()){
			System.out.println("Hand #1 wins with " + rankHand1);
		}else if(rankHand1.getRankValue() < rankHand2.getRankValue()){
			System.out.println("Hand #2 wins with " + rankHand2);
		}
		else System.out.println("Tie with " + rankHand1);
		/*end testing section*/

	}
}
