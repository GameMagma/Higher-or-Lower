import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in); // Input
    static DeckManager.Card playerCard, aiCard; // Holds the player's card and the AI's card (respectively)

    public static void main(String[] args) {
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
                } // If I wanted to do a little more, I would suggest putting this in a loop, so they could keep trying, or even
                // doing error handling. But I doubt that it's going to matter, unless people want to do it just to learn.

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

        sc.close();
    }
}
