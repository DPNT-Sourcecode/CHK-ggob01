package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckoutSolution {

    static Logger logger = Logger.getLogger(CheckoutSolution.class.getName());
    private HashMap<String, SkuPricing> priceList = Helper.buildPriceList();

    private HashMap<String, Integer> aggregated = new HashMap<>();
    public Integer checkout(String skus) {
        Integer totalPrice = 0;
        for (String sku : skus.split(", ")) {
            if (!priceList.containsKey(sku)) {
                return -1;
            }

            aggregateSku(sku);
        }

        return totalPriceFromAggregateMap();
    }

    private void aggregateSku(String sku) {
        int skuMultiple = aggregated.getOrDefault(sku, 0) + 1;
        aggregated.put(sku, skuMultiple);
    }

    private int totalPriceFromAggregateMap() {
        int totalPrice = 0;
        int singleChargeItems;
        for (Map.Entry<String, Integer> skuCount : aggregated.entrySet()) {
            String sku = skuCount.getKey();
            if
        }
        return 1;
    }
}




