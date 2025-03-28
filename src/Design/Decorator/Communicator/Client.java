package Design.Decorator.Communicator;

public class Client {
    public static void main(String...k) {
        Communicator com = new EmailService();
        Communicator phone = new PhoneService(com);
        Communicator slack = new SlackService(phone);
        slack.send("kuldeep", "Hello");

    }
}
