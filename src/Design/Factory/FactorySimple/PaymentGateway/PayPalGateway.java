package Design.Factory.FactorySimple.PaymentGateway;

public class PayPalGateway extends GatewayFactory {

    /**
     * @return
     */
    @Override
    public Payment createPayment() {
        return new PayPal();
    }
}
