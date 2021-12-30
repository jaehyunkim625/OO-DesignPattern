package pattern.templatemethod.refactoring.service;

import pattern.templatemethod.CarColorType;

// domain service
public class BuildCarService {
    private final CarTemplate template;
    // problem: code is still coupled to Bluecar, RedCar classes.
    public BuildCarService(CarColorType color) {
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
    }

    public void build() {
        template.buildCar();
    }
}
