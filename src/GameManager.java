import java.util.Scanner;

/**
 * Runs/manages the game. Each gamemode function should be able to run the gamemode all on their own and have the following
 * format: mode{modeName} . Replace curly braces and modename with the name of the mode, i.e. modeOnePlayer, modeTwoPlayer
 */
public abstract class GameManager {
    static Scanner sc = new Scanner(System.in); // Input
    static DeckManager.Card playerCard, aiCard; // Holds the player's card and the AI's card (respectively)

    /**
     * One real player, with the AI acting as a non-participating dealer
     */
    public static void modeOnePlayer() {
        System.out.println("\nOne Player mode selected");

        DeckManager.init(); // Fills the deck with cards - you absolutely NEED to call this before doing anything with the deck

        String input; // Holds string inputs

        int win = 0, lose = 0; // How many times they've won, how many times they've lost

        boolean stay = true;
        while (stay) {
            System.out.print("\n\n"); // Extra bit of spacing between rounds

            if (DeckManager.isDeckEmpty()) { DeckManager.reset(); } // If we've run out of cards, fill it up again

            DeckManager.shuffle();

            /* Deal card to player and AI */
            playerCard = DeckManager.deal();
            aiCard = DeckManager.deal();

            /* Ask player what their choice is */
            System.out.print("Your card is the " + playerCard.name() + ". Is the AI's card Higher or Lower? Enter your choice now: ");
            input = sc.next().toLowerCase(); // Makes the whole thing lowercase to ignore the casing it was entered as
            System.out.println(); // Moves to next line

            /* Get and compare card values */
            if (aiCard.value() == playerCard.value()) {
                System.out.println("You had the " + playerCard.name() + ". The AI had the " + aiCard.name() + "." +
                        "\nIt was a tie! Try again.");
                System.out.println("Alright, you had the " + playerCard.name() + ". The AI had the " + aiCard.name() + ".");

            } else {
                // True = higher, false = lower
                boolean playerGuessedHigher; // The player's answer: true if they guessed higher, false if they guessed lower

                // Look for valid player input, change to the full word to make sure it prints correctly later
                String choice; // Standardized choice
                if (input.equals("higher") || input.equals("h") || input.equals("high")) {
                    playerGuessedHigher = true;
                } else if (input.equals("lower") || input.equals("l") || input.equals("low")) {
                    playerGuessedHigher = false;
                } else { // If they didn't enter any of these, then we don't know what they wanted, so just stop the program.
                    System.out.println("Invalid entry entered. Stopping program.");
                    playerGuessedHigher = false; // Trick IDE into thinking I assigned a value
                    System.exit(-1); // Exits with error code -1, signaling something went wrong.
                }

                // Determine correct answer
                boolean higher = (aiCard.value() > playerCard.value()); // If the AI's card is higher than the player's


                /* Tell player if they've won or not */
                System.out.println("Alright, you had the " + playerCard.name() + ". The AI had the " + aiCard.name() + ".");

                if ((playerGuessedHigher == higher)) {
                    System.out.println("Congrats, you win!");
                    win++;
                } else {
                    System.out.println("Sorry, you lost. Better luck next time.");
                    lose++;
                }
            }

            System.out.println("\nWins: " + win +
                    "\nLosses: " + lose);

            // See if user wants to keep playing
            System.out.print("Would you like to play again? Enter yes or no: ");
            input = sc.next();
            stay = (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y"));
        }

        System.out.println("Alright, thanks for playing!");
    }

    /**
     * Two players - one real, one AI. AI guesses higher or lower based on a random number generator.
     */
    public static void modeTwoPlayerAI() {
        System.out.println("\nTwo Player (AI) mode selected");
    }

    /**
     * Two players, both real. Game assumes the controls are passed between them as turns alternate
     */
    public static void modeTwoPlayerPerson() {
        System.out.println("\nTwo Player (Person) mode selected");
    }

    /**
     * Closes any open scanners, empties any used variables. Destroys the class.
     */
    public static void destroy() {
        sc.close();
        playerCard = null;
        aiCard = null;
    }
}
