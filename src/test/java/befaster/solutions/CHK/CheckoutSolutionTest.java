package befaster.solutions.CHK;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


import java.time.Instant;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CheckoutSolutionTest {

    private CheckoutSolution checkout;

    private final String nonDiscountSkuNumbers = "C, D";

    @BeforeAll
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

    @Test
    @DisplayName("aggregated count gets reset after each call")
    public void testAggregatereset() {
        checkout.checkout("A");
        assertEquals(checkout.checkout("A"), 50);
    }

    @Test
    @DisplayName("any non-alphanumeric character can be used to split skus in the string")
    public void testInputStringIsProperlySplit() {
        String[] variants = new String[] {
            "AAA",
            "A A A",
            "A, A, A",
            "A - A %         A"
        };

        for (String variant : variants) {
            assertEquals(checkout.checkout(variant), 130);
        }
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

        @Test
        public void testAll() {
            HashMap<String, Integer> assertions = new HashMap<>();
            id = CHK_R1_002, req = checkout(""), resp = 0
            id = CHK_R1_003, req = checkout("A"), resp = 50
            id = CHK_R1_004, req = checkout("B"), resp = 30
            id = CHK_R1_005, req = checkout("C"), resp = 20
            id = CHK_R1_006, req = checkout("D"), resp = 15
            id = CHK_R1_007, req = checkout("a"), resp = -1
            id = CHK_R1_008, req = checkout("-"), resp = -1
            id = CHK_R1_009, req = checkout("ABCa"), resp = -1
            id = CHK_R1_010, req = checkout("AxA"), resp = -1
            id = CHK_R1_011, req = checkout("ABCD"), resp = 115
            id = CHK_R1_012, req = checkout("A"), resp = 180
            id = CHK_R1_013, req = checkout("AA"), resp = 100
            id = CHK_R1_014, req = checkout("AAA"), resp = 130
            id = CHK_R1_015, req = checkout("AAAA"), resp = 180
            id = CHK_R1_016, req = checkout("AAAAA"), resp = 230
            id = CHK_R1_017, req = checkout("AAAAAA"), resp = 260
            id = CHK_R1_018, req = checkout("B"), resp = 30
            id = CHK_R1_019, req = checkout("BB"), resp = 45
            id = CHK_R1_020, req = checkout("BBB"), resp = 75
            id = CHK_R1_021, req = checkout("BBBB"), resp = 90
            id = CHK_R1_022, req = checkout("ABCDABCD"), resp = 215
            id = CHK_R1_023, req = checkout("BABDDCAC"), resp = 215
            id = CHK_R1_024, req = checkout("AAABB"), resp = 175
            id = CHK_R1_001, req = checkout("ABCDCBAABCABBAAA"), resp = 505

            assertEquals(115, checkout.checkout("ABCD"));
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


