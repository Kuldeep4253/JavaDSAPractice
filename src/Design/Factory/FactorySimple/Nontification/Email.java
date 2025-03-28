package Design.Factory.FactorySimple.Nontification;

public class Email implements Notification {
    /**
     *
     */
    @Override
    public void send() {
        System.out.println("Sending Email Notification");
    }
}
