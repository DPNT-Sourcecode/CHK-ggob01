package befaster.solutions.CHK;

import java.util.HashMap;

public class OtherProductDiscount extends Discounter{
    @Override
    public int priceForSku(String sku, HashMap<String, Integer> aggregated) {
        int totalPrice = 0;

        int singleChargeItems = aggregated.get(sku);
        int offerMultiple = priceList.get(sku).getOfferMultiple();
        if (offerMultiple > 0) {
            int offerMultiplier = aggregated.get(sku) / offerMultiple;
            totalPrice += offerMultiplier * priceList.get(sku).getOfferPrice();
            totalPrice -= (Math.min(offerMultiplier, aggregated.get("B"))) * priceList.get("B").getPrice();
            singleChargeItems = aggregated.get(sku) % offerMultiple;
        }
        totalPrice += singleChargeItems * priceList.get(sku).getPrice();
        return totalPrice;
    }
}

