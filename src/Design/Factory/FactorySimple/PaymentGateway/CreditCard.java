package Design.Factory.FactorySimple.PaymentGateway;

public class CreditCard implements Payment {

    @Override
    public void processPayment(double amount) {
        System.out.println("CreditCard Processing"+amount);
    }
}
