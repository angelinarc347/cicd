
public class EnemyFactory {
	public static Enemy createEnemy(String enemyType) {
        switch (enemyType) {
            case "Goblin":
                return new Goblin();
            case "Orc":
                return new Orc();
            case "Dragon":
                return new Dragon();
            default:
                throw new IllegalArgumentException("Unknown enemy type: " + enemyType);
        }
    }
}
