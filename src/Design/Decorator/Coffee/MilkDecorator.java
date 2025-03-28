package Design.Decorator.Coffee;

public class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Beverages beverages) {
        super(beverages);
    }

    /**
     * @return
     */
    @Override
    public double getCost() {
        return super.getCost()+5.0;
    }

    /**
     * @return
     */
    @Override
    public String getDesc() {
        return super.getDesc()+"Adding Milk";
    }
}
