package befaster.solutions.CHK;

import java.util.HashMap;

public class SameProductDiscount extends Discounter{

    SameProductDiscount() {
        super();
    }

    @Override
    public int priceForSku(String sku, HashMap<String, Integer> aggregated) {
        int totalPrice = 0;
        pr

        int singleChargeItems = aggregated.get(sku);
        int offerMultiple = priceList.get(sku).getOfferMultiple();
        if (offerMultiple > 0) {
            totalPrice += (skuCount.getValue() / offerMultiple) * priceList.get(sku).getOfferPrice();
            singleChargeItems = skuCount.getValue() % offerMultiple;
        }
        totalPrice += singleChargeItems * priceList.get(sku).getPrice();
    }
}

