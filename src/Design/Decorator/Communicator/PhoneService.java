package Design.Decorator.Communicator;

import Design.Decorator.Communicator.Communicator;

public class PhoneService extends CommnunicationDecorator {
    public PhoneService(Communicator communicator) {
        super(communicator);
    }

    /**
     * @param target
     * @param message
     *
     * Concrete decorators - Create concrete decorator classes that extend the base decorator
     * class and add additional behavior to the wrapped object.
     */
    @Override
    public void send(String target, String message) {
        communicator.send(target, message);
        phoneNotifSend(target,message);
    }

    private void phoneNotifSend(String target, String message) {
        System.out.println(String.format("Phone Sending To: %s with message: %s", target, message));
    }
}
