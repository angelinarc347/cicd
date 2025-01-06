import java.util.Scanner;

public class Game {
    private GameState state;
    private Scanner scanner;

    public Game() {
        this.state = GameState.getInstance();
        this.scanner = new Scanner(System.in);
    }

    // Method to allow the player to choose the level
    public void chooseLevel() {
        System.out.println("Choose a level (1 to 3): ");
        int level = scanner.nextInt(); // User selects the level

        // Ensure the level is valid
        if (level < 1 || level > 3) {
            System.out.println("Invalid level! Setting to Level 1.");
            level = 1; // Default to Level 1 if invalid input
        }

        state.setLevel(level); // Set the level in the GameState
        System.out.println("You have selected Level " + level);
    }

    public void startLevel() {
        System.out.println("Starting Level " + state.getLevel() + " on " + state.getDifficulty() + " difficulty.");

        // Dynamic enemy selection based on level
        Enemy enemy;
        switch (state.getLevel()) {
            case 1:
                enemy = EnemyFactory.createEnemy("Goblin");
                break;
            case 2:
                enemy = EnemyFactory.createEnemy("Orc");
                break;
            case 3:
                enemy = EnemyFactory.createEnemy("Dragon");
                break;
            default:
                enemy = EnemyFactory.createEnemy("Goblin"); // Fallback to Goblin if level exceeds available types
                break;
        }
        System.out.println(enemy.attack());

        // Item Creation
        GameItemFactory itemFactory = state.getDifficulty().equalsIgnoreCase("Easy") 
                ? new EasyLevelFactory() 
                : new HardLevelFactory();

        Weapon weapon = itemFactory.createWeapon();
        PowerUp powerUp = itemFactory.createPowerUp();

        System.out.println(weapon.use());
        System.out.println(powerUp.activate());

        // Update Score
        state.updateScore(100);
        System.out.println("Score: " + state.getScore());
    }

    public void nextLevel() {
        state.setLevel(state.getLevel() + 1);
    }

    public static void main(String[] args) {
        Game game = new Game();
        
        // Let the user choose the starting level
        game.chooseLevel();

        // Start the selected level
        game.startLevel();

        // Optionally, proceed to next levels
        game.nextLevel();   // Advance to Level 2
        game.startLevel();  // Start Level 2
        game.nextLevel();   // Advance to Level 3
        game.startLevel();  // Start Level 3
    }
}
