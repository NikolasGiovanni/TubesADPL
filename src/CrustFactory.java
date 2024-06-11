public class CrustFactory {
    public static Crust createCrust(int crustType) {
        if (crustType == 1) {
            return new ThinCrust();
        } else if (crustType == 2) {
            return new CheesyBitesCrust();
        } else if (crustType == 3) {
            return new StuffedCrust();
        } else {
            throw new IllegalArgumentException("Unknown crust type");
        }
    }

    public static Crust createCrustByName(String name) {
        if (name.equals("Thin Crust")) {
            return new ThinCrust();
        } else if (name.equals("Cheesy Bites Crust")) {
            return new CheesyBitesCrust();
        } else if (name.equals("Stuffed Crust")) {
            return new StuffedCrust();
        } else {
            throw new IllegalArgumentException("Unknown crust name");
        }
    }
}
