package parkingLotSystem;

public class Truck extends Vehicle{
    @Override
    public SpotType getRequiredSpotType() {
        return SpotType.LARGE;
    }
}
