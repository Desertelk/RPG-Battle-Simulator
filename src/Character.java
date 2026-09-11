import java.util.ArrayList; 
import java.util.List;

public abstract class Character {
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int attack;
    protected List<Move> moves = new ArrayList<>();

    public Character(String name, int hp, int attack){
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attack = attack;
    }

    public boolean isAlive(){
        return hp > 0;
    }

    public void takeDamage(int amount){
        hp -= amount;

        if (hp <= 0){
            hp = 0;
        }

        System.out.printf("%s took %d. Current HP: %d\n", name, amount, hp);
    }

    public void dealDamage(Character target){
        System.out.printf("%s attacks %s for %d damage!\n", name, target.getName(), attack);
        target.takeDamage(attack);
    }

    public void heal(int amount){
        hp += amount;
        if(hp > maxHp){
            hp = maxHp;
        }
    }

    public List<Move> getMoves(){
        return moves;
    }

    public String getName(){
        return name;
    }

    public int getHp(){
        return hp;
    }

    public void resetHealth(){
        hp = maxHp;
    }
}
