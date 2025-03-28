package Design.Observer.Order;

import Design.Observer.Order.Order;

public class SellerObserverImpl implements Observer {
    /**
     * @param order
     */
    @Override
    public void update(Order order) {
        System.out.println("Seller notified about order: " + order.getOrderDetails());

    }
}
