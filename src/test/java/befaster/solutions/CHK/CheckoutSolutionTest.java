package befaster.solutions.CHK;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.util.HashMap;


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
            assertEquals(130, checkout.checkout(variant));
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
            assertions.put("", 0);
            assertions.put("A", 50);
            assertions.put("B", 30);
            assertions.put("C", 20);
            assertions.put("D", 15);
            assertions.put("a", -1);
            assertions.put("-", -1);
            assertions.put("ABCa", -1);
            assertions.put("AxA", -1);
            assertions.put("ABCD", 115);
            assertions.put("AA", 100);
            assertions.put("AAA", 130);
            assertions.put("AAAA", 180);
            assertions.put("AAAAA", 200);
            assertions.put("AAAAAA", 250);
            assertions.put("AAAAAAA", 300);
            assertions.put("BB", 45);
            assertions.put("BBB", 75);
            assertions.put("BBBB", 90);
            assertions.put("ABCDABCD", 215);
            assertions.put("BABDDCAC", 215);
            assertions.put("AAABB", 175);
            assertions.put("ABCDCBAABCABBAAA", 495);
            assertions.put("EEEEBB", 160); // will need to make changes to deduct from B sku aggregate BEFORE processing B skus...
            assertions.put("BEBEEE", 160);
            assertions.put("ABCDEABCDE", 280);

            assertions.forEach((skus, cost) -> assertEquals(cost, checkout.checkout(skus)));
        }

    }

    @Nested
    @DisplayName("When there are same product discount offer items to apply")
    class WithSameProductDiscounts {

        @Test
        @DisplayName("The discount is applied as expected when the number of items meets the minimum criteria")
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

    @Nested
    @DisplayName("When there are other product discount offer items to apply")
    class WithOtherProductDiscounts {

        @Test
        @DisplayName("The discount is applied as expected when the number of items meets the minimum criteria")
        public void testTotalSumWithMultibuyDiscount() {
            Integer DiscountPrice = 80;

            assertEquals(checkout.checkout("E, E, B"), DiscountPrice);
        }

        @Test
        @DisplayName("The discount is applied as expected when the number of items meets the minimum criteria")
        public void testTotalSumWithNonQualifyingDiscount() {
            Integer DiscountPrice = 80;

            assertEquals(checkout.checkout("EE"), DiscountPrice);
        }

        @Test
        @DisplayName("Discount is only applied to multiples for the offer")
        public void testTotalSumWithOfferStragglers() {
            Integer DiscountPrice = 120; // 130 + 50 for 4th product not part of 3 pack

            assertEquals(checkout.checkout("E, E, E, B"), DiscountPrice);
        }
    }

    @Nested
    @DisplayName("When there are multiple discount types, we favour the customer and apply them")
    class WithMultipleDiscountTypes {

        @Test
        @DisplayName("multiple discounts are applied to the same products if matched")
        public void testTotalSumWithMultibuyDiscountTypes() {
            // (2E - 1B) + 2B(seperate offer)
            // OR should the aggregate for 1 B be removed?
            Integer DiscountPrice = 95;

            assertEquals(DiscountPrice, checkout.checkout("E, E, B, B"));
        }
    }

}


