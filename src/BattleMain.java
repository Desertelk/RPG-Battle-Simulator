import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BattleMain {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        printIntro();
        Character player = selectCharacter();
        List<Character> enemies = createEnemies();
        
         for(int i = 0; i < enemies.size(); i++){
            Character enemy = enemies.get(i);

            printBattleIntro(i);

            BattleEngine battle = new BattleEngine(player, enemy);
            battle.startBattle();

            if(!player.isAlive()){
                break;
            }
            
            player.resetHealth();
        }
        
        if(!player.isAlive()){
            printDefeatMessage();
        } else {
            printVictoryMessage(player);
        }
    }

    public static void printIntro(){
        System.out.println("Hello Adventurer\nThe goblins have stolen this kingdom's entire gold reserve!\nPlease help us to get it back!\n");
    }

    public static Character selectCharacter(){
        List<String> classList = new ArrayList<>();
        classList.add("Barbarian");
        classList.add("Wizard");
        classList.add("Healer");
            while(true){
                System.out.println("What type of adventurer are you?");
                for (int i = 0; i < classList.size(); i++){
                    System.out.println((i+1) + ". " + classList.get(i));
                }

            try {
                System.out.print("Choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice < 1 || choice > 3) {
                System.out.println("Please select one of the options given.\n");
                continue;
            }
        
                System.out.println("What is your name?");
                String name = scanner.nextLine();
                switch (choice) {
                    case 1:                
                        return new Barbarian(name);
                    case 2:
                        return new Wizard(name);
                    case 3:
                        return new Healer(name);
                    default:
                        System.out.println("Please select one of the options given");
                }
        } catch (InputMismatchException e){
            System.out.println("Please input a valid number.\n");
            scanner.nextLine();
        }
    }
}

    public static List<Character> createEnemies(){
        List<Character> enemyList = new ArrayList<>();
        enemyList.add(new Enemy("Goblin", 50, 4));
        enemyList.add(new Enemy("Goblin", 50, 4));
        enemyList.add(new Enemy("Goblin", 50, 5));
        enemyList.add(new Enemy("Goblin Captain", 75, 7));
        enemyList.add(new Enemy("Gorblak", 100, 10));

        return enemyList;
    }

    public static void printBattleIntro(int battleNumber){
        switch (battleNumber){
            case 0:
                System.out.println("\nYou hear reustling in the bushes...");
                System.out.println("A Goblin jumps in your way!");
                break;
            case 1:
                System.out.println("\nYou continue deeper into the forest.");
                System.out.println("Another Goblin spots you and charges");
                break;
            case 2:
                System.out.println("\nThe goblin camp is getting closer.");
                System.out.println("One final Goblin stands between you and the goblin camp.");
                break;
            case 3:
                System.out.println("\nThe remaining goblins suddenly retreat.");
                System.out.println("A much larger Goblin steps forward");
                System.out.println("The Goblin Captain charges!");
                break;
            case 4:
                System.out.println("\nYou finally make it to the goblin stronghold.");
                System.out.println("The gold that you were sent for surrounds a throne made of skins and bones of various animals.");
                System.out.println("Gorblak rises from the grotesque throne and stares you in the eye.");
                System.out.println("\"You want to take the gold back? You'll have to kill me for it\"");
                break;
        }
    }

    public static void printDefeatMessage(){
        System.out.println("\nGorlak stands over you, you lie face down on the floor");
        System.out.println("\"Come back when you wish to try again. I'll be here waiting for you\"");
        System.out.println("A crowd of goblins surround you as the world fades to black...");
    }

    public static void printVictoryMessage(Character player){
        System.out.println("\nYou stand over Gorlak's lifeless body, your own aching, wishing to rest. But there is one more thing left to do.");
        System.out.println("You command the remaining goblins to carry the gold back to the kingdom from which they stole it.");
        System.out.println("The goblins, whose leader is now lying motionless on the ground, agree to your terms.");
        System.out.println("\nThe knights that guard the kingdom see you coming from afar with the horde of goblins.");
        System.out.println("Initially they are shocked to you see you, but they soon come to their senses and sound the alarm to give notice of your return.");
        System.out.println("The king comes to greet you.");
        System.out.println("\"You have done this kingdom a great service. We will be forever in your debt.\n");
        System.out.println("The king announces to his people, \"Today will be forever known as the day of Gorlak's defeat by " + player.getName() + "'s hand\"!");
    }
}
