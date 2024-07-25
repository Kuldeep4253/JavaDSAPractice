package DesignPattern.Factory;

public class Car implements MotorVehicle {
    /***
     * we define the MotorVehicle interface.
     * This interface only has a method build(). This method is used to build a specific motor vehicle
     */
    @Override
    public void build() {
        System.out.println("Build Car");
    }
}
