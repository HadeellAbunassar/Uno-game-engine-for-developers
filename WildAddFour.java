public class WildAddFour extends WildCard{

    public WildAddFour(){
            super("WILD_DRAW_FOUR");
    }

    @Override
    public void cardAction(Game game  , int PlayerId){
        System.out.println("___________________________________________________________________ \n");
        System.out.println("Player - " + PlayerId + " - Draws 4 cards and his/her turn is skipped");
        for(int i=0 ; i<4 ; i++){
            game.nextPlayerDraw();
        }
        game.advanceToNextPlayer();
    }
}
