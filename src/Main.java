import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("TEST");
        PizzaManagerFacade facade = new PizzaManagerFacade();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            facade.displayToppingMenu();
            System.out.print("Select a topping (1-5, or 0 to finish): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1 || choice == 2 || choice == 3) {
                facade.addTopping(choice, "");
            } else if (choice == 4) {
                System.out.print("Enter custom topping name: ");
                String customName = scanner.nextLine();
                facade.addTopping(choice, customName);
            } else if (choice == 5) {
                facade.undo();
            } else if (choice == 0) {
                running = false;
            } else {
                System.out.println("Invalid choice. Please select again.");
            }

            System.out.println("Current Toppings: " + facade.getToppings());
        }

        System.out.println("Final Toppings: " + facade.getToppings());
        scanner.close();
    }
}