import java.util.Collections;
import java.util.Stack;

/**
 * Manages the deck of cards. Provides several functions that allow us to interact with the deck
 */
public abstract class DeckManager {
    /**
     * The deck both the player and AI player uses. Each card has a name and a value you can access.
     * @see Card
     */
    public static Stack<Card> deck = new Stack<Card>();

    /**
     * NOTE: This MUST be called before you do anything with the deck.
     * Initializes the {@link #deck} stack: Iterates through each suit (hearts, clubs, spades, diamonds) and each
     * possible value (1-13 inclusive), creating a {@link Card} instance for each possible card and putting them into {@link #deck}.
     */
    public static void init() {
        String suitName, valueName; // Name of the suit of the card; name of the value ("Ace, Jack, Queen, King")

        // 2D for loop, iterate through each suit for each value
        for (int value = 1; value <= 13; value++) {
            valueName = switch (value) {
              case 1 -> "Ace";
              case 11 -> "Jack";
              case 12 -> "Queen";
              case 13 -> "King";
              default -> String.valueOf(value); // Any other cases than above are just numbers, so just return their value
            };

            for (int suit = 0; suit < 4; suit++) {
                suitName = switch (suit) {
                    case 0 -> "Hearts";
                    case 1 -> "Clubs";
                    case 2 -> "Spades";
                    case 3 -> "Diamonds";
                    default -> throw new IllegalStateException("Unexpected value: " + suit);
                };

                // Adds a new card instance with the current suit and value name
                deck.push(new Card( (valueName + " of " + suitName), value ));
            }
        }
    }

    /** Shuffles the deck */
    public static void shuffle() { Collections.shuffle(deck); }

    /** Deals 1 card and removes it from the deck */
    public static Card deal() { return deck.pop(); }

    /** Resets the deck by wiping it and then running {@link #init} again */
    public static void reset() {
        deck.removeAll(deck);
        DeckManager.init();
    }

    /**
     * Card containing name (i.e. "7 of Diamonds") and value (i.e. "7 of Diamonds" would have a value of 7)
     */
    public static record Card(String name, int value) {

        /**
         * @return The instance itself
         */
        public Card getCard() { return this; }

        /**
         * @return Name of the card; i.e. "7 of Diamonds", "King of Hearts
         */
        public String getName() { return name; }

        /**
         * @return Numerical value of the card; "7 of Diamonds" = 7, King of Hearts = 13"
         */
        public int getValue() { return value; } // Ace = 1, Jack = 11, Queen = 12, King = 13

        @Override
        public String toString() {
            return "DeckManager.Card{" +
                    "name='" + name + '\'' +
                    ", value=" + value +
                    '}';
        }
    }
}