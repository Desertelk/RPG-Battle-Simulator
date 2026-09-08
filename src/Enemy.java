public class Enemy extends Character {
    public Enemy(String name, int health, int attack){
        super(name, health, attack);
        moves.add(new AttackMove("Pummel", false, 5));
        moves.add(new AttackMove("Hateful Strike", false, 10));
    }
}
