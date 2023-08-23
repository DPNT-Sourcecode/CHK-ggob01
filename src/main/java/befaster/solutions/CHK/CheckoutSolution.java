package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

public class CheckoutSolution {

    static Logger logger = Logger.getLogger(CheckoutSolution.class.getName());
    private HashMap<String, SkuPricing> priceList =
    public Integer checkout(String skus) {
        return -1;
    }

    private HashMap<String, SkuPricing> buildPriceList() {
        try {
            Object parsed = new JSONParser().parse(new FileReader("./skusRaw.json"));
        } catch (IOException | ParseException e) {
            logger.log(logger);
        }
    }
}




