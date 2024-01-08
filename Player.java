import java.util.List;
import java.util.Scanner;

public class Player {
    private int id;

    private List<Card> playerCards;
    public List<Card> getPlayerCards() {
        return playerCards;
    }
    private boolean isUno=false;
    int unoCounter = 0;

    String uno = null;

    public Player(int id, List<Card> playerCards) {
        this.id = id;
        this.playerCards = playerCards;
    }

    public void setPlayerCards(List<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public int getID() {
        return id;
    }

    public int chooseCard(Deck deck) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a Card (Enter card index - if you can't enter -1 : ");
        int cardIndex = scanner.nextInt();
        while(cardIndex == -1){
            this.getPlayerCards().add(deck.draw());
            System.out.println("your New card " + (this.getPlayerCards().size()-1) + " " +  this.getPlayerCards().getLast() +
                    "\nChoose a Card (Enter card index - if you can't enter -1)");
            cardIndex = scanner.nextInt();
        }
        return cardIndex;
    }

    public int Score(){
        int sum=0;
        for(int i=0 ; i<getPlayerCards().size() ; i++){
            sum += getPlayerCards().get(i).returnedValue();
        }
        return sum;
    }

    public void displayCards(){
        System.out.println("Your Cards: ");
        for(int i=0 ; i<getPlayerCards().size() ; i++){
            System.out.println("Card " + i  + " is : " + getPlayerCards().get(i));
        }
    }

    public boolean getIsUno() {
        return isUno;
    }
    public void setIsUno(boolean inUno) {
        this.isUno = inUno;
    }
    public int getUnoCounter() {
        return unoCounter;
    }
    public void setUnoCounter(int unoCounter) {
        this.unoCounter = unoCounter;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    @Override
    public String toString(){
        return "Id, " + getID();
    }

}


