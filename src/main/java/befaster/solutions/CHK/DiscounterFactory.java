package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.function.Supplier;

public class DiscounterFactory {

    private static final HashMap<String, Supplier<Discounter>> discounters = new HashMap<>();

    public DiscounterFactory() {
        discounters.put("sameProductDiscount", SameProductDiscount::new);
    }

    public Discounter getDiscounter(String discounterType) {
        return discounters.get(discounterType).get();
    }

}



