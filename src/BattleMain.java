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
    
        for (Character enemy : enemies){
            BattleEngine battle = new BattleEngine(player, enemy);
            battle.startBattle();

            player.resetHealth();
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
}
