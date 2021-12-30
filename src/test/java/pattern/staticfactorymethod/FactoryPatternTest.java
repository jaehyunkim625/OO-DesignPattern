package pattern.staticfactorymethod;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FactoryPatternTest {

    @Test
    @DisplayName("패턴적용전 도메인 서비스 테스트")
    void getFood() {
        //given
        FoodType foodType = FoodType.VEGETABLE;
        //when
        pattern.staticfactorymethod.before.service.FoodService foodService = new pattern.staticfactorymethod.before.service.FoodService();
        Food actualFood = foodService.getFood(foodType);
        //then
        assertThat(actualFood).isExactlyInstanceOf(Vegetable.class);
    }

    @Test
    @DisplayName("Factory Pattern 적용 후 도메인 서비스 테스트")
    void getFoodAppliedFactoryPattern() {
        //given
        FoodType foodType = FoodType.VEGETABLE;
        //when
        pattern.staticfactorymethod.refactoring.service.FoodService foodService = new pattern.staticfactorymethod.refactoring.service.FoodService();
        Food actualFood = foodService.getFood(foodType);
        //then
        assertThat(actualFood).isExactlyInstanceOf(Vegetable.class);
    }
}
