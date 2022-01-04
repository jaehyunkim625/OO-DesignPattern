package pattern.staticfactorymethod.refactoring.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pattern.staticfactorymethod.*;

import java.util.EnumMap;

public class FoodFactory {
    private static final Logger LOGGER = LogManager.getLogger(FoodFactory.class.getName());
    private static final EnumMap<FoodType, Food> foods = new EnumMap<>(FoodType.class);

    private FoodFactory() {}

    // 보통은 if-else or Swith로 코드별 해당 ConcreteClass를 생성하겠지만
    // 객체(ConcreteClass)가 Immutable하다면, 미리 캐시하여 Costy한 new instance를 skip
    // Singleton Pattern을 통해 미리 생성된 객체를 반환하여 오버헤드를 줄임
    static {
        foods.put(FoodType.MEAT, new Meat());
        foods.put(FoodType.FISH, new Fish());
        foods.put(FoodType.VEGETABLE, new Vegetable());
    }

    public static Food getInstance(FoodType foodType) {
        // 인스턴스생성시 일련의 과정 (룰,순서등)이 존재한다면, templatemethod 패턴의 활용을 검토.
        return foods.get(foodType);
    }

    public static Food newInstance(FoodType foodType) {
        // 인스턴스생성시 일련의 과정의 알고리즘 (프로세스 플로우)이 존재한다면, templatemethod 패턴의 활용을 검토.
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
        LOGGER.info("{} has been created...", food.getName());
        return food;
    }
}
