package Design.Observer.Order;

import java.util.ArrayList;
import java.util.List;

public class Order implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String orderDetails;

    /**
     * @param observer
     * Add Observer to Observe by subject
     */
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * @param observer
     * Remove Observer to Observe Subject
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Sending Notification if any state change
     */
    @Override
    public void notifyObserver() {
        for (Observer ob:observers
             ) {
            ob.update(this);
        }
    }
    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
        notifyObserver(); // Notify observers whenever the order details change
    }
    public String getOrderDetails() {
        return orderDetails;
    }
}
