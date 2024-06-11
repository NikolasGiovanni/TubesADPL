import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PizzaManagerFacade facade = new PizzaManagerFacade();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Main Menu:");
            System.out.println("1. Choose crust");
            System.out.println("2. Choose topping");
            System.out.println("3. Add custom topping");
            System.out.println("4. Undo last action");
            System.out.println("5. Display order");
            System.out.println("0. Finish order");
            System.out.print("Select an option (0-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    facade.displayCrustMenu();
                    System.out.print("Select a crust (1-3): ");
                    int crustChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    facade.setCrust(crustChoice);
                    break;

                case 2:
                    facade.displayToppingMenu();
                    System.out.print("Select a topping (1-3): ");
                    int toppingChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    facade.addTopping(toppingChoice, "");
                    break;

                case 3:
                    System.out.print("Enter custom topping name: ");
                    String customName = scanner.nextLine();
                    facade.addTopping(4, customName);
                    break;

                case 4:
                    facade.undo();
                    break;

                case 5:
                    System.out.println("Current Order: " + facade.getOrder());
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please select again.");
            }

            System.out.println("Current Order: " + facade.getOrder());
        }

        System.out.println("Final Order: " + facade.getOrder());
        scanner.close();
    }
}
