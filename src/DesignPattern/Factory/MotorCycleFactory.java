package DesignPattern.Factory;

public class MotorCycleFactory extends MoterVehicleFactory{
    /**
     * @return
     */
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Motorcycle();
    }
}
