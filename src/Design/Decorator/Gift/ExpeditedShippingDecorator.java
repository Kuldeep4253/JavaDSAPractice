package Design.Decorator.Gift;

public class ExpeditedShippingDecorator extends GiftDecorator {
    public ExpeditedShippingDecorator(Gift gift) {
        super(gift);
    }

    /**
     * @return
     */
    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }

    /**
     * @return
     */
    @Override
    public String getDesc() {
        return super.getDesc() + " Shipping Added ";
    }
}
