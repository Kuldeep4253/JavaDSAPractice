package Design.Factory.FactorySimple.Nontification;

public abstract class NotificationTypeFactory {

    public abstract Notification sendNotification();

    public void createNotifType(){
        Notification notification=sendNotification();
        notification.send();
    }
}
