package Design.Observer.Stock;

public class Client {
    public static void main(String...k){
        Stock stock=new Stock(100,"Apple");

        // Create observer List
        Investor investor=new Investor();
        Trader trader=new Trader();
        News news=new News();

        // Add Observer into with subject
        stock.addObserver(investor);
        stock.addObserver(trader);
        stock.addObserver(news);

        stock.priceChange("Apple",200);
    }
}

