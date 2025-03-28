package Design.Decorator.Coffee;


/***
 *
 * Beverage have some common feature I want to make coffee and as base product is will be simplecoffee and
 * on the base product user can add additional decorator like caramel,milk,mango,latte,cappucino
 */

public interface Beverages {
    double getCost();
    String getDesc() ;
}
