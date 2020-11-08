package model.bombs;

//This is the BombFactory interface.
// It is part of the bomb factory hierarchy which is implemented by the BlastBombFactory, ArmourPiercingFactory, and TorpedoFactory classes.
//It is used as part of the Factory Method design pattern.

public interface BombFactory {
    public Bomb makeBomb();
}
