package Design.Factory.FactorySimple.PaymentGateway;

public class BankGateway extends GatewayFactory {

    /**
     * @return
     */
    @Override
    public Payment createPayment() {
        return new Bank();
    }
}
