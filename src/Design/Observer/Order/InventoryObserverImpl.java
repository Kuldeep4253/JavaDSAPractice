package Design.Observer.Order;


public class InventoryObserverImpl implements Observer {

    /**
     * @param order
     */
    @Override
    public void update(Order order) {
        System.out.println("Inventory updated based on order: " + order.getOrderDetails());
    }
}
