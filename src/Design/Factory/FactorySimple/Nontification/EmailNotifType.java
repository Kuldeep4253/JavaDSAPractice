package Design.Factory.FactorySimple.Nontification;

public class EmailNotifType extends NotificationTypeFactory{
    /**
     * @return
     */
    @Override
    public Notification sendNotification() {
        return new EmailNotification();
    }
}
