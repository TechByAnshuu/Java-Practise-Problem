import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int randomNum = (int) (Math.random() * 100) + 1;
        int userGuess = 0;
        int attempts = 0;
        System.out.println("Welcome to Guess the Number! Try to guess the number 1 to 100.");
        while (userGuess != randomNum) {
            System.out.print("Enter your Guess: ");
            userGuess = sc.nextInt();
            attempts++;

            if (userGuess > randomNum) {
                System.out.println("Too High! Try Again");
            } else if (userGuess < randomNum) {
                System.out.println("Too Low! Try Again");
            } else {
                System.out.println("Congratulations! you managed to guess the correct number in " + attempts + " attempts.");
            }
        }

        sc.close();
    }
}
