package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.function.Supplier;

public class DiscounterFactory {

    private final HashMap<String, Supplier<Discounter>> discounters = new HashMap<>();

    public DiscounterFactory() {
        this.discounters.put("sameProductDiscount", SameProductDiscount::new);
    }

    public Discounter getDiscounter(String discounterType) {
        return this.discounters.get(discounterType).get();
    }

}


