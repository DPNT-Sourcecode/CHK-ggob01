package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckoutSolution {
    private HashMap<String, SkuPricing> priceList = Helper.buildPriceList();
    private HashMap<String, Integer> aggregated = new HashMap<>();
    public Integer checkout(String skus) {
        if (skus.isBlank()) {
            return 0;
        }

        for (String sku : skus.replaceAll("[^A-Za-z]","").split("")) {
            if (!priceList.containsKey(sku)) {
                resetAggregated();
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

        for (Map.Entry<String, Integer> skuCount : aggregated.entrySet()) {
            String sku = skuCount.getKey();
            Discounter discounter =
            totalPrice += discounter.priceForSku(sku, this.aggregated);
        }
        resetAggregated();

        return totalPrice;
    }

    private void resetAggregated() {
        this.aggregated = new HashMap<>();
    }
}


