import java.util.ArrayList;
import java.util.Iterator;

public class Kinsale implements Sentry, Runnable {
    private Thread t;
    private String threadName;

    private int shipType;
    ArrayList<Observer> observerList;
    String kinsale = "Kinsale";

    Kinsale(){
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
    public void notifyObservers()
    {
        for (Iterator<Observer> it =
             observerList.iterator(); it.hasNext();)
        {
            Observer o = it.next();
            o.update(kinsale, shipType);
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
        return 2;
    }

    void change(){
        shipType = getLatestShip();
        notifyObservers();
    }
}
