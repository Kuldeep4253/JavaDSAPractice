package Design.Decorator.Coffee;

public class SimpleCoffee implements Beverages{

    /**
     * @return
     */
    @Override
    public double getCost() {
        return 10.0;
    }

    /**
     * @return
     */
    @Override
    public String getDesc() {
        return "Simple Coffee";
    }
}
