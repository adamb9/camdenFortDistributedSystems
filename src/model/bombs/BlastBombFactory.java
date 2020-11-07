package model.bombs;

public class BlastBombFactory implements BombFactory{
    public Bomb makeBomb() {
        BlastBomb blastBomb = new BlastBomb();
        return blastBomb;
    }
}
