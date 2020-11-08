//Name: Adam Baldwin
//Class: SDH3-A
//Student Number: R00176025

package controller;
import javafx.stage.Stage;
import model.*;
import model.ships.Ship;
import model.ships.ShipFactory;
import model.stores.StoreDaoImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import static view.Main.exitProgram;

public class Controller {

    Youghal youghal = new Youghal();
    Kinsale kinsale = new Kinsale();
    Blarney blarney = new Blarney();
    Thread blarneyThread = new Thread(blarney);
    int shipCount = 0;

    //This function is called when a button is clicked.
    //It takes a sentry location and a ship factory which produces a ship at that location.
    //This is then used to create new sentry threads to communicate and update blarney of this information.
    //Blarney will then produce the bombs to destroy the ships.
    public void makeShip(ShipFactory factory, String location){
        Ship ship = factory.makeShip();
        String shipType = ship.function();
        shipCount++;
        if(shipCount==10){
            endProgram();
        }
        else {
            if (location.equals("Kinsale")) {
                Thread kinsaleThread = new Thread(kinsale);
                kinsaleThread.run();
                kinsale.change(ship);
            }
            if (location.equals("Youghal")) {
                Thread youghalThread = new Thread(youghal);
                youghalThread.run();
                youghal.change(ship);
            }
        }
    }

    //This function is to store the DataStores in a serializable text file
    public void storeData(){
        StoreDaoImpl stores =  blarney.getStores();

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("./dataStore.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(stores);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /dataStore.txt");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    //Stores the DataStores into a file and closes the program
    public void endProgram(){
        storeData();
        exitProgram();
    }

    //When the program is started, a blarney thread is created and the kinsale and youghal sentries are registered to it.
    public void startApp(){
        blarneyThread.start();
        youghal.registerObserver(blarney);
        kinsale.registerObserver(blarney);
    }
}
