package quiz.assignment2.before.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import quiz.assignment2.before.Member;
import quiz.assignment2.before.MemberLevel;
import quiz.assignment2.before.NotificationMethod;

public class RewardService {
    private static final Logger LOGGER = LogManager.getLogger(RewardService.class.getName());
    private static final int DOUBLE = 2;
    public static final boolean OFF_EVENT = false;
    public static final boolean ON_EVENT = true;

    // Business logics are represented as just logging in this practice scenario
    public void save(Member member, int rewardPoint, boolean onEvent) {
        LOGGER.debug("[START] Saving reward point...");

        MemberLevel memberLevel = member.getMemberLevel();
        NotificationMethod favoriteNotificationMethod = member.getNotificationMethod();

        // 1. 회원등급을 조회한다
        LOGGER.info("1. 맴버정보(회원등급)를 조회한다");
        LOGGER.info("Member level(Welcome/Green/Gold): {}", memberLevel);
        LOGGER.debug(member);

        // 2. 리워드 이벤트중인지 확인한다
        LOGGER.info("2. 리워드 이벤트중인지 확인한다");
        if (onEvent) {
            LOGGER.info("Congraturation! it's on the reward event season! You'll be get Double reward points!");
            if (rewardPoint > 0) {
                rewardPoint = rewardPoint * DOUBLE;
            }
        } else {
            LOGGER.info("Unfortunately, it's not on the reward event season...");
        }

        // 3. 리워드를 적립한다
        LOGGER.info("3. 리워드포인트를 적립한다");
        switch (memberLevel) {
            case WELCOME:
                LOGGER.info("Save reward points for Welcome member...");
                LOGGER.debug("processing w...");
                LOGGER.debug("processing e...");
                LOGGER.debug("processing l...");
                LOGGER.debug("processing c...");
                LOGGER.debug("processing o...");
                LOGGER.debug("processing m...");
                LOGGER.debug("processing e...");
                break;
            case GREEN:
                LOGGER.info("Save reward points for Green member...");
                LOGGER.debug("processing g...");
                LOGGER.debug("processing r...");
                LOGGER.debug("processing e...");
                LOGGER.debug("processing e...");
                LOGGER.debug("processing n...");
                break;
            case GOLD:
                LOGGER.info("Save reward points for Gold member...");
                LOGGER.debug("processing g...");
                LOGGER.debug("processing o...");
                LOGGER.debug("processing l...");
                LOGGER.debug("processing d...");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + memberLevel);
        }
        LOGGER.info("Total saved reward points: {} point", rewardPoint);

        // 4. 리워드적립결과를 회원에게 Notify한다
        LOGGER.info("4. 리워드적립결과를 회원에게 Notify한다");
        LOGGER.debug("Member's favorite notification method: {}", favoriteNotificationMethod);
        if (favoriteNotificationMethod.equals(NotificationMethod.MMS)) {
            LOGGER.info("Send saving reward point result notification via MMS");
            LOGGER.debug("Phone number: {}", member.getPhoneNumber());
            LOGGER.debug("Connect SMS server...");
            LOGGER.debug("Set mms message...");
            LOGGER.debug("Send MMS...");
        } else if (favoriteNotificationMethod.equals(NotificationMethod.EMAIL)) {
            LOGGER.info("Send saving reward point result notification via e-mail");
            LOGGER.debug("E-mail address: {}", member.getEmailAddress());
            LOGGER.debug("Connect SMTP server...");
            LOGGER.debug("Set e-mail contents...");
            LOGGER.debug("Send e-mail...");
        } else if (favoriteNotificationMethod.equals(NotificationMethod.POST_MAIL)) {
            LOGGER.info("Send saving reward point result notification via post mail");
            LOGGER.debug("Home address: {}", member.getHomeAddress());
            LOGGER.debug("Set mail contents...");
            LOGGER.debug("Register sending mail request...");
        } else if (favoriteNotificationMethod.equals(NotificationMethod.SLACK)) {
            LOGGER.info("Send saving reward point result notification via slack");
            LOGGER.debug("Slack ID: {}", member.getSlackId());
            LOGGER.debug("Set slack webhook endpoint url...");
            LOGGER.debug("Set slack message...");
            LOGGER.debug("Send rest http request...");
        } else {
            throw new IllegalStateException("Unexpected value: " + favoriteNotificationMethod);
        }

        LOGGER.debug("[END] Saving reward point...");
    }
}
