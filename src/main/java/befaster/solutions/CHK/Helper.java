package befaster.solutions.CHK;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class Helper {

    public static HashMap<String, SkuPricing> buildPriceList() {
        HashMap<String, SkuPricing> pricing = new HashMap<>();

        pricing.put("A", new SkuPricing("A", 50, 3, 130));
        pricing.put("B", new SkuPricing("B", 30, 2, 45));
        pricing.put("C", new SkuPricing("C", 20));
        pricing.put("D", new SkuPricing("D", 15));

        return pricing;
    }

}
