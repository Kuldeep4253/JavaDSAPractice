package Design.Decorator.Coffee;

public class client {
    public static void main(String...k){

        Beverages simpleCoffee= new SimpleCoffee();

        simpleCoffee=new MilkDecorator(new SugarDecorator(new WhippedCreamDecorator(simpleCoffee)));

        System.out.println("Description: " + simpleCoffee.getDesc());
        System.out.println("Cost: $" + simpleCoffee.getCost());



    }
}
