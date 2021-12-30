package pattern.strategywithfactory.service;

import pattern.strategy.WeaponType;
import pattern.strategy.refactoring.service.AttackStrategy;
import pattern.strategy.refactoring.service.DefaultAttackStrategy;
import pattern.strategy.refactoring.service.GunAttackStrategy;
import pattern.strategy.refactoring.service.SwordAttackStrategy;
import pattern.strategywithfactory.factory.AttackStrategyFactory;

// Context
public class ActionService {

    // Context have a Strategy
    private AttackStrategy attackStrategy = new DefaultAttackStrategy();

    // Set Strategy
    // Delegating instance (StrategyConcreteClass) creation part to the Factory
    // 인터페이스의 구현체를 선택하는 책임은 Factory 클래스에만 있기때문에 공격방식의 확장에도 ActionService 코드는 변하지 않는다
    // 즉, 팩토리를 통해 책임을 분리함으로써, 로직의 확장에는 열려있고 코드의 변경에는 닫혀있는 개방-폐쇄 원칙(OCP : Open-Closed Principal)을 잘 지키게 됨
    public void setWeapon(WeaponType weaponType) {
        this.attackStrategy = AttackStrategyFactory.getInstance(weaponType);
    }

    // Delegate behavior
    public void attack() {
        attackStrategy.attack();
    }

    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }
}
