package codsoft;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        
        while (playAgain) {
            int randomNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Guess the number between " + LOWER_BOUND + " and " + UPPER_BOUND + ": ");
            
            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalScore += (MAX_ATTEMPTS - attempts + 1); // Higher score for fewer attempts
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + MAX_ATTEMPTS + " attempts. The correct number was " + randomNumber);
            }
            
            System.out.println("Your total score is: " + totalScore);
            
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }
        
        System.out.println("Thank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
