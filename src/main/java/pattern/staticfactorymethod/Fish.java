package pattern.staticfactorymethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fish extends Food {
    public Fish() {
        super.setName(FoodType.FISH);
    }
}
