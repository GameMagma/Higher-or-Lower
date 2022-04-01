import java.util.Random;
public class AI_Player {
    public AI_Player(int card[], int n) {
        /*
        Lindsey's part:
        Make Player name
        Use deck class to shuffle deck

         */
        String AI = "Omari";
        Random rand = new Random();
        for(int i=0; i<n; i++){
            int r = i = rand.nextInt(52-i);

            int temp = card[r];
            card[r] = card[i];
            card[i] = temp;
        }

        /*
        Omari's part:
        Assign deck class to the ai name
        make a getter for the ai's deck

         */

    }
}
