import Java.util.Scanner;
public class GuessTheNumber{
    public static void main(String  args[]){
        Scanner sc= new Scanner(System.in);
        int randomNum= (int)(Math.ramdom()*100)+1;
        int userGuess=0;
        int attempts= 0;
        System.out.println("Welcome to Guess the Number ! Try to guss the number 1 to 100.);
        While(userGuess = randomNum){
            System.out.println("Ente ryour Guess: ");
            userGuess = sc.nextInt();
            attempts++;
            if(userguess > attempts){
                System.out.println("Too High! Try Again")
            }else if(userGuess < attempts){
                System.out.println("Too Low ! Try Again" )
            }else{
                System.out.Println("Congratulations! you mangaes to gues the Correct Number in " + attempts"+);
            }           
        }

    }
}