public class Wizard extends Character{
    public Wizard(String name){
        super(name, 50, 8);

        moves.add(new AttackMove("Fireball", false, 15));
        moves.add(new AttackMove("Lightning Bolt", false, 10));
        moves.add(new HealMove("Arcane Recovery", 20));
    }
}
