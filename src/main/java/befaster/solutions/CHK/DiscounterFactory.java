package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.function.Supplier;

public class DiscounterFactory {
    private static final HashMap<String, Supplier<Discounter>> discounters = new HashMap<>();

    public DiscounterFactory() {
        discounters.put("noDiscount", NoDiscount::new);
        discounters.put("sameProductDiscount", SameProductDiscount::new);
        discounters.put("otherProductDiscount", OtherProductDiscount::new);
    }

    public Discounter getDiscounter(String discounterType) {
        return discounters.get(discounterType).get();
    }
}

