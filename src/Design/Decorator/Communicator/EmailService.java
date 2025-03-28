package Design.Decorator.Communicator;

import Design.Decorator.Communicator.Communicator;

public class EmailService implements Communicator {
    /**
     * @param target
     * @param message
     *
     * Concrete product - Create a concrete product class that implements the common interface
     * and represents the basic behavior of the wrapped object.
     * This is a BaseConfig Product Its need to create;
     */
    @Override
    public void send(String target, String message) {
        System.out.println(String.format("Email Sending To: %s with message: %s", target, message));
    }
}
