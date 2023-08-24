package befaster.solutions.CHK;

import java.util.HashMap;

public class SameProductDiscount extends Discounter{

    SameProductDiscount() {
        super();
    }

    @Override
    public int priceForSku(String sku, HashMap<String, Integer> aggregated) {
        int totalPrice = 0;

        int singleChargeItems = aggregated.get(sku);
        int offerMultiple = priceList.get(sku).getOfferMultiple();
        if (aggregated.get(sku) >= offerMultiple && offerMultiple > 0) {
            totalPrice += (aggregated.get(sku) / offerMultiple) * priceList.get(sku).getOfferPrice();
            singleChargeItems = aggregated.get(sku) % offerMultiple;
        }
        totalPrice += singleChargeItems * priceList.get(sku).getPrice();
        return totalPrice;
    }
}


