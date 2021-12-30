package pattern.strategy.refactoring.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// ConcreteStrategy
public class DefaultAttackStrategy implements AttackStrategy {
    private static final Logger LOGGER = LogManager.getLogger(DefaultAttackStrategy.class.getName());

    @Override
    public void attack() {
        LOGGER.info("Attack Punch!");
    }
}
