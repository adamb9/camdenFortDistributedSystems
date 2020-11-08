package model;

import model.ships.Ship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Kinsale implements Sentry, Runnable, Serializable {
    private String threadName;
    ArrayList<Observer> observerList;

    public Kinsale(){
        threadName = "KinsaleThread";
        System.out.println("Creating"+ threadName);

        observerList = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        observerList.remove(observerList.indexOf(o));
    }

    @Override
    public void notifyObservers(Ship ship)
    {
        for (Iterator<Observer> it =
             observerList.iterator(); it.hasNext();)
        {
            Observer o = it.next();
            o.update(this, ship);
        }
    }

    @Override
    public String toString() {
        return "Kinsale";
    }

    public void run() {
        System.out.println("Running " +  threadName );
    }

    public synchronized void change(Ship ship){
        notifyObservers(ship);
    }
}
