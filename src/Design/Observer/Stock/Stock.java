package Design.Observer.Stock;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject{


    private List<Observer> observerList=new ArrayList<>();
    private double price;
    private String StockSymbol;


    public Stock(double price, String stockSymbol) {
        this.price = price;
        StockSymbol = stockSymbol;
    }
    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    /**
     *
     */
    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observerList);
    }

    /**
     *
     */
    @Override
    public void notifyObserver() {
        for (Observer observer:observerList
             ) {
            observer.update(StockSymbol,price);
        }
    }

    public void priceChange(String stockSymbol,double price){
        this.price=price;
        this.StockSymbol=stockSymbol;
        notifyObserver();
    }

    public double getPrice() {
        return price;
    }


    public String getStockSymbol() {
        return StockSymbol;
    }
}
