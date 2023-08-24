package befaster.solutions.CHK;

public class SkuPricing {

    private final String sku;
    private final int price;
    private final int offerMultiple;
    private final int offerPrice;
    private final String offerType;

    public SkuPricing (String sku, int price, String offerType, int offerMultiple, int offerPrice) {
        this.sku = sku;
        this.price = price;
        this.offerType = offerType;
        this.offerMultiple = offerMultiple;
        this.offerPrice = offerPrice;
    }

    public SkuPricing (String sku, int price) {
        this.sku = sku;
        this.price = price;
        this.offerType = "";
        this.offerMultiple = 0;
        this.offerPrice = 0;
    }

    public int getPrice() {
        return this.price;
    }

    public String getOfferType() {
        return this.offerType;
    }

    public int getOfferMultiple() {
        return this.offerMultiple;
    }

    public int getOfferPrice() {
        return this.offerPrice;
    }
}


