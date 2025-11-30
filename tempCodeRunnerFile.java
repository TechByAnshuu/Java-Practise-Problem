import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int randomNum = (int)(Math.random() * 100) + 1;
        int userGuess = 0;
        int attempts = 0;

        System.out.println("Welcome to 'Guess the Number'! Try to guess the number between 1 and 100.");

        while (userGuess != randomNum) {
            System.out.print("Enter your guess: ");
            userGuess = sc.nextInt();
            attempts++;

            if (userGuess < randomNum) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > randomNum) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number " + randomNum + " in " + attempts + " attempts.");
            }
        }
    }
}
