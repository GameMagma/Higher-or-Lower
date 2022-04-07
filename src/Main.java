import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(Util.font("Menu", Util.Styles.UNDERLINED));
        System.out.print(
                """
                        1. One Player
                        2. Two Player (vs. AI)
                        3. Two Player (vs. Person)
                        
                        Choose number now:""" + " "); // IDE shows a problem with trailing whitespaces. Although they
                                                      // won't break the program, I don't like random warnings

        switch (new Scanner(System.in).nextInt()) {
            case 1 -> GameManager.modeOnePlayer();
            case 2 -> GameManager.modeTwoPlayerAI();
            case 3 -> GameManager.modeTwoPlayerPerson();
        }
    }
}