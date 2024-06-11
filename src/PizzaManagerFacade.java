import java.util.ArrayList;
import java.util.List;

public class PizzaManagerFacade {
    private final ToppingOriginator originator = new ToppingOriginator();
    private final ToppingCaretaker caretaker = new ToppingCaretaker();
    private final List<Topping> toppings = new ArrayList<>();
    private Crust crust;
    private boolean crustSelected = false;

    public void setCrust(int crustType) {
        if (!crustSelected) {
            crust = CrustFactory.createCrust(crustType);
            crustSelected = true;
            originator.setState(getOrder());
            caretaker.add(originator.saveStateToMemento());
        } else {
            System.out.println("Crust has already been selected.");
        }
    }

    public void addTopping(int toppingType, String customToppingName) {
        Topping topping = ToppingFactory.createTopping(toppingType, customToppingName);
        toppings.add(topping);
        originator.setState(getOrder());
        caretaker.add(originator.saveStateToMemento());
    }

    public void undo() {
        if (caretaker.size() > 1) {
            caretaker.removeLast();
            ToppingMemento memento = caretaker.get(caretaker.size() - 1);
            originator.getStateFromMemento(memento);
            restoreState(originator.getState());
        } else if (caretaker.size() == 1) {
            crust = null;
            crustSelected = false;
            toppings.clear();
            caretaker.removeLast();
            originator.setState("");
        } else {
            System.out.println("No previous states to revert to.");
        }
    }

    public String getToppings() {
        return toppingsToString();
    }

    public String getCrust() {
        return crust != null ? crust.getName() : "No crust selected";
    }

    public String getOrder() {
        return "Crust: " + getCrust() + ", Toppings: " + getToppings();
    }

    private String toppingsToString() {
        StringBuilder sb = new StringBuilder();
        for (Topping topping : toppings) {
            sb.append(topping.getName()).append(", ");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "";
    }

    private void restoreState(String state) {
        String[] parts = state.split(", Toppings: ");
        crust = parts[0].equals("No crust selected") ? null : CrustFactory.createCrustByName(parts[0].substring(7));
        crustSelected = crust != null;
        if (parts.length > 1) {
            setToppingsFromString(parts[1]);
        } else {
            toppings.clear();
        }
    }

    private void setToppingsFromString(String state) {
        toppings.clear();
        if (!state.isEmpty()) {
            String[] toppingNames = state.split(", ");
            for (String name : toppingNames) {
                if (name.equals("Cheese")) {
                    toppings.add(new CheeseTopping());
                } else if (name.equals("Pepperoni")) {
                    toppings.add(new PepperoniTopping());
                } else if (name.equals("Veggie")) {
                    toppings.add(new VeggieTopping());
                } else {
                    toppings.add(new CustomTopping(name));
                }
            }
        }
    }

    public void displayCrustMenu() {
        System.out.println("Available Crusts:");
        System.out.println("1. Thin Crust");
        System.out.println("2. Cheesy Bites Crust");
        System.out.println("3. Stuffed Crust");
    }

    public void displayToppingMenu() {
        System.out.println("Available Toppings:");
        System.out.println("1. Cheese");
        System.out.println("2. Pepperoni");
        System.out.println("3. Veggie");
    }
}

