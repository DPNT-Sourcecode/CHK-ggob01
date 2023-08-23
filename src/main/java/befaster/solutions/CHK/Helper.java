package befaster.solutions.CHK;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

public class Helper {

    public static HashMap<String, SkuPricing> buildPriceList() throws IOException, ParseException {
        HashMap<String, SkuPricing> pricing = new HashMap<>();

        pricing.put("A", new SkuPricing("A", 50, 3, 130));
        pricing.put("B", new SkuPricing("B", 30, 2, 45));
        pricing.put("B", new SkuPricing("C", 20));
        pricing.put("B", new SkuPricing("D", 15));

        return pricing;
    }

}

