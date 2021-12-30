package pattern.templatemethod.refactoring.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RedCar extends CarTemplate{
    private static final Logger LOGGER = LogManager.getLogger(RedCar.class.getName());

    @Override
    protected void paintColor() {
        LOGGER.info("Paint Red...");
    }
}
