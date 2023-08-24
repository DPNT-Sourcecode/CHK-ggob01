package befaster.solutions.CHK;

import java.util.HashMap;

public class Helper {

    public static HashMap<String, SkuPricing> buildPriceList() {
        HashMap<String, SkuPricing> pricing = new HashMap<>();

        OfferSpecs[] aos = new OfferSpecs[]{
            new OfferSpecs("A", 3, 130),
            new OfferSpecs("A", 5, 200),
        };
        pricing.put("A", new SkuPricing("A", 50, "sameProductDiscount", aos));

        OfferSpecs[] bos = new OfferSpecs[]{
            new OfferSpecs("B", 2, 45),
        };
        pricing.put("B", new SkuPricing("B", 30, "sameProductDiscount", bos));

        pricing.put("C", new SkuPricing("C", 20));
        pricing.put("D", new SkuPricing("D", 15));

        OfferSpecs[] eos = new OfferSpecs[]{
            new OfferSpecs("B", 2, 50),
        };
        pricing.put("E", new SkuPricing("E", 40, "otherProductDiscount", eos));

        return pricing;
    }

}
