package controller;
import model.*;
import model.ships.Ship;
import model.ships.ShipFactory;

public class Controller {

    Youghal youghal = new Youghal();
    Kinsale kinsale = new Kinsale();
    Blarney blarney = new Blarney();
    Thread blarneyThread = new Thread(blarney);

    public void makeShip(ShipFactory factory, String location){
        Ship ship = factory.makeShip();

        if (location.equals("Kinsale")){
            Thread kinsaleThread = new Thread(kinsale);
            kinsaleThread.run();
        }
        if(location.equals("Youghal")){
            Thread youghalThread = new Thread(youghal);
            youghalThread.run();
        }
    }

    public void startApp(){
        blarneyThread.start();
        youghal.registerObserver(blarney);
        kinsale.registerObserver(blarney);
    }
}
