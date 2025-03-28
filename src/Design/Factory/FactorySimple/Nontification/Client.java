package Design.Factory.FactorySimple.Nontification;

public class Client {
    public static void main(String...k){
        NotificationTypeFactory notificationTypeFactory=new SMSNotifType();
        notificationTypeFactory.createNotifType();
        notificationTypeFactory=new EmailNotifType();
        notificationTypeFactory.createNotifType();


    }
}
