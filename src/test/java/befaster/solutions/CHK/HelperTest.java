package befaster.solutions.CHK;

import org.json.simple.parser.ParseException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HelperTest {

    @Test
    @DisplayName("raw json is converted to a structured sku -> SkuPricing map")
    public void testJsontoStructuredPriceList() {
        assertAll("non-failing parse",
            () -> assertDoesNotThrow(Helper::buildPriceList),
            () -> assertTrue(Helper.buildPriceList().containsKey("A")),
            () -> assertEquals(Helper.buildPriceList().get("A").getPrice(), 50)
        );
    }

}
