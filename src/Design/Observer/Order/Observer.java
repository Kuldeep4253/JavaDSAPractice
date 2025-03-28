package Design.Observer.Order;


/***
 * Subject: The object that is being observed and notifies its observers about state changes.
 * Observer: The objects that wish to be notified when the subject changes.
 * ConcreteSubject: A specific implementation of the Subject, which keeps track of the state and notifies its observers.
 * ConcreteObserver: A specific implementation of the Observer, which updates its state based on the subject's state.
 *Scenario Overview:
 *
 *
 *
 * Order (Subject): Represents a new order placed by a customer.
 * Inventory (Observer): Keeps track of stock levels and updates the inventory when an order is placed.
 * Seller (Observer): Notified about the order to process and fulfill the request.
 * Billing (Observer): Notified to generate and process the bill when an order is placed.
 * In this scenario, when an order is placed, all relevant parties (Inventory, Seller, Billing)
 * should be notified, and they will each take appropriate actions based on the order.
 */
public interface Observer {
    void update(Order order);

}
