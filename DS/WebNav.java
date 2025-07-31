import java.util.Scanner;
import java.util.Stack;

public class WebNav {

    public static void main(String[] args) {
        Stack<String> historyStack = new Stack<>();
        Stack<String> aheadStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        boolean sessionActive = true;

        System.out.println("=== Web Navigation History ===");

        while (sessionActive) {
            showMenu();
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear input buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter URL to visit: ");
                    String newPage = scanner.nextLine();
                    historyStack.push(newPage);
                    aheadStack.clear(); // reset forward history
                    System.out.println("You are now on: " + newPage);
                }

                case 2 -> {
                    if (historyStack.size() > 1) {
                        aheadStack.push(historyStack.pop());
                        System.out.println("Moved back to: " + historyStack.peek());
                    } else {
                        System.out.println("Can't go back further.");
                    }
                }

                case 3 -> {
                    if (!aheadStack.isEmpty()) {
                        String forwardPage = aheadStack.pop();
                        historyStack.push(forwardPage);
                        System.out.println("Moved forward to: " + forwardPage);
                    } else {
                        System.out.println("No forward page available.");
                    }
                }

                case 4 -> {
                    if (!historyStack.isEmpty()) {
                        System.out.println("Currently Viewing: " + historyStack.peek());
                    } else {
                        System.out.println("No pages visited yet.");
                    }
                }

                case 5 -> {
                    System.out.println("Closing browser...");
                    sessionActive = false;
                }

                default -> System.out.println("Invalid input! Please choose between 1 to 5.");
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n----- MENU -----");
        System.out.println("1. Open New Page");
        System.out.println("2. Back");
        System.out.println("3. Forward");
        System.out.println("4. Current Page");
        System.out.println("5. Exit");
    }
}
