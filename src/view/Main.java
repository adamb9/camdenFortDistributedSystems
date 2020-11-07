package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import controller.*;
import model.ships.*;
import model.stores.*;

public class Main extends Application {
    private Controller controller;

    private Button aircraftCarrier, destroyer, sailingShip;

    public void gui(Stage stage, Controller controller){

        aircraftCarrier = new Button("Aircraft Carrier");
        destroyer = new Button("Destroyer");
        sailingShip = new Button("Sailing Ship");
        GridPane mainGridPane = new GridPane();
        mainGridPane.add(aircraftCarrier, 0, 0);
        mainGridPane.add(destroyer, 0, 1);
        mainGridPane.add(sailingShip, 0, 2);
        stage.setScene(new Scene(mainGridPane, 300, 275));
        stage.show();

        aircraftCarrier.setOnAction(new EventHandler<ActionEvent>(){ public void handle(ActionEvent event) {
            AircraftCarrierFactory aircraftCarrierFactory = new AircraftCarrierFactory();
            String location = stage.getTitle();
            controller.makeShip(aircraftCarrierFactory, location);
        }
        });

        destroyer.setOnAction(new EventHandler<ActionEvent>(){ public void handle(ActionEvent event) {
            DestroyerFactory destroyerFactory = new DestroyerFactory();
            String location = stage.getTitle();
            controller.makeShip(destroyerFactory, location);
        }
        });

        sailingShip.setOnAction(new EventHandler<ActionEvent>(){ public void handle(ActionEvent event) {
            SailingShipFactory sailingShipFactory = new SailingShipFactory();
            String location = stage.getTitle();
            controller.makeShip(sailingShipFactory, location);
        }
        });
    }

    public void start(Stage kinsaleStage){
        Controller controller = new Controller();
        controller.startApp();
        kinsaleStage.setTitle("Kinsale");
        Stage youghalStage = new Stage();
        youghalStage.setTitle("Youghal");
        gui(kinsaleStage, controller);
        gui(youghalStage, controller);

    }


    public static void main(String[] args) {

        StoreDaoImpl singletonExample = StoreDaoImpl.getInstance();
        singletonExample.showMessage();

        StoreDao storeDao = singletonExample;
        DataStore store = storeDao.getAllStores().get(0);

        launch(args);
    }
}
