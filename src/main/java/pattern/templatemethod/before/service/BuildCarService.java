package pattern.templatemethod.before.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pattern.templatemethod.CarColorType;

public class BuildCarService {
    private static final Logger LOGGER = LogManager.getLogger(BuildCarService.class.getName());

    public void build(CarColorType color) {
        // 1. Build body
        LOGGER.info("Body built...");
        // 2. Build engine
        LOGGER.info("Engine built...");
        // 3. Paint body
        switch (color) {
            case BLUE:
                LOGGER.info("Paint Blue...");
                break;
            case RED:
                LOGGER.info("Paint Red...");
                break;
            case WHITE:
                LOGGER.info("Paint White...");
                break;
            case BLACK:
                LOGGER.info("Paint Black...");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + color);
        }
    }
}
