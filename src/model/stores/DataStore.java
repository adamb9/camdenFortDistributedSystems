package model.stores;
import model.*;
import model.bombs.*;
import model.ships.*;

import java.io.Serializable;

//This class is a template for the data which I store in the serializable file.
//It is a simple log of the sentry which saw a ship, the ship it saw, and the bomb produced for it.
//This is part of the Data Access Obect design pattern

public class DataStore implements Serializable {
    private Sentry sentry;
    private Ship ship;
    private Bomb bomb;

    public DataStore(Sentry sentry, Ship ship, Bomb bomb) {
        this.sentry = sentry;
        this.ship = ship;
        this.bomb = bomb;
    }

    public Sentry getSentry() {
        return sentry;
    }

    public void setSentry(Sentry sentry) {
        this.sentry = sentry;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Bomb getBomb() {
        return bomb;
    }

    public void setBomb(Bomb bomb) {
        this.bomb = bomb;
    }



}
