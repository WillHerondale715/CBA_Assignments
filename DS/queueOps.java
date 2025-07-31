import java.util.*;

public class queueOps {

    public static void main(String[] args) {
        Queue<String> printQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Print Job Queue Manager ===");

        while (running) {
            showMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter job name: ");
                    String job = scanner.nextLine();
                    printQueue.add(job);
                    System.out.println("Job \"" + job + "\" added to the queue.");
                }

                case 2 -> {
                    if (printQueue.isEmpty()) {
                        System.out.println("No jobs to process.");
                    } else {
                        System.out.println("Processing job: " + printQueue.poll());
                    }
                }

                case 3 -> {
                    if (printQueue.isEmpty()) {
                        System.out.println("No pending jobs.");
                    } else {
                        System.out.println("Pending Jobs: " + printQueue);
                    }
                }

                case 4 -> {
                    if (printQueue.isEmpty()) {
                        System.out.println("Queue is empty. Nothing to reverse.");
                    } else {
                        reverseQueue(printQueue);
                        System.out.println("Queue has been reversed.");
                    }
                }

                case 5 -> {
                    System.out.println("Exiting Print Job Manager...");
                    running = false;
                }

                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    // Display available options
    private static void showMenu() {
        System.out.println("\n----- Menu -----");
        System.out.println("1. Add Print Job");
        System.out.println("2. Process Job");
        System.out.println("3. View Pending Jobs");
        System.out.println("4. Reverse Job Queue");
        System.out.println("5. Exit");
    }

    // Reverse the current print queue using a stack
    private static void reverseQueue(Queue<String> queue) {
        Stack<String> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
}
