package Design.Observer.Order;

public class BillingObserverImpl implements Observer {
    /**
     * @param order
     */
    @Override
    public void update(Order order) {
        System.out.println("Billing system generating bill for order: " + order.getOrderDetails());
    }
}
