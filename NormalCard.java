

public class NormalCard extends Card {
    private int number;

    public NormalCard(String color, int number) {
        super(color);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int returnedValue(){
        return getNumber();
    }

    @Override
    public  boolean canBePlayed(Card c,String color){
        if(c instanceof Wild){
            if((this.getColor().equalsIgnoreCase(color)))
                return true;
            else
           return false;}
        if(c instanceof WildAddFour) return  true;
        if(c instanceof SWAP) return true;

        else if (c instanceof  ActionCard ){
            if ( ((ActionCard) c).getActionType().equals(ActionCard.ActionType.DRAW_TWO))
                return true;
            else if ( this.getColor().equals(c.getColor()) )
                return true;
            else
                return false;
        }

        else if ( c instanceof NormalCard) {
         if (this.getNumber() == ((NormalCard) c).getNumber() || this.getColor().equalsIgnoreCase(c.getColor())) {
                return true;
            }
        }

           return false;
    }

    @Override
    public void cardAction(Game game  , int PlayerId){
        //do nothing

    }

    @Override
    public String toString(){
        return "Normal Card , Color: " + getColor() + " | Number: " + getNumber();
    }
}
