package parkingLotSystem;

public class Car extends Vehicle{

    @Override
    public SpotType getRequiredSpotType() {
        return SpotType.MEDIUM;
    }
}
