package Design.Factory.FactorySimple.PaymentGateway;

public class CreditGateway extends GatewayFactory {

    /**
     * @return
     */
    @Override
    public Payment createPayment() {
        return new CreditCard();
    }
}
