package Design.Factory.FactorySimple.PaymentGateway;

public class PayPal implements Payment {

    /**
     *
     */
    @Override
    public void processPayment(double amount) {
        System.out.println("PayPal Processing"+amount);
    }
}
