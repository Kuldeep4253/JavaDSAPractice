package Design.Observer.Stock;

public class News implements Observer{
    /**
     * @param stockSymbol
     * @param price
     */
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("News  broadcasts: " + stockSymbol + " stock is now at: $" + price);
    }
}
