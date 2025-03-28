package Design.Decorator.Gift;

public class GiftDecorator implements Gift{
    private Gift gift;

    public GiftDecorator(Gift gift) {
        this.gift = gift;
    }

    /**
     * @param amount
     * @return
     */
    @Override
    public double getCost() {
        return gift.getCost();
    }

    /**
     * @return
     */
    @Override
    public String getDesc() {
        return gift.getDesc();
    }
}
