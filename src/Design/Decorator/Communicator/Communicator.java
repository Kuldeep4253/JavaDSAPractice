package Design.Decorator.Communicator;

public interface Communicator {
    /***
     *
     * @param target
     * @param message
     *
     * Common product interface - Declare the common interface for both wrappers and wrapped objects.
     */
    void send(String target,String message);
}
