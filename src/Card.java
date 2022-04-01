public class Card {
    private String name;
    private int value; // Value of 1 - 13, inclusive

    public Card(String name, String suit, int value) {
        this.name = name;
        this.value = value;
    }

    public Card getCard() { return this; }

    public String getName() { return name; }

    public int getValue() { return value; }
}
