package Design.Decorator.Communicator;

import Design.Decorator.Communicator.Communicator;

public class SlackService extends CommnunicationDecorator {

    /***
     *
     *
     * @param communicator
     * Concrete decorators - Create concrete decorator classes that extend the base decorator
     * class and add additional behavior to the wrapped object.
     */
    public SlackService(Communicator communicator) {
        super(communicator);
    }

    @Override
    public void send(String target, String message) {
        communicator.send(target, message);
        slackNotif(target,message);
    }

    private void slackNotif(String target, String message) {
        System.out.println(String.format("Slack Sending To: %s with message: %s", target, message));
    }
}
