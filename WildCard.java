public abstract class WildCard extends Card{

    private String wildType;

    public WildCard(String wildType) {
        super(null);
        this.wildType = wildType;
    }

    public String getWildType() {
        return wildType;
    }

    @Override
    public int returnedValue(){
        return 50;
    }

    @Override
    public boolean canBePlayed(Card c, String color){
            return true; // you can always play a wild card
    }

    @Override
    public String toString(){
        return "Wild Card , Type : " + getWildType();
    }

}
