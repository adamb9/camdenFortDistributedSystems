package model.bombs;

import java.io.Serializable;

public class Torpedo implements Bomb, Serializable {
    public String function(){
        return "Torpedo";
    }

    @Override
    public String toString() {
        return "Torpedo";
    }
}
