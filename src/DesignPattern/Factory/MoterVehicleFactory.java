package DesignPattern.Factory;

public abstract class MoterVehicleFactory {

    /***
     * we create the MotorVehicleFactory class. This class is responsible for creating every new vehicle instance.
     * It’s an abstract class because it makes a
     * specific vehicle for its particular factory.
     */
    public MotorVehicle create() {
        MotorVehicle vehicle = createMotorVehicle();
        vehicle.build();
        return vehicle;
    }
    protected abstract MotorVehicle createMotorVehicle();
}
