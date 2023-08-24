package befaster.solutions.CHK;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SkuPricingTest {

    private SkuPricing sku;

    @BeforeEach
    public void setUp() {
        OfferSpecs[] aos = new OfferSpecs[]{
            new OfferSpecs("A", 3, 130),
            new OfferSpecs("A", 5, 200),
        };
        sku = new SkuPricing("A", 10, "offerType", aos);
    }

    @Test
    public void testGetPriceForSku() {
        assertThat(sku.getPrice() ,equalTo(10));
    }

    @Test
    public void testGetOfferTypeForSku() {
        assertThat(sku.getOfferType() ,equalTo("offerType"));
    }

    @Test
    public void testGetOfferSpecsForSku() {
        OfferSpecs[] aos = new OfferSpecs[]{
            new OfferSpecs("A", 3, 130),
            new OfferSpecs("A", 5, 200),
        };
        assertThat(sku.getOfferSpecs() ,equalTo(aos));
    }
}
