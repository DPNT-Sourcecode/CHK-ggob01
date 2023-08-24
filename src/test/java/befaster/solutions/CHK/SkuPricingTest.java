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
        sku = new SkuPricing("A", 10, "offerType", 2, 15);
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
    public void testGetOfferMultipleForSku() {
        assertThat(sku.getOfferMultiple() ,equalTo(2));
    }

    @Test
    public void testGetOfferPriceForSku() {
        assertThat(sku.getOfferPrice() ,equalTo(15));
    }
}

