package Design.Decorator.Coffee;

public abstract class CoffeeDecorator implements Beverages{

    private Beverages beverages;

    public CoffeeDecorator(Beverages beverages) {
        this.beverages = beverages;
    }

    /**
     * @return
     */
    @Override
    public double getCost() {
        return beverages.getCost();
    }

    /**
     * @return
     */
    @Override
    public String getDesc() {
        return beverages.getDesc();
    }
}
