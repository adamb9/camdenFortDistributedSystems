package model;

import model.ships.Ship;

//The Sentry interface is part of the Observer pattern
//A sentry is an Observable object
//A sentry can attach itself to an Observer and notify it of any changes in data.

public interface Sentry {
    public void registerObserver(Observer o);
    public void unregisterObserver(Observer o);
    public void notifyObservers(Ship ship);
}
