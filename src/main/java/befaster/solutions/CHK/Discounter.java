package befaster.solutions.CHK;

import java.util.HashMap;

public abstract class Discounter {

    private final HashMap<String, SkuPricing> priceList;
    public Discounter(){
        priceList = Helper.buildPriceList();
    }
    public abstract int priceForSku(String sku, HashMap<String, Integer> aggregated);
}

