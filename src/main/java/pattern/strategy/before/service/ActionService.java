package pattern.strategy.before.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pattern.strategy.WeaponType;

public class ActionService {
    private static final Logger LOGGER = LogManager.getLogger(ActionService.class.getName());

    private WeaponType weaponType;

    // 각 무기타입에 따른 비즈니스 로직을 달리하기위해서 Service Layer에서의 추상화를 적용
    public void attack() {
        if (weaponType == WeaponType.GUN) {
            LOGGER.info("Attack Gun!");
        } else if (weaponType == WeaponType.SWORD) {
            LOGGER.info("Attack Sword!");
        } else {
            LOGGER.info("Attack Punch!");
        }
    }

    public WeaponType getWeapon() {
        return weaponType;
    }
    public void setWeapon(WeaponType weaponType) {
        this.weaponType = weaponType;
    }
}
