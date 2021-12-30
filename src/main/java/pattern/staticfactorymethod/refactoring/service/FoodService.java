package pattern.staticfactorymethod.refactoring.service;

import pattern.staticfactorymethod.*;

public class FoodService {

    public Food getFood(FoodType foodType) {
        return FoodFactory.getInstance(foodType);
    }
}
