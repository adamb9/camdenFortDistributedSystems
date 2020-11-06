public class TorpedoFactory implements BombFactory{
    public Bomb makeBomb() {
        Torpedo torpedo = new Torpedo();
        return torpedo;
    }
}
