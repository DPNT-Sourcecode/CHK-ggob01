package befaster.solutions.CHK;

import java.util.HashMap;

public class OtherProductDiscount extends Discounter{
    @Override
    public int priceForSku(String sku, HashMap<String, Integer> aggregated) {
        int totalPrice = 0;

        int singleChargeItems = aggregated.get(sku);
        int offerMultiple = priceList.get(sku).getOfferMultiple();
        totalPrice += singleChargeItems * priceList.get(sku).getPrice();
        if (singleChargeItems >= offerMultiple && offerMultiple > 0) {
            int offerMultiplier = aggregated.get(sku) / offerMultiple;
            totalPrice -= (Math.min(offerMultiplier, aggregated.getOrDefault("B", 0))) * priceList.get("B").getPrice();
        }
        return totalPrice;
    }
}
