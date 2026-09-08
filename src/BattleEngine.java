import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BattleEngine {
    private Character player;
    private Character enemy;
    private Scanner scanner = new Scanner(System.in);
    private Random rand = new Random();

    public BattleEngine(Character player, Character enemy){
        this.player = player;
        this.enemy = enemy;
    }

    public void startBattle(){
        System.out.printf("\nThe battle with %s has begin!\n", enemy.getName());

        while (player.isAlive() && enemy.isAlive()){
            playerTurn(player);

            if(!enemy.isAlive()){
                System.out.printf("You have defeated %s\n", enemy.getName());
                break;
            }
            
            enemyTurn(enemy);
            
            if(!player.isAlive()){
                System.out.println("You have been defeated!");
                break;
            }
        }
    }

    public void playerTurn(Character player){
        List<Move> moves = player.getMoves();

        for (int i = 0; i < moves.size(); i++){
            System.out.println((i+1) + ". " + moves.get(i).getName());
        }

        System.out.print("Choice: ");
        int choice = getUserInput(moves.size());
        Move selectedMove = moves.get(choice - 1);

        if(selectedMove.isHealing()){
            selectedMove.execute(player, player);
        } else {
            selectedMove.execute(player, enemy);
        }
    }

    public int getUserInput(int max){
        int userInt;
        while (true){
            String userChoice = scanner.nextLine();
            try{
                userInt = Integer.parseInt(userChoice);

                if (userInt < 1 || userInt > max){
                    System.out.println("Please enter a number between 1 and " + max);
                    continue;
                }

                return userInt;
            } catch (NumberFormatException e){
                System.out.println("What you typed was not a number. Please try again");
            }
        }
    }

    public void enemyTurn(Character enemy){
        List<Move> moves = enemy.getMoves();
        int randMove = rand.nextInt(moves.size());
        Move move = moves.get(randMove);

        if(move.isHealing()){
            move.execute(enemy, enemy);
        } else {
            move.execute(enemy, player);
        }

    }
}
