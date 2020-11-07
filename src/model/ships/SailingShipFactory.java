package model.ships;

public class SailingShipFactory implements ShipFactory {
    public Ship makeShip(){
        SailingShip sailingShip = new SailingShip();
        return sailingShip;
    }
}
