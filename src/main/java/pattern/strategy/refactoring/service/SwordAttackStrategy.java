package pattern.strategy.refactoring.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// ConcreteStrategy
public class SwordAttackStrategy implements AttackStrategy {
    private static final Logger LOGGER = LogManager.getLogger(SwordAttackStrategy.class.getName());

    @Override
    public void attack() {
        LOGGER.info("Attack Sword!");
    }
}
