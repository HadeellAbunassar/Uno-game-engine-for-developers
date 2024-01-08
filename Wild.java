public class Wild extends WildCard{

    public Wild(){
        super("WILD");
    }

    @Override
    public void cardAction(Game game  , int PlayerId){
           game.chooseColorIfWild();

    }
}
