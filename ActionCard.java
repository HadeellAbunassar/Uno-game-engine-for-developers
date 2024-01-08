
public class ActionCard extends Card {
    public enum ActionType {
        REVERSE, SKIP, DRAW_TWO
    }

    private ActionType actionType;

    public ActionCard(String color, ActionType actionType) {
        super(color);
        this.actionType = actionType;
    }


    public ActionType getActionType() {
        return actionType;
    }



    @Override
    public int returnedValue(){
        return 20;
    }

    @Override
    public void cardAction(Game game , int playerId ){
      if(this.getActionType().equals(ActionType.REVERSE)){
          System.out.println("___________________________________________________________________ \n");
          System.out.println("Game direction is reversed");
          game.reverseDirection();
      }
        if(this.getActionType().equals(ActionType.DRAW_TWO)){
            System.out.println("___________________________________________________________________ \n");
            System.out.println("Player - " + playerId + " - Draws 2 cards and his/her turn is skipped");
            game.nextPlayerDraw();
            game.nextPlayerDraw();
            game.advanceToNextPlayer();
        }
        if(this.getActionType().equals(ActionType.SKIP)){
            System.out.println("___________________________________________________________________ \n");
            System.out.println("Player " + playerId + " turn is skipped");
            game.advanceToNextPlayer();
        }
    }

    @Override
    public  boolean canBePlayed(Card c,String color){

        if(c instanceof WildCard){
            if(((WildCard) c).getWildType().equalsIgnoreCase("WILD") && this.getActionType().equals(ActionType.DRAW_TWO))
                return true;
            else if(((WildCard) c).getWildType().equalsIgnoreCase("WILD") && !(this.getColor().equalsIgnoreCase(color)))
                return false;
            else
                return true;}

       else if (c instanceof ActionCard ){
           if(((ActionCard) c).getActionType().equals(this.actionType) || c.getColor().equalsIgnoreCase(this.getColor()) ||
              this.actionType.equals(ActionType.DRAW_TWO) || ((ActionCard) c).actionType.equals(ActionType.DRAW_TWO))
           return true;
           else return false;
       }

      if(c instanceof NormalCard){
        if (this.getColor().equalsIgnoreCase(c.getColor()) || this.actionType.equals(ActionType.DRAW_TWO))
           return true;
      }

       return false;
    }


    @Override
    public String toString(){
        if(this.getActionType().equals(ActionType.DRAW_TWO))
            return "Action Card , Type : " + getActionType();
        else
            return "Action Card , Color: " + getColor() + " | Action: " + getActionType();
    }
}
