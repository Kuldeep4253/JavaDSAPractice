package Design.Factory.FactorySimple.Nontification;

public class SMSNotifType extends NotificationTypeFactory{
    /**
     * @return
     */
    @Override
    public Notification sendNotification() {
        return new SMSNotification();
    }
}
