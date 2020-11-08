package model.ships;

import java.io.Serializable;

public class AircraftCarrier implements Ship, Serializable {
    public String function(){
        return "Aircraft Carrier";
    }

    @Override
    public String toString() {
        return "AircraftCarrier";
    }
}
