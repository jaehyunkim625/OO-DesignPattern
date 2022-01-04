package pattern.templatemethodwithfactory.factory;

import pattern.templatemethod.CarColorType;
import pattern.templatemethod.refactoring.service.BlueCar;
import pattern.templatemethod.refactoring.service.CarTemplate;
import pattern.templatemethod.refactoring.service.RedCar;

import java.util.EnumMap;

public class CarTemplateFactory {

    private static final EnumMap<CarColorType, CarTemplate> carTemplates = new EnumMap<>(CarColorType.class);

    private CarTemplateFactory() {}

    // 보통은 if-else or Swith로 코드별 해당 ConcreteClass를 생성하겠지만
    // 객체(ConcreteClass)가 Immutable하다면, 미리 캐시하여 Costy한 new instance를 skip
    static {
        carTemplates.put(CarColorType.BLUE, new BlueCar());
        carTemplates.put(CarColorType.RED, new RedCar());
    }
    public static CarTemplate getInstance(CarColorType color) {
        return carTemplates.get(color);
    }

    public static CarTemplate newInstance(CarColorType color) {
        CarTemplate template;
        switch (color) {
            case BLUE:
                template = new BlueCar();
                break;
            case RED:
                template = new RedCar();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + color);
        }
        return template;
    }
}
