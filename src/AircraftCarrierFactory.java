public class AircraftCarrierFactory implements ShipFactory{
    public Ship makeShip(){
        AircraftCarrier aircraftCarrier = new AircraftCarrier();
        return aircraftCarrier;
    }
}
