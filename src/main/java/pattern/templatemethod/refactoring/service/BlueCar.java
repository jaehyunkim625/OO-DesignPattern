package pattern.templatemethod.refactoring.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BlueCar extends CarTemplate{
    private static final Logger LOGGER = LogManager.getLogger(BlueCar.class.getName());

    @Override
    protected void paintColor() {
        LOGGER.info("Paint Blue...");
    }
}
