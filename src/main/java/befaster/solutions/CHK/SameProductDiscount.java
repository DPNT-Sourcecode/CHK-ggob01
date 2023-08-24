package befaster.solutions.CHK;

import java.util.Arrays;
import java.util.HashMap;

public class SameProductDiscount extends Discounter{

    SameProductDiscount() {
        super();
    }

//    public int priceForSku2(String sku, HashMap<String, Integer> aggregated) {
//        int totalPrice = 0;
//
//        int singleChargeItems = aggregated.get(sku);
//        int offerMultiple = priceList.get(sku).getOfferMultiple();
//        if (aggregated.get(sku) >= offerMultiple && offerMultiple > 0) {
//            totalPrice += (aggregated.get(sku) / offerMultiple) * priceList.get(sku).getOfferPrice();
//            singleChargeItems = aggregated.get(sku) % offerMultiple;
//        }
//        totalPrice += singleChargeItems * priceList.get(sku).getPrice();
//        return totalPrice;
//    }

    @Override
    public int priceForSku(String sku, HashMap<String, Integer> aggregated) {
        int totalPrice = 0;

        int totalItemsForSku = aggregated.get(sku);
        int remainingForOffers = totalItemsForSku;
        // sort offers array and find largest
        OfferSpecs[] offers = priceList.get(sku).getOfferSpecs();
        Arrays.sort(offers);
        for (OfferSpecs offer : offers) {
            if (remainingForOffers > offer.getOfferMultiple()) {
                totalPrice += (remainingForOffers / offer.getOfferMultiple()) * offer.getOfferPrice();
                remainingForOffers = 
            }
        }
        return -1;
    }
}




