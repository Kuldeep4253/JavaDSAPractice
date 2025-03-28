package Design.Factory.FactorySimple.Nontification;

public class PushNotification implements Notification{
    /**
     *
     */
    @Override
    public void send() {
        System.out.println("Sending Push Notification");
    }
}
