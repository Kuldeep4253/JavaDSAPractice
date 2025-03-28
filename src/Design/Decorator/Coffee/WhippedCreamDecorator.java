package Design.Decorator.Coffee;

public class WhippedCreamDecorator extends CoffeeDecorator{
    public WhippedCreamDecorator(Beverages beverages) {
        super(beverages);
    }

    /**
     * @return
     */
    @Override
    public double getCost() {
        return super.getCost()+2.0;
    }

    /**
     * @return
     */
    @Override
    public String getDesc() {
        return super.getDesc()+"Whipped Cream Added..";
    }
}
