package befaster.solutions.CHK;

import java.util.Arrays;
import java.util.HashMap;

public class SameProductDiscount extends Discounter{

    SameProductDiscount() {
        super();
    }

    @Override
    public int priceForSku(String sku, HashMap<String, Integer> aggregated) {
        int totalPrice = 0;

        int remainingForOffers = aggregated.get(sku);
        OfferSpecs[] offers = priceList.get(sku).getOfferSpecs();
        Arrays.sort(offers);
        for (OfferSpecs offer : offers) {
            if (remainingForOffers >= offer.getOfferMultiple()) {
                totalPrice += (remainingForOffers / offer.getOfferMultiple()) * offer.getOfferPrice();
                remainingForOffers = remainingForOffers % offer.getOfferMultiple();
            }
        }
        totalPrice += remainingForOffers * priceList.get(sku).getPrice();
        return totalPrice;
    }
}






