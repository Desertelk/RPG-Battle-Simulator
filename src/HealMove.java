public class HealMove extends Move{
    private int healAmount;

    public HealMove(String name, int healAmount){
        super(name, true);
        this.healAmount = healAmount;
    }

    @Override 
    public void execute(Character user, Character target){
        target.heal(healAmount);
        System.out.printf("%s users %s and heals %s for %d hp", user.getName(), name, target.getName(), healAmount);
    }
}
