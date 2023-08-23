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

        Object parsed = new JSONParser().parse(new FileReader("./skusRaw.json"));
        JSONObject jparsed = (JSONObject) parsed;

        Iterator<Map.Entry> itr = jparsed.entrySet().iterator();
//            while (itr.hasNext()) {
//                Map.Entry<String, Object> sku = itr.next();
//
//                int price = sku.getValue().get("price");
//                SkuPricing price = new SkuPricing(sku.getKey(), sku.);
//
//                pricing.put(sku.getKey(), );
//            }
        return pricing;
    }

}
