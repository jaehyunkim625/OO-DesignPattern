package pattern.templatemethod;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TemplateMethodPatternTest {

    @Test
    @DisplayName("패턴적용전 도메인 서비스 테스트")
    void buildCar() {
        LogCaptor logCaptor = LogCaptor.forRoot();
        //given
        CarColorType color = CarColorType.RED;
        //when
        pattern.templatemethod.before.service.BuildCarService buildCarService = new pattern.templatemethod.before.service.BuildCarService();
        buildCarService.build(color);
        //then
        final List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Body built...");
        expectedResult.add("Engine built...");
        expectedResult.add("Paint Red...");
        List<String> actualResult = logCaptor.getInfoLogs();
        assertThat(actualResult).containsExactlyElementsOf(expectedResult);
    }

    @Test
    @DisplayName("Template Method Pattern 적용 후 도메인 서비스 테스트")
    void buildCarAppliedTemplateMethodPattern() {
        LogCaptor logCaptor = LogCaptor.forRoot();
        //given
        CarColorType color = CarColorType.RED;
        //when
        pattern.templatemethod.refactoring.service.BuildCarService buildCarService = new pattern.templatemethod.refactoring.service.BuildCarService(color);
        buildCarService.build();
        //then
        final List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Body built...");
        expectedResult.add("Engine built...");
        expectedResult.add("Paint Red...");
        List<String> actualResult = logCaptor.getInfoLogs();
        assertThat(actualResult).containsExactlyElementsOf(expectedResult);
    }

    @Test
    @DisplayName("Template Method + Factory Pattern 적용 후 도메인 서비스 테스트")
    void buildCarAppliedTemplateMethodWithFactoryPattern() {
        LogCaptor logCaptor = LogCaptor.forRoot();
        //given
        CarColorType color = CarColorType.RED;
        //when
        pattern.templatemethodwithfactory.service.BuildCarService buildCarService = new pattern.templatemethodwithfactory.service.BuildCarService(color);
        buildCarService.build();
        //then
        final List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Body built...");
        expectedResult.add("Engine built...");
        expectedResult.add("Paint Red...");
        List<String> actualResult = logCaptor.getInfoLogs();
        assertThat(actualResult).containsExactlyElementsOf(expectedResult);
    }
}