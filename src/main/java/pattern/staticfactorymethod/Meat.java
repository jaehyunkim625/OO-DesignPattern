package pattern.staticfactorymethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Meat extends Food {
    public Meat() {
        super.setName(FoodType.MEAT);
    }
}
