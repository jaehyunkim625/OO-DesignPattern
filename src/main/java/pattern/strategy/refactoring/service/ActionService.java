package pattern.strategy.refactoring.service;

import pattern.strategy.WeaponType;

// Context
public class ActionService {

    // Context have a Strategy
    private AttackStrategy attackStrategy = new DefaultAttackStrategy();

    // Set Strategy
    public void setWeapon(WeaponType weaponType) {
        switch (weaponType) {
            case GUN:
                this.attackStrategy = new GunAttackStrategy();
                break;
            case SWORD:
                this.attackStrategy = new SwordAttackStrategy();
                break;
            default:
                this.attackStrategy = new DefaultAttackStrategy();
        }
    }

    // Delegate behavior
    public void attack() {
        attackStrategy.attack();
    }

    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }
}
