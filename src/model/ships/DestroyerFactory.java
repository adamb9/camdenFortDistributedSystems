package model.ships;

public class DestroyerFactory implements ShipFactory {
    public Ship makeShip(){
        Destroyer destroyer = new Destroyer();
        return destroyer;
    }
}
