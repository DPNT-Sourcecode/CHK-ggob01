package befaster.solutions.CHK;

public class SkuPricing {

    private final String sku;
    private final int price;
    private final String offerType;
    private final OfferSpecs[] offerSpecs;

    public SkuPricing (String sku, int price, String offerType, OfferSpecs[] offerSpecs) {
        this.sku = sku;
        this.price = price;
        this.offerType = offerType;
        this.offerSpecs = offerSpecs;
    }

    public SkuPricing (String sku, int price) {
        this.sku = sku;
        this.price = price;
        this.offerType = "noDiscount";
        offerSpecs = new OfferSpecs[0];
    }

    public int getPrice() {
        return this.price;
    }

    public String getOfferType() {
        return this.offerType;
    }

    public OfferSpecs[] getOfferSpecs() {
        return this.offerSpecs;
    }

}
