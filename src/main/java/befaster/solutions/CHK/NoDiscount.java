package befaster.solutions.CHK;

import java.util.HashMap;

public class NoDiscount extends Discounter{
    @Override
    public int priceForSku(String sku, HashMap<String, Integer> aggregated) {
        int singleChargeItems = aggregated.get(sku);
        return singleChargeItems * priceList.get(sku).getPrice();
    }
}
