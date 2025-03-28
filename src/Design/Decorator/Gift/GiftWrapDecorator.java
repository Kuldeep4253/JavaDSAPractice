package Design.Decorator.Gift;

public class GiftWrapDecorator extends GiftDecorator{
    public GiftWrapDecorator(Gift gift) {
        super(gift);
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
        return super.getDesc()+"Gift Wrap ";
    }
}
