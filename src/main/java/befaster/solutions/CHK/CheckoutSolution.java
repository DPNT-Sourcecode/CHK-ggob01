package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;


public class CheckoutSolution {
    private final DiscounterFactory discounterFactory;
    private HashMap<String, SkuPricing> priceList = Helper.buildPriceList();
    private HashMap<String, Integer> aggregated = new HashMap<>();

    // DiscountFactory could ideally be injected if we wanted to completely switch out
    // discount functionality. Leaving as constructor created for now.
    public CheckoutSolution() {
        this.discounterFactory = new DiscounterFactory();
    }
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
            String discountPolicy = priceList.get(sku).getOfferType();

            Discounter discounter = this.discounterFactory.getDiscounter(discountPolicy);
            totalPrice += discounter.priceForSku(sku, this.aggregated);
        }
        resetAggregated();

        return totalPrice;
    }

    private void resetAggregated() {
        this.aggregated = new HashMap<>();
    }
}
