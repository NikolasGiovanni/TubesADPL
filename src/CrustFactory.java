public class CrustFactory {
    private static final String[] VALID_CRUSTS = {"Thin Crust", "Cheesy Bites Crust", "Stuffed Crust", "Normal Crust"};

    public static Crust createCrust(int crustType) {
        if (crustType == 1) {
            return new ThinCrust();
        } else if (crustType == 2) {
            return new CheesyBitesCrust();
        } else if (crustType == 3) {
            return new StuffedCrust();
        } else if (crustType == 0) {
            return new NormalCrust();
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
        } else if (name.equals("Normal Crust")) {
            return new NormalCrust();
        } else {
            throw new IllegalArgumentException("Unknown crust name");
        }
    }

    public static boolean isValidCrust(String name) {
        for (String validCrust : VALID_CRUSTS) {
            if (validCrust.equals(name)) {
                return true;
            }
        }
        return false;
    }
}
