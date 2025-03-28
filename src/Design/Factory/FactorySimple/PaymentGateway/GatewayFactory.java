package Design.Factory.FactorySimple.PaymentGateway;

public abstract class GatewayFactory {

    public abstract Payment createPayment();

    public void makePayment(double amount){
        Payment payment=createPayment();
        payment.processPayment(amount);
    }
}
