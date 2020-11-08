package model.ships;

import java.io.Serializable;

public class Destroyer implements Ship, Serializable {
    public String function(){
        return "Destroyer";
    }

    @Override
    public String toString() {
        return "Destroyer";
    }
}
