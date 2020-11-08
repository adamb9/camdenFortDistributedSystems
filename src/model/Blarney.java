package model;

import model.bombs.*;
import model.ships.Ship;
import model.stores.DataStore;
import model.stores.StoreDaoImpl;
import java.io.Serializable;
import java.util.LinkedList;

//The Blarney class is the Observer class.
//It receives an update from the Sentry classes when a ship is spotted.
//It also contains the Producer - Consumer pattern which is implemented using threads.
//This means that when a ship is spotted the Sentry sends the type of ship and location to Blarney.
//Blarney will take this data and produce the appropriate bombs to destroy these ships.
//These bombs will be consumed in order to simulate sending these bombs out to destroy the ships.

public class Blarney implements Observer, Runnable, Serializable {
    private String shipType;
    private String threadName;
    Bomb bomb = null;
    Sentry sentry;
    Ship ship;

    LinkedList<Bomb> list = new LinkedList<>();
    int capacity = 10;

    StoreDaoImpl storeDao = StoreDaoImpl.getInstance();


    public Blarney(){
        threadName = "BlarneyThread";
        System.out.println("Creating"+ threadName);
    }

    @Override
    public String toString() {
        return "Blarney";
    }

    public StoreDaoImpl getStores(){
        return storeDao;
    }

    public void update(Sentry currentSentry, Ship currentShip) {
        shipType = currentShip.function();
        System.out.println("At "+ currentSentry.toString() + " there is a "+ shipType);

        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    produce(currentShip);
                    sentry = currentSentry;
                    ship = currentShip;
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producerThread.start();
    }


    @Override
    public void run() {
        System.out.println("Running " +  threadName );
        // Create consumer thread
        try{
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
            consumerThread.start();

            consumerThread.join();

            Thread.sleep(1000);
        } catch (Exception e) {
    }
    }



    // Function called by producer thread
    public void produce(Ship ship) throws InterruptedException {

        while (true) {
            synchronized (this) {
                // producer thread waits while list
                // is full
                while (list.size() == capacity)
                    wait();

                if((ship.function()).equals("Aircraft Carrier")){
                    TorpedoFactory torpedoFactory = new TorpedoFactory();
                    bomb = torpedoFactory.makeBomb();
                }
                else if((ship.function()).equals("Destroyer")){
                    ArmourPiercingFactory armourPiercingFactory = new ArmourPiercingFactory();
                    bomb = armourPiercingFactory.makeBomb();
                }
                else if((ship.function()).equals("Sailing Ship")){
                    BlastBombFactory   blastBombFactory = new BlastBombFactory();
                    bomb = blastBombFactory.makeBomb();
                }


                System.out.println("Producer produced-"
                        + bomb);

                // to insert the jobs in the list
                list.add(bomb);

                // notifies the consumer thread that
                // now it can start consuming
                notify();


                break;
            }
        }
    }

        // Function called by consumer thread
        public void consume() throws InterruptedException
        {
            while (true) {
                synchronized (this)
                {
                    // consumer thread waits while list
                    // is empty
                    while (list.size() == 0)
                        wait();

                    DataStore store = new DataStore(sentry, ship, bomb);
                    storeDao.addStore(store);


                    // to retrive the first job in the list
                    Bomb val = list.removeFirst();

                    System.out.println("Consumer consumed-"
                            + val);

                    // Wake up producer thread
                    notify();

                }
            }
        }

}

