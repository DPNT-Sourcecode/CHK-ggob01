package befaster.solutions.CHK;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionTest {

    private CheckoutSolution checkout;

    private final String nonDiscountSkuNumbers = "C, D";

    @BeforeEach
    public void setUp() {
        checkout = new CheckoutSolution();
    }

    @Nested
    @DisplayName("when there are no discounts to apply")
    class WithoutDiscounts {

        @Test
        @DisplayName("then the total sum of the skus should be returned")
        public void testTotalSumOfProducts() {
            Integer sumOfnonDiscountSkus = 35;

            assertEquals(checkout.checkout(nonDiscountSkuNumbers), sumOfnonDiscountSkus);
        }

    }

}


