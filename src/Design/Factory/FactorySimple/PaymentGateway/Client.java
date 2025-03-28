package Design.Factory.FactorySimple.PaymentGateway;

public class Client {

    public static void main(String...k){

        GatewayFactory gatewayFactory=new BankGateway();
        gatewayFactory.makePayment(100);

        gatewayFactory=new CreditGateway();
        gatewayFactory.makePayment(50);

    }
}
