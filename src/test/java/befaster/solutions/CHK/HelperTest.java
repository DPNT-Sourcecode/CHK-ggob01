package befaster.solutions.CHK;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class HelperTest {

    @Test
    @DisplayName("raw json is converted to a structured sku -> SkuPricing map")
    public void testStructuredPriceList() {
        assertAll("assert correct",
            () -> assertTrue(Helper.buildPriceList().containsKey("A")),
            () -> assertEquals(Helper.buildPriceList().get("A").getPrice(), 50)
        );
    }

}
