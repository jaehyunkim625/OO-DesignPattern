package quiz.assignment2.before;

public class Member {
    private final String memberId;
    private final MemberLevel memberLevel;
    private final String name;
    private final String emailAddress;
    private final String phoneNumber;
    private final String slackId;
    private final String homeAddress;
    private NotificationMethod notificationMethod = NotificationMethod.MMS;

    public Member(String memberId, MemberLevel memberLevel, String name, String emailAddress, String phoneNumber, String slackId, String homeAddress) {
        this.memberId = memberId;
        this.memberLevel = memberLevel;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.slackId = slackId;
        this.homeAddress = homeAddress;
    }

    public void setFavoriteNotificationMethod(NotificationMethod notificationMethod) {
        this.notificationMethod = notificationMethod;
    }

    public String getMemberId() {
        return memberId;
    }
    public MemberLevel getMemberLevel() {
        return memberLevel;
    }
    public String getName() {
        return name;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getSlackId() {
        return slackId;
    }
    public String getHomeAddress() {
        return homeAddress;
    }
    public NotificationMethod getNotificationMethod() {
        return notificationMethod;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberLevel=" + memberLevel +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", slackId='" + slackId + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", notificationMethod='" + notificationMethod + '\'' +
                '}';
    }
}
