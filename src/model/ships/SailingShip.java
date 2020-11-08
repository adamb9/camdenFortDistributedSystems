package model.ships;

import java.io.Serializable;

public class SailingShip implements Ship, Serializable {
    public String function(){
        return "Sailing Ship";
    }

    @Override
    public String toString() {
        return "Sailing Ship";
    }
}
