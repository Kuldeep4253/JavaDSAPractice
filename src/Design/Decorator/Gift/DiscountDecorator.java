package Design.Decorator.Gift;

public class DiscountDecorator extends GiftDecorator{
    public DiscountDecorator(Gift gift) {
        super(gift);
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
        return super.getDesc()+"Discount Applied ";
    }
}
