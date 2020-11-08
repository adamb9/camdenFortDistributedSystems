package model.ships;

//This is the ShipFactory interface.
//It is part of the ship hierarchy which is implemented by the AircraftCarrierFactory, DestroyerFactory, and SailingShipFactory classes.
//It is used as part of the Factory Method Design pattern

public interface ShipFactory {
    public Ship makeShip();
}
