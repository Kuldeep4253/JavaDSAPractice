package Design.Decorator.Gift;


/***
 * An e-commerce website has a product that can have additional features applied, such as discounts, gift wrapping,
 * and expedited shipping.Each of these features should be able to be added independently,
 * and they may be combined in various ways.
 *The basic product that is sold without any additional features.
 *GiftWrapDecorator ,ExpeditedShippingDecorator ,DiscountDecorator
 *
 *
 */
public interface Gift {
    double getCost();

    String getDesc();
}
