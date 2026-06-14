package parkingLotSystem;

public class Bike extends Vehicle{
    @Override
    public SpotType getRequiredSpotType() {
        return SpotType.SMALL;
    }
}
