package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Youghal implements Sentry, Runnable{

    private int shipType;
    ArrayList<Observer> observerList;
    String youghal = "model.Youghal";

    private Thread t;
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
    public void notifyObservers()
    {
        for (Iterator<Observer> it =
             observerList.iterator(); it.hasNext();)
        {
            Observer o = it.next();
            o.update(youghal, shipType);
        }
    }



    public void run() {
        System.out.println("Running " +  threadName );
    }

   /* public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
*/

    private int getLatestShip(){
        return 1;
    }

    public void change(){
        shipType = getLatestShip();

        notifyObservers();
    }

}
