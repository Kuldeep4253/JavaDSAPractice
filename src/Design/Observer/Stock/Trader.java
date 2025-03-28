package Design.Observer.Stock;


public class Trader implements Observer {
    /**
     * @param stockSymbol
     * @param price
     */
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Traders is notified. " + stockSymbol + " price is now: $" + price);
    }
}
