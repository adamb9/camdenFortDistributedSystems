package model;

import model.ships.Ship;

//This is part of the Observable design pattern.
//The Observer has one function which allows the Sentry classes(Observables) to update the data of the Observer

public interface Observer {
    public void update(Sentry sentry, Ship ship);
}
