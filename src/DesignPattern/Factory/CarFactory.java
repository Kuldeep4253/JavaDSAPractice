package DesignPattern.Factory;

public class CarFactory extends MoterVehicleFactory {

    /**
     * @return
     */
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Car();
    }
}
