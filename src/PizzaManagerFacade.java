import java.util.ArrayList;
import java.util.List;

public class PizzaManagerFacade {
    private final ToppingOriginator originator = new ToppingOriginator();
    private final ToppingCaretaker caretaker = new ToppingCaretaker();
    private final List<Topping> toppings = new ArrayList<>();

    public void addTopping(int toppingType, String customToppingName) {
        Topping topping = ToppingFactory.createTopping(toppingType, customToppingName);
        toppings.add(topping);
        originator.setState(toppingsToString());
        caretaker.add(originator.saveStateToMemento());
    }

    public void undo() {
        if (caretaker.size() > 0) {
            caretaker.removeLast();
            if (caretaker.size() > 0) {
                ToppingMemento memento = caretaker.get(caretaker.size() - 1);
                originator.getStateFromMemento(memento);
                setToppingsFromString(originator.getState());
            } else {
                toppings.clear(); // Jika tidak ada lagi state yang bisa di-undo, kosongkan daftar toppings
            }
        } else {
            System.out.println("No previous states to revert to.");
        }
    }
    

    public String getToppings() {
        return toppingsToString();
    }

    private String toppingsToString() {
        StringBuilder sb = new StringBuilder();
        for (Topping topping : toppings) {
            sb.append(topping.getName()).append(", ");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "";
    }

    private void setToppingsFromString(String state) {
        toppings.clear();
        if (!state.isEmpty()) {
            String[] toppingNames = state.split(", ");
            for (String name : toppingNames) {
                toppings.add(new CustomTopping(name));
            }
        }
    }

    public void displayToppingMenu() {
        System.out.println("Available Toppings:");
        System.out.println("1. Cheese");
        System.out.println("2. Pepperoni");
        System.out.println("3. Veggie");
        System.out.println("4. Custom Topping");
        System.out.println("5. Undo Last Topping");
        System.out.println("0. Finish Selection");
    }
}
