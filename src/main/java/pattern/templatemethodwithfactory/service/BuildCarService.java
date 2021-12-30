package pattern.templatemethodwithfactory.service;

import pattern.templatemethod.CarColorType;
import pattern.templatemethod.refactoring.service.CarTemplate;
import pattern.templatemethodwithfactory.factory.CarTemplateFactory;

// domain service
public class BuildCarService {
    private final CarTemplate template;

    // Delegating instance (ConcreteClass) creation part to the Factory
    // 추상화 클래스의 구현체를 선택하는 책임은 Factory 클래스에만 있기때문에 동일한 흐름의 프로세스를 가진 요건이 추가되어도 BuildCarService 코드는 변하지 않는다
    // 즉, 팩토리를 통해 책임을 분리함으로써, 로직의 확장에는 열려있고 코드의 변경에는 닫혀있는 개방-폐쇄 원칙(OCP : Open-Closed Principal)을 잘 지키게 됨
    public BuildCarService(CarColorType color) {
        template = CarTemplateFactory.getInstance(color);
    }

    public void build() {
        template.buildCar();
    }
}
