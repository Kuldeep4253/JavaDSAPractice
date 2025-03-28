package Design.Decorator.Coffee;

public class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Beverages beverages) {
        super(beverages);
    }
    /**
     * @return
     */
    @Override
    public double getCost() {
        return super.getCost()+1.0;
    }

    /**
     * @return
     */
    @Override
    public String getDesc() {
        return super.getDesc()+"Adding Sugar";
    }
}
