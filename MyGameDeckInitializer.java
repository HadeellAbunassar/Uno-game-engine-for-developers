import java.util.ArrayList;
import java.util.List;

public class MyGameDeckInitializer  implements DeckInitializer{
    public static final String[] COLORS = {"Red", "Blue", "Green", "Orange"};
    @Override
    public List<Card> initializeDeck(){
        List<Card> cards = new ArrayList<>();
        for(int k = 1; k <= 2; k++){
            for (int i = 1; i <= 9; i++) {
                for (int j = 0; j < 4; j++) {
                    cards.add(new NormalCard(COLORS[j], i));
                }
            }
        }

        // initialize four cards with 0 value.
        for (int j = 0; j < 4; j++) {
            cards.add(new NormalCard(COLORS[j],0));
        }

        // for Action Cards ->  REVERSE, SKIP, DRAW_TWO
        for (int i = 0; i < 4; i++) {
            for(int j=0 ; j<2 ; j++){
                cards.add(new ActionCard(COLORS[i], ActionCard.ActionType.REVERSE));
                cards.add(new ActionCard(COLORS[i], ActionCard.ActionType.SKIP));
                cards.add(new ActionCard(COLORS[i],  ActionCard.ActionType.DRAW_TWO));
            }}



        for (int i = 1; i < 5; i++) {
            cards.add(new Wild());
            cards.add(new WildAddFour());
        }

            cards.add(new SWAP());
            cards.add(new SWAP());



       return cards;
    }


}
