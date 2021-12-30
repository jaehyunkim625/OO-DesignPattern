package pattern.strategywithfactory.factory;

import pattern.strategy.WeaponType;
import pattern.strategy.refactoring.service.DefaultAttackStrategy;
import pattern.strategy.refactoring.service.GunAttackStrategy;
import pattern.strategy.refactoring.service.SwordAttackStrategy;
import pattern.strategy.refactoring.service.AttackStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Strategy with Fatory Method Pattern의 포인트는,
 * 스트래지패턴의 단점인 스트래지 디시전 (ConcreteStrategy Class생성)을 스트래지를 사용하는 클래스 (주로, Service레이어)에서가 아닌, 그 책임을 팩토리에게 위임
 */
public class AttackStrategyFactory {
    private static final Map<WeaponType, AttackStrategy> attackStrategies = new HashMap<>();
    // 보통은 if-else or Swith로 코드별 해당 ConcreteClass를 생성하겠지만
    // 객체(ConcreteClass)가 Immutable하다면, 미리 캐시하여 Costy한 new instance를 skip
    // Singleton Pattern을 통해 미리 생성된 객체를 반환하여 오버헤드를 줄임
    static {
        attackStrategies.put(WeaponType.GUN, new GunAttackStrategy());
        attackStrategies.put(WeaponType.SWORD, new SwordAttackStrategy());
        attackStrategies.put(WeaponType.PUNCH, new DefaultAttackStrategy());
    }
    public static AttackStrategy getImmutableInstance(WeaponType weaponType) {
        // 인스턴스생성시 일련의 과정 (룰,순서등)이 존재한다면, templatemethod 패턴의 활용을 검토.
        return attackStrategies.get(weaponType);
    }

    public static AttackStrategy getInstance(WeaponType weaponType) {
        AttackStrategy strategy;
        switch (weaponType) {
            case GUN:
                strategy = new GunAttackStrategy();
                break;
            case SWORD:
                strategy = new SwordAttackStrategy();
                break;
            default:
                strategy = new DefaultAttackStrategy();
        }
        return strategy;
    }
}
