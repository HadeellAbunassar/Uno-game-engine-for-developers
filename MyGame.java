import java.util.List;
import java.util.Scanner;

public class MyGame extends Game {
    private Card topCard;
    private int tobePlayed;
    private boolean flag;
    private boolean gameIsOver = false;
    Scanner scan = new Scanner(System.in);
    Player currentPlayer;

    public MyGame(int numOfPlayers) {
        super(numOfPlayers, new MyGameDeckInitializer());
        topCard = deck.firstTopCard();
    }


    @Override
    public void play() {
        while (!gameIsOver) {
            // display the top card + player id to specify the turn.
            System.out.println("Top Card: " + topCard);
            System.out.println("Player " + currentPlayerId + " turn ");

            // display player cards + make the player choose one card + decide if the chosen card cen be played
            currentPlayer = Players.get(currentPlayerId);
            currentPlayer.displayCards();

            tobePlayed = currentPlayer.chooseCard(deck);
            while (tobePlayed > currentPlayer.getPlayerCards().size() - 1) {
                tobePlayed = currentPlayer.chooseCard(deck);
            }
            flag = currentPlayer.getPlayerCards().get(tobePlayed).canBePlayed(topCard, getChosenColor());

            while (!flag) {
                    System.out.println("Not Valid please choose a valid Card!");
                tobePlayed = currentPlayer.chooseCard(deck);
                flag = currentPlayer.getPlayerCards().get(tobePlayed).canBePlayed(topCard, getChosenColor());
            }

            // calling howtowin to decide the player can win - he must say uno + if he can win after saying uno or not
                howToWin();


            int nextId = currentPlayerId + 1;
            if (currentPlayerId == Players.size() - 1) {
                nextId = 0;
            }

            // Applying card action + decide the next player.
            int prevPlayer = currentPlayerId; // because the current player will change after the action
            // I want to store the prev currentPlayer
             if(currentPlayer.getPlayerCards().get(tobePlayed) instanceof SWAP){
                 topCard=currentPlayer.getPlayerCards().get(tobePlayed);
                 deck.topCard(topCard);
                 currentPlayer.getPlayerCards().get(tobePlayed).cardAction(this, currentPlayerId);
                 advanceToNextPlayer();
             }
            else{
                currentPlayer.getPlayerCards().get(tobePlayed).cardAction(this, nextId);
                advanceToNextPlayer();
            topCard = Players.get(prevPlayer).getPlayerCards().get(tobePlayed);
            deck.topCard(topCard);
            Players.get(prevPlayer).getPlayerCards().remove(tobePlayed);}

            // to decide who is the winner
            if (Players.get(prevPlayer).getPlayerCards().size() == 0 && Players.get(prevPlayer).getIsUno() &&
                    Players.get(prevPlayer).getUnoCounter() == 2) {
                Winner(Players.get(prevPlayer));
                gameIsOver = true;
            } else if (Players.get(prevPlayer).getPlayerCards().size() == 0 && !Players.get(prevPlayer).getIsUno()) {
                Players.get(prevPlayer).getPlayerCards().add(deck.draw());
                Players.get(prevPlayer).getPlayerCards().add(deck.draw());
            }


            System.out.println("___________________________________________________________________ \n");
        }

    }

    @Override
    public void howToWin() {
        if (currentPlayer.getUnoCounter() == 2 && !gameIsOver) {
            currentPlayer.setIsUno(false);
            currentPlayer.setUnoCounter(0);
        }

        if (!(currentPlayer.getUnoCounter() == 1)) {
            System.out.println("If one Card left enter \"UNO\" , else enter -1");
            currentPlayer.setUno(scan.next());
        }

        if (currentPlayer.getIsUno() && currentPlayer.getUnoCounter() == 1) {
            currentPlayer.setUnoCounter(2);
        }

        if (currentPlayer.getUno().equalsIgnoreCase("UNO")) {
            currentPlayer.setIsUno(true);
            currentPlayer.setUnoCounter(1);
            currentPlayer.setUno("1");
        }
    }

    public void swapAction(int PlayerId){
        System.out.println("Choose Player id you want to Swap your cards with!");
        int id = scan.nextInt();
        while(id > Players.size()-1 || id <0){
            System.out.println("Invalid id - try again!");
             id = scan.nextInt();
        }

        List<Card> temps = Players.get(id).getPlayerCards();
        List<Card> temp2 = Players.get(PlayerId).getPlayerCards();

        Players.get(id).setPlayerCards(temp2);
        Players.get(PlayerId).setPlayerCards(temps);

        for(int i=0 ; i< Players.get(id).getPlayerCards().size() ; i++){
            if(Players.get(id).getPlayerCards().get(i) instanceof SWAP){
                Players.get(id).getPlayerCards().remove(i);
                break;
            }
        }

        System.out.println( "Your new Cards , Player:"+ PlayerId);
        Players.get(PlayerId).displayCards();

        System.out.println( "Your new Cards Player:" + id);
        Players.get(id).displayCards();

    }
}












