package pattern.staticfactorymethod.before.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pattern.staticfactorymethod.*;

public class FoodService {
    private static final Logger LOGGER = LogManager.getLogger(FoodService.class.getName());

    public Food getFood(FoodType foodType) {
        Food food;
        switch (foodType) {
            case MEAT:
                food = new Meat();
                break;
            case FISH:
                food = new Fish();
                break;
            case VEGETABLE:
                food = new Vegetable();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + foodType);
        }
        LOGGER.info(food.getName() + " has been created...");
        return food;
    }
}
