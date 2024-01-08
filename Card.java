
public abstract class Card {
    private String color;

    public Card(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract int returnedValue();
    public abstract void cardAction(Game game , int PlayerId);

    //this method will compare topCard  with the passed card
    public abstract boolean canBePlayed(Card topCard , String color);

}
