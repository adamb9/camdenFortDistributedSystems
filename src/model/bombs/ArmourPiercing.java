package model.bombs;

import java.io.Serializable;

public class ArmourPiercing implements Bomb, Serializable {
    public String function(){
        return "Armour Piercing";
    }


    @Override
    public String toString() {
        return "Armour Piercing";
    }
}
