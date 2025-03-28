package Design.Observer.Stock;


/***
 * Scenario:
 * Stock: Represents a specific stock in the market (e.g., Tesla, Apple, etc.).
 * Investors: Investors who are interested in specific stocks and want to be notified when the price changes.
 * Stock Traders: Traders who want to execute buy/sell orders when the price of stocks crosses a certain threshold.
 * News Outlets: Media or news platforms that want to broadcast the stock price change.
 */
public interface Observer {

    void update(String stockSymbol, double price);
}
