import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Game {
    protected Deck deck;
    protected List<Player> Players = new ArrayList<Player>();
    protected enum Direction { FORWARDS, BACKWARDS };
    protected Direction dir = Direction.FORWARDS;
    private int numOfPlayers;
    protected int currentPlayerId;
    private int score=0;

    public String getChosenColor() {
        return chosenColor;
    }

    private String chosenColor = null;

    Scanner scan = new Scanner(System.in);

    public abstract void play();

    public Game(int numOfPlayers,DeckInitializer d){
        this.deck = new Deck(d);
        this.numOfPlayers = numOfPlayers;
        initializePlayers(numOfPlayers);
        currentPlayerId = 0;
    }

    public void nextPlayerDraw() {
        int nextPlayer = getNextPlayer();
        Card drawnCard = deck.draw();
        Players.get(nextPlayer).getPlayerCards().add(drawnCard);
    }

    // to Specify the winning rules.
    public abstract void howToWin();
    public void Winner(Player p){
        System.out.println("___________________________________________________________________ \n");
        System.out.println("Congrats, Player " + (p.getID()-1) + " Is the winner!");
        System.out.println("Others players score:");

        for(int i=0 ; i<numOfPlayers ; i++){
            if(i==(p.getID()-1)) continue;
            System.out.print("Player : " + i + " Score: ");
            score = Players.get(i).Score();
            System.out.print(score + "\n");
        }
    }

    public void chooseColorIfWild(){
        System.out.println("Choose color for the next player: [Red,Blue,Green,Orange]");
        String color = scan.next();
        setChosenColor(color);
    }
    public List<Player> initializePlayers(int numOfPlayers){
        for(int i=1 ; i <=numOfPlayers ; i++){
            Players.add(new Player(i,deck.dealCards()));
        }
        return Players;
    }

    void reverseDirection() {
        if (dir == Direction.FORWARDS) {
            dir = Direction.BACKWARDS;
        }
        else {
            dir = Direction.FORWARDS;
        }
    }


    public int getNextPlayer() {
        if (dir == Direction.FORWARDS) {
            return (currentPlayerId + 1) % getNumOfPlayers();
        }
        else {
            if (currentPlayerId == 0) {
                return getNumOfPlayers() - 1;
            }
            else {
                return currentPlayerId - 1;
            }
        }
    }

    void advanceToNextPlayer() {
        currentPlayerId = getNextPlayer();
    }

    public void setChosenColor(String chosenColor) {
        this.chosenColor = chosenColor;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

}




















