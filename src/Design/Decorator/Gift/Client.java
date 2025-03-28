package Design.Decorator.Gift;

public class Client {
    public static void main(String...k){

        Gift gi= new GiftWrapDecorator(new DiscountDecorator(new ExpeditedShippingDecorator(new soldProduct())));
        System.out.println("Description: " + gi.getDesc());
        System.out.println("Cost: $" + gi.getCost());

    }
}
