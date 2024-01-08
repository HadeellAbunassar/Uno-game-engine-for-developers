public class SWAP extends WildCard{
    public SWAP(){
        super("SWAP");
    }

    @Override
    public void cardAction(Game game  , int PlayerId){
        System.out.println("___________________________________________________________________ \n");
        ((MyGame) game).swapAction(PlayerId  );
    }

}
