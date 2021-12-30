package pattern.templatemethod.refactoring.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class CarTemplate {

    private static final Logger LOGGER = LogManager.getLogger(CarTemplate.class.getName());
    public final void buildCar() {
        buildBody();
        buildEngine();
        paintColor();
    }
    private void buildBody() {
        LOGGER.info("Body built...");
    }
    private void buildEngine() {
        LOGGER.info("Engine built...");
    }
    protected abstract void paintColor();
}
