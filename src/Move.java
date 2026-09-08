public abstract class Move {
    protected String name;
    protected boolean healing;

    public Move(String name, boolean healing){
        this.name = name;
        this.healing = healing;
    }

    public String getName(){
        return name;
    }

    public boolean isHealing(){
        return healing;
    }

    public abstract void execute(Character user, Character target);
}
