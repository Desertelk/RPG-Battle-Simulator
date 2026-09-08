public class AttackMove extends Move {
    private int power;

    public AttackMove(String name, boolean healing, int power){
        super(name, false);
        this.power = power;
    }

    @Override 
    public void execute(Character user, Character target){
        int damage = user.attack + power;
        System.out.printf("\n%s uses %s and deals %d damage!\n", user.getName(), name, damage);
        target.takeDamage(damage);
    }
}
