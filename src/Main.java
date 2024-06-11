import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PizzaManagerFacade facade = new PizzaManagerFacade();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Main Menu:");
            System.out.println("1. Pilih crust");
            System.out.println("2. Pilih topping");
            System.out.println("3. Pilih custom topping");
            System.out.println("4. Undo");
            System.out.println("5. Tunjukan pesanan");
            System.out.println("0. Selesai");
            System.out.print("Silahkan pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    facade.displayCrustMenu();
                    System.out.print("Pilih crust: ");
                    int crustChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    facade.setCrust(crustChoice);
                    break;

                case 2:
                    facade.displayToppingMenu();
                    System.out.print("Pilih topping: ");
                    int toppingChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    facade.addTopping(toppingChoice, "");
                    break;

                case 3:
                    System.out.print("Masukan custom topping yang diinginkan: ");
                    String customName = scanner.nextLine();
                    facade.addTopping(4, customName);
                    break;

                case 4:
                    facade.undo();
                    break;

                case 5:
                    System.out.println("Pesanan sekarang: \n" + facade.getOrder());
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Masukan nomor yang terdaftar pada menu");
            }
        }

        System.out.println("Pesanan: " + facade.getOrder());
        scanner.close();
    }
}
