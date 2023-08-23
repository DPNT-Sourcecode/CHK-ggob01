package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckoutSolution {

    static Logger logger = Logger.getLogger(CheckoutSolution.class.getName());
    private HashMap<String, SkuPricing> priceList = Helper.buildPriceList();
    public Integer checkout(String skus) {
        Integer totalPrice = 0;
        for (String sku : skus.split(", ")) {
            if (!priceList.containsKey(sku)) {
                return -1;
            }
            totalPrice += priceList.get(sku).getPrice();
        }
        return totalPrice;
    }
}





