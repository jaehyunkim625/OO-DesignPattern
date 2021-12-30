package pattern.strategy;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StrategyPatternTest {

    @Test
    @DisplayName("패턴적용전 도메인 서비스 테스트")
    void attack() {
        LogCaptor logCaptor = LogCaptor.forRoot();
        //given
        WeaponType weapon = WeaponType.GUN;
        //when
        pattern.strategy.before.service.ActionService attackService = new pattern.strategy.before.service.ActionService();
        attackService.setWeapon(weapon);
        attackService.attack();
        //then
        final List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Attack Gun!");
        List<String> actualResult = logCaptor.getInfoLogs();
        assertThat(actualResult).containsAll(expectedResult);
    }

    @Test
    @DisplayName("Strategy Pattern 적용 후 도메인 서비스 테스트")
    void attackAppliedStrategyPattern() {
        LogCaptor logCaptor = LogCaptor.forRoot();
        //given
        WeaponType weapon = WeaponType.GUN;
        //when
        pattern.strategy.refactoring.service.ActionService attackService = new pattern.strategy.refactoring.service.ActionService();
        attackService.setWeapon(weapon);
        attackService.attack();
        //then
        final List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Attack Gun!");
        List<String> actualResult = logCaptor.getInfoLogs();
        assertThat(actualResult).containsAll(expectedResult);
    }

    @Test
    @DisplayName("Strategy + Factory Pattern 적용 후 도메인 서비스 테스트")
    void attackAppliedStrategyWithFactoryPattern() {
        LogCaptor logCaptor = LogCaptor.forRoot();
        //given
        WeaponType weapon = WeaponType.GUN;
        //when
        pattern.strategywithfactory.service.ActionService attackService = new pattern.strategywithfactory.service.ActionService();
        attackService.setWeapon(weapon);
        attackService.attack();
        //then
        final List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Attack Gun!");
        List<String> actualResult = logCaptor.getInfoLogs();
        assertThat(actualResult).containsAll(expectedResult);
    }
}
