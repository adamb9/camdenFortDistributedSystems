package model.bombs;

import java.io.Serializable;

public class BlastBomb implements Bomb, Serializable {
    public String function() {
        return "Blast Bomb";
    }

    @Override
    public String toString() {
        return "Blast Bomb";
    }
}
