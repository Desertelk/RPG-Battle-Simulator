public class Barbarian extends Character{
    public Barbarian(String name){
        super(name, 85, 15);

        moves.add(new AttackMove("Heavy Slash", false, 10));
        moves.add(new AttackMove("Rageful Bash", false, 15));
    }
}
