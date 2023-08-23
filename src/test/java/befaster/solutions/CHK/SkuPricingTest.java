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
        sku = new SkuPricing("A", 10, 2, 15);
    }

    @Test
//    @DisplayName("A price for a given Sku is returned");
    public void testGetPriceForSku() {
        assertThat(sku.getPrice() ,equalTo(10));
    }

}
