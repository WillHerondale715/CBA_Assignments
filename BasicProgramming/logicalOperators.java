public class logicalOperators {
    public static void main(String[] args) {
        boolean isAdult = true;
        boolean hasLiscence = false;
        boolean canDrive = false;

        System.out.println("isAdult && hasLiscence: " + (isAdult && hasLiscence));
        System.out.println("isAdult || hasLiscence: " + (isAdult || hasLiscence));
        System.out.println("!isAdult: " + (!isAdult));
        System.out.println("isAdult && (hasLiscence || canDrive ): " + (isAdult && (hasLiscence || canDrive )));
    }
}
