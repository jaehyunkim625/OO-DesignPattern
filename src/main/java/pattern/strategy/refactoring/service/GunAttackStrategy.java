package pattern.strategy.refactoring.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// ConcreteStrategy
public class GunAttackStrategy implements AttackStrategy {
    private static final Logger LOGGER = LogManager.getLogger(GunAttackStrategy.class.getName());

    @Override
    public void attack() {
        LOGGER.info("Attack Gun!");
    }
}
