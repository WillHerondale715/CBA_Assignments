import java.util.*;

public class PasswordPrompt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String correctPassword = "richu@715"; // customized password
        String enteredPassword;
        int attempts = 0;
        final int MAX = 3;

        System.out.println("===== Welcome  =====");

        do {
            if (attempts >= MAX) {
                System.out.println("Maximum attempts reached. Access denied.");
                System.exit(0);
            }

            System.out.print("Enter your password: ");
            enteredPassword = scanner.nextLine();

            if (!enteredPassword.equals(correctPassword)) {
                System.out.println("Incorrect password. Please try again.\n");
                attempts++;
            }
        } while (!enteredPassword.equals(correctPassword));

        System.out.println("Access granted, Rishika! You logged in on attempt #" + (attempts + 1));
        System.out.println("Hello Rishika! Welcome ");
        scanner.close();
    }
}
