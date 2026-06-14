package parkingLotSystem;

abstract public class Vehicle {
    //All vehicles have these
    String licensePlate;
    VehicleType type;

    //abstract method
    abstract SpotType getRequiredSpotType();

    //getter, constructor here??
}
