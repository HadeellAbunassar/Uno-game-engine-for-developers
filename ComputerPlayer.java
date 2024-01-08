import java.util.List;
public class ComputerPlayer extends Player{


    public ComputerPlayer(int id, List<Card> playerCards){
        super(id,playerCards);
    }

    @Override
    public int chooseCard(Deck deck) {
        int cardIndex = 0 + (int) (Math.random() * this.getPlayerCards().size());
        return cardIndex;

    }

    @Override
    public String toString(){
        return "Computer , Id" + getID();
    }
}
