package befaster.solutions.CHK;

public class SkuPricing {

    private final String sku;
    private final int price;
    private final int offerMultiple;
    private final int offerPrice;

    public SkuPricing (String sku, int price, int offerMultiple, int offerPrice) {
        this.sku = sku;
        this.price = price;
        this.offerMultiple = offerMultiple;
        this.offerPrice = offerPrice;
    }

    public SkuPricing (String sku, int price) {
        SkuPricing(sku, price, 0, 0);
    }

    public int getPrice() {
        return this.price;
    }
}

