package model;

import model.ships.Ship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Youghal implements Sentry, Runnable, Serializable {

    ArrayList<Observer> observerList;
    private String threadName;

    public Youghal(){
        threadName = "YoughalThread";
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
        return "Youghal";
    }

    public void run() {
        System.out.println("Running " +  threadName );
    }

    public synchronized void change(Ship ship){
        notifyObservers(ship);
    }

}
