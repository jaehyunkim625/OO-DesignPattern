package quiz.assignment2;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import quiz.assignment2.before.Member;
import quiz.assignment2.before.MemberLevel;
import quiz.assignment2.before.NotificationMethod;
import quiz.assignment2.before.service.RewardService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RewardServiceTest {

    @Test
    @DisplayName("패턴적용전 도메인 서비스 테스트")
    void saveGoldWithSlack() {
        LogCaptor logCaptor = LogCaptor.forRoot();
        //given
        quiz.assignment2.before.service.RewardService rewardService = new quiz.assignment2.before.service.RewardService();
        Member member = getSampleGoldMember();
        int point = 300;
        //when
        boolean isOnEvent = RewardService.ON_EVENT;
        member.setFavoriteNotificationMethod(NotificationMethod.SLACK);
        rewardService.save(member,point,isOnEvent);
        //then
        final List<String> expectedResult = new ArrayList<>();
        expectedResult.add("1. 맴버정보(회원등급)를 조회한다");
        expectedResult.add("Member level(Welcome/Green/Gold): GOLD");
        expectedResult.add("2. 리워드 이벤트중인지 확인한다");
        expectedResult.add("Congraturation! it's on the reward event season! You'll be get Double reward points!");
        expectedResult.add("3. 리워드포인트를 적립한다");
        expectedResult.add("Save reward points for Gold member...");
        expectedResult.add("Total saved reward points: 600 point");
        expectedResult.add("4. 리워드적립결과를 회원에게 Notify한다");
        expectedResult.add("Send saving reward point result notification via slack");
        List<String> actualResult = logCaptor.getInfoLogs();
        assertThat(actualResult).containsAll(expectedResult);
    }

    @Test
    @DisplayName("패턴적용전 도메인 서비스 테스트")
    void saveGreenWithEmail() {
        LogCaptor logCaptor = LogCaptor.forRoot();
        //given
        quiz.assignment2.before.service.RewardService rewardService = new quiz.assignment2.before.service.RewardService();
        Member member = getSampleGreenMember();
        int point = 300;
        //when
        boolean isOnEvent = RewardService.OFF_EVENT;
        member.setFavoriteNotificationMethod(NotificationMethod.EMAIL);
        rewardService.save(member,point,isOnEvent);
        //then
        final List<String> expectedResult = new ArrayList<>();
        expectedResult.add("1. 맴버정보(회원등급)를 조회한다");
        expectedResult.add("Member level(Welcome/Green/Gold): GREEN");
        expectedResult.add("2. 리워드 이벤트중인지 확인한다");
        expectedResult.add("Unfortunately, it's not on the reward event season...");
        expectedResult.add("3. 리워드포인트를 적립한다");
        expectedResult.add("Save reward points for Green member...");
        expectedResult.add("Total saved reward points: 300 point");
        expectedResult.add("4. 리워드적립결과를 회원에게 Notify한다");
        expectedResult.add("Send saving reward point result notification via e-mail");
        List<String> actualResult = logCaptor.getInfoLogs();
        assertThat(actualResult).containsAll(expectedResult);
    }
    @Test
    @DisplayName("패턴적용전 도메인 서비스 테스트")
    void saveWelcomeWithMMS() {
        LogCaptor logCaptor = LogCaptor.forRoot();
        //given
        quiz.assignment2.before.service.RewardService rewardService = new quiz.assignment2.before.service.RewardService();
        Member member = getSampleWelcomeMember();
        int point = 300;
        //when
        boolean isOnEvent = RewardService.OFF_EVENT;
//        member.setFavoriteNotificationMethod(NotificationMethod.MMS);
        rewardService.save(member,point,isOnEvent);
        //then
        final List<String> expectedResult = new ArrayList<>();
        expectedResult.add("1. 맴버정보(회원등급)를 조회한다");
        expectedResult.add("Member level(Welcome/Green/Gold): WELCOME");
        expectedResult.add("2. 리워드 이벤트중인지 확인한다");
        expectedResult.add("Unfortunately, it's not on the reward event season...");
        expectedResult.add("3. 리워드포인트를 적립한다");
        expectedResult.add("Save reward points for Welcome member...");
        expectedResult.add("Total saved reward points: 300 point");
        expectedResult.add("4. 리워드적립결과를 회원에게 Notify한다");
        expectedResult.add("Send saving reward point result notification via MMS");
        List<String> actualResult = logCaptor.getInfoLogs();
        assertThat(actualResult).containsAll(expectedResult);
    }
    @Test
    @DisplayName("패턴적용전 도메인 서비스 테스트")
    void saveWelcomeWithPostmail() {
        LogCaptor logCaptor = LogCaptor.forRoot();
        //given
        quiz.assignment2.before.service.RewardService rewardService = new quiz.assignment2.before.service.RewardService();
        Member member = getSampleWelcomeMember();
        int point = 300;
        //when
        boolean isOnEvent = RewardService.ON_EVENT;
        member.setFavoriteNotificationMethod(NotificationMethod.POST_MAIL);
        rewardService.save(member,point,isOnEvent);
        //then
        final List<String> expectedResult = new ArrayList<>();
        expectedResult.add("1. 맴버정보(회원등급)를 조회한다");
        expectedResult.add("Member level(Welcome/Green/Gold): WELCOME");
        expectedResult.add("2. 리워드 이벤트중인지 확인한다");
        expectedResult.add("Congraturation! it's on the reward event season! You'll be get Double reward points!");
        expectedResult.add("3. 리워드포인트를 적립한다");
        expectedResult.add("Save reward points for Welcome member...");
        expectedResult.add("Total saved reward points: 600 point");
        expectedResult.add("4. 리워드적립결과를 회원에게 Notify한다");
        expectedResult.add("Send saving reward point result notification via post mail");
        List<String> actualResult = logCaptor.getInfoLogs();
        assertThat(actualResult).containsAll(expectedResult);
    }

    private Member getSampleGoldMember() {
        return new Member(
                "GOLD-RABBIT",
                MemberLevel.GOLD,
                "Chris",
                "chris@starbucks.co.kr",
                "01012345678",
                "chris@slack",
                "20 Main Street, Mahattan, NY, NY11001"
        );
    }
    private Member getSampleGreenMember() {
        return new Member(
                "GREEN-RABBIT",
                MemberLevel.GREEN,
                "Rachael",
                "rachael@starbucks.co.kr",
                "0102223333",
                "rachael@slack",
                "APT100-203, Myeong-dong, Seoul, 10609"
        );
    }
    private Member getSampleWelcomeMember() {
        return new Member(
                "GOLD-RABBIT",
                MemberLevel.WELCOME,
                "John",
                "john@starbucks.co.kr",
                "0162225555",
                "john@slack",
                "somewhere"
        );
    }
}