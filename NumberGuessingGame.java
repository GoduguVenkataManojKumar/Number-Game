package CodSoft_Task1;

import java.util.*;
public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        
        do {
           
            int randomNumber = r.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("\nRound " + (rounds + 1));
            System.out.println("Guess the number between " + minRange + " and " + maxRange);

            
            while (attempts < maxAttempts) {
                
                int userGuess = getUserInput(sc, "Enter your guess: ");

                
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! Your guess is correct.");
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts++;
            }

            
            if (attempts == maxAttempts) {
                System.out.println("Sorry! You've reached the maximum number of attempts. The correct number was: " + randomNumber);
            }

            totalAttempts += attempts;

            
            rounds++;
            System.out.print("Do you want to play again? (yes/no): ");
        } while (sc.next().equalsIgnoreCase("yes"));

        
        System.out.println("\nGame Over!");
        System.out.println("Rounds played: " + rounds);
        System.out.println("Total attempts: " + totalAttempts);

        sc.close();
    }

    private static int getUserInput(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            System.out.print(message);
            sc.next(); 
        }
        return sc.nextInt();
    }
}
