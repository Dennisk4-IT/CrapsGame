import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner userScanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            rand.nextInt(12);
            int randBirthMonth = rand.nextInt(12) + 1;
            System.out.println("Random birth month: " + randBirthMonth);

            int die1 = rand.nextInt(6) + 1;
            int die2 = rand.nextInt(6) + 1;
            int crapsRoll = die1 + die2; // Sum of the dice

            System.out.println("You rolled a " + die1 + " and a " + die2 + ". Sum = " + crapsRoll);

            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                System.out.println("You crapped out! You have lost.");
            } else if (crapsRoll == 7 || crapsRoll == 11) {
                System.out.println("Natural! You have won!");
            } else {
                int point = crapsRoll;
                System.out.println("The point is " + point + ". Trying for point");

                while (true) {
                    die1 = rand.nextInt(6) + 1;
                    die2 = rand.nextInt(6) + 1;
                    crapsRoll = die1 + die2; // New sum

                    System.out.println("You rolled a " + die1 + " and a " + die2 + ". Sum = " + crapsRoll);

                    if (crapsRoll == 7) {
                        System.out.println("You have rolled a 7! Oh no! You have lost.");
                        break;
                    } else if (crapsRoll == point) {
                        System.out.println("You made the point! Yay. You have win!");
                        break;
                    }
                }
            }

            System.out.print("Would you like to play again? (yes/no): ");
            String response = userScanner.nextLine().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thank you so much for playing!");
        userScanner.close();
    }
}
