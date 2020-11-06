public class ArmourPiercingFactory implements BombFactory{
    public Bomb makeBomb() {
        ArmourPiercing armourPiercing = new ArmourPiercing();
        return armourPiercing;
    }
}
