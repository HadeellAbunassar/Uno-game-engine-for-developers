import java.util.List;

public class HumanPlayer extends Player{

    public HumanPlayer(int id, List<Card> playerCards) {
        super(id,playerCards);
    }

    @Override
    public String toString(){
        return "Human , Id" + getID();
    }
}
