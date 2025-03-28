package Design.Decorator.Gift;

public class soldProduct implements Gift{

    /**
     * @return
     */
    @Override
    public double getCost() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public String getDesc() {
        return "Product Sold ";
    }
}
