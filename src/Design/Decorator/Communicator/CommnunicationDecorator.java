package Design.Decorator.Communicator;

public abstract class CommnunicationDecorator implements Communicator {
    /**
     * Constructs a new object.
     */

    protected Communicator communicator;
    public CommnunicationDecorator(Communicator communicator) {
        this.communicator=communicator;
    }

    public CommnunicationDecorator() {
    }

    /**
     * @param target
     * @param message
     *
     * Base decorator - Create a base decorator class that implements the common interface and
     * contains a field for storing a reference to a wrapped object.
     */
    @Override
    public void send(String target, String message) {
        communicator.send(target,message);
    }
}
