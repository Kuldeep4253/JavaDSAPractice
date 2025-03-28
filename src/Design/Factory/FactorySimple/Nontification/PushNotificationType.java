package Design.Factory.FactorySimple.Nontification;

public class PushNotificationType extends NotificationTypeFactory{

    /**
     * @return
     */
    @Override
    public Notification sendNotification() {
        return new PushNotification();
    }
}
