package Design.Factory.FactorySimple.Nontification;

public class EmailNotification implements Notification{

    /**
     *
     */
    @Override
    public void send() {
        System.out.println("Sending Email Notification");

    }
}
