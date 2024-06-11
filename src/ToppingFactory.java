public class ToppingFactory {
    public static Topping createTopping(int toppingType, String customToppingName) {
        if (toppingType == 1) {
            return new CheeseTopping();
        } else if (toppingType == 2) {
            return new PepperoniTopping();
        } else if (toppingType == 3) {
            return new VeggieTopping();
        } else if (toppingType == 4) {
            return new CustomTopping(customToppingName);
        } else {
            throw new IllegalArgumentException("Unknown topping type");
        }
    }
}
