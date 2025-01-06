
public class GameState {
	private static GameState instance;
    private int level;
    private int score;
    private String difficulty;

    private GameState() {
        this.level = 1;
        this.score = 0;
        this.difficulty = "Normal";
    }

    public static synchronized GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int points) {
        this.score += points;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

}
