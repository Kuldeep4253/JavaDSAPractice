package Design.Observer.Order;

public class Client {
    public static void main(String...k){
        Order order=new Order();

        InventoryObserverImpl inventoryObserver=new InventoryObserverImpl();
        BillingObserverImpl billingObserver=new BillingObserverImpl();
        SellerObserverImpl sellerObserver=new SellerObserverImpl();

        order.addObserver(inventoryObserver);
        order.addObserver(billingObserver);
        order.addObserver(sellerObserver);

        order.setOrderDetails("Product A - Quantity: 1, Price: $100");
    }
}
