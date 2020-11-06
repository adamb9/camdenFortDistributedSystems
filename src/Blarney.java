@SuppressWarnings( "deprecation" )
public class Blarney implements Observer, Runnable {
    private int shipType;
    private String shipName;

    private Thread t;
    private String threadName;

    Blarney(){
        threadName = "BlarneyThread";
        System.out.println("Creating"+ threadName);
    }

    public void update(String location, int shipType){
        this.shipType = shipType;

        if(shipType ==1){
            shipName = "Aircraft Carrier";
        }
        else if(shipType ==2){
            shipName = "Destroyer";
        }
        else if(shipType ==3){
            shipName = "Sailing Ship";
        }

        System.out.println("At "+ location + " there is a "+ shipName);
    }


    @Override
    public void run() {
        System.out.println("Running " +  threadName );
    }
}
