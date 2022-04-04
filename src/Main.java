import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in); // Input
    static DeckManager.Card playerCard, aiCard; // Holds the player's card and the AI's card (respectively)

    public static void main(String[] args) {
        DeckManager.init(); // Fills the deck with cards - you absolutely NEED to call this before doing anything with the deck
        DeckManager.shuffle();

        /* Deal card to player and AI */
        playerCard = DeckManager.deal();
        aiCard = DeckManager.deal();

        /* Ask player what their choice is */
        System.out.print("Your card is the " + playerCard.getName() + ". Is the AI's card Higher or Lower? Enter your choice now: ");
        String choice = sc.next().toLowerCase(); // Makes the whole thing lowercase to ignore the casing it was entered as
        System.out.println(); // Moves to next line

        /* Get and compare card values */

        // 1 = Lower, 2 = the same, 3 = higher
        int correctAnswer; // Results of the comparison, in int form (to make it easier to test against)
        int playerAnswer = 0; // The player's answer, converted to int

        // Determine player answer and reassign choice to use later. Little icky, but whatever
        if (choice.equals("higher") || choice.equals("h") || choice.equals("high")) {
            playerAnswer = 3;
            choice = "higher";
        }
        else if (choice.equals("lower") || choice.equals("l") || choice.equals("low")) {
            playerAnswer = 1;
            choice = "lower";
        }
        else { // If they didn't enter any of these, then we don't know what they wanted, so just stop the program.
            System.out.println("Invalid entry entered. Stopping program.");
            System.exit(-1); // Exits with error code -1, signaling something went wrong.
        } // If I wanted to do a little more, I would suggest putting this in a loop so they could keep trying, or even
        // doing error handling. But I doubt that it's going to matter, unless people want to do it just to learn.

        // Determine correct answer
        if (aiCard.getValue() > playerCard.getValue()) { correctAnswer = 3; } // Higher
        else if (aiCard.getValue() < playerCard.getValue()) { correctAnswer = 1; } // Lower
        else { correctAnswer = 2; } /* Tie - If we wanted, we wouldn't even need to assign this to something here. Just
                                       say it's a tie and end the program. */


        /* Tell player if they've won or not */
        System.out.println("Alright, you had the " + playerCard.getName() + ". The AI had the " + aiCard.getName() + ".");

        boolean win = (playerAnswer == correctAnswer); // Whether the player won or not
        boolean tie = (correctAnswer == 2); // Whether the player tied or not (booleans only hold 2 values, this was easiest)

        if (tie) {
            System.out.println("Looks like it's a tie. Try again.");
        } else if (win) {
            System.out.println("Congrats, you win!");
        } else {
            System.out.println("Sorry, you lost. Better luck next time.");
        }
    }
}
