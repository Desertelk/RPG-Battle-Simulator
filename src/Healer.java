public class Healer extends Character{
    public Healer(String name){
        super(name, 65, 7);

        moves.add(new AttackMove("Staff slam", false, 10));
        moves.add(new HealMove("Heal", 25));
    }
}
