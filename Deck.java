import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> discardedCards = new ArrayList<Card>();
    private List<Card> cards = new ArrayList<Card>();


    public Deck(DeckInitializer d){
    this.cards = d.initializeDeck();
    shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }


    public List<Card> dealCards() {
        List<Card> dealtCards = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            dealtCards.add(cards.remove(0));
        }
        return dealtCards;
    }


    public Card draw() {
        if (cards.size() == 0){
            System.out.println("Filling the cards in process ... ");
            cards.addAll(discardedCards);
            discardedCards.clear();
            Collections.shuffle(cards);
        }
        return cards.remove(0);
    }

    public void topCard(Card c) {
        discardedCards.add(c);
    }

    // this is for the first card that will start the game , it must be normal card.
        public Card firstTopCard(){
        Card c = draw();
        while(!(c instanceof NormalCard)){
            cards.add(c);
            c = draw();
        }
        topCard(c);
       return c;
    }

}





