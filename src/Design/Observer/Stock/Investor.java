package Design.Observer.Stock;

public class Investor implements Observer{
    /**
     * @param stockSymbol
     * @param price
     */
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Investor is notified. " + stockSymbol + " price is now: $" + price);
    }
}
