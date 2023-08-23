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

    @Test
    @DisplayName("-1 is returned when a non-existent sku is queried")
    public void testIllegalSku() {
        String nonExistentSku = "$";
        assertEquals(checkout.checkout(nonExistentSku), -1);
    }

    @Test
    @DisplayName("If not skus are passed return value is 0")
    public void testWithNoSkus() {
        assertEquals(checkout.checkout(""), 0);
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

    @Nested
    @DisplayName("When there are offer items to apply")
    class WithDiscounts {

        @Test
        @DisplayName("The discount is applied as expected when the number of items meets the minimu criteria")
        public void testTotalSumWithMultibuyDiscount() {
            Integer PriceFor3PackOfSkuA = 130;

            assertEquals(checkout.checkout("A,A,A"), PriceFor3PackOfSkuA);
        }

        @Test
        @DisplayName("Discount is only applied to multiples for the offer")
        public void testTotalSumWithOfferStragglers() {
            Integer PriceFor4PackOfSkuA = 180; // 130 + 50 for 4th product not part of 3 pack

            assertEquals(checkout.checkout("A,A,A,A"), PriceFor4PackOfSkuA);
        }
    }

}

