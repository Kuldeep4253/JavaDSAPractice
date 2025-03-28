package Design.Factory.FactorySimple.PaymentGateway;

public class Bank implements Payment {

    @Override
    public void processPayment(double amount) {
        System.out.println("Bank Processing"+amount);
    }
}
