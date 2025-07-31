import java.util.LinkedList;
import java.util.Scanner;

public class StudentAdmissionSystem {
    public static void main(String[] args) {
        LinkedList<String> admissionLine = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Select an option: ");
            int option = input.nextInt();
            input.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter student name: ");
                    String normalStudent = input.nextLine();
                    admissionLine.offerLast(normalStudent);
                    System.out.println("Student added to the end of the queue.");
                    break;

                case 2:
                    System.out.print("Enter VIP student name: ");
                    String vipStudent = input.nextLine();
                    admissionLine.offerFirst(vipStudent);
                    System.out.println("VIP student added to the front of the queue.");
                    break;

                case 3:
                    if (admissionLine.isEmpty()) {
                        System.out.println("Queue is empty. No students to admit.");
                    } else {
                        String admitted = admissionLine.pollFirst();
                        System.out.println("Admitted: " + admitted);
                    }
                    break;

                case 4:
                    System.out.println("Queue Status: " + admissionLine);
                    break;

                case 5:
                    System.out.println("Thank you. Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }

        input.close();
    }

    private static void displayMenu() {
        System.out.println("\n===== Student Admission Menu =====");
        System.out.println("1. Enqueue Normal Student");
        System.out.println("2. Enqueue VIP Student");
        System.out.println("3. Admit Student");
        System.out.println("4. Display Queue");
        System.out.println("5. Exit");
    }
}
