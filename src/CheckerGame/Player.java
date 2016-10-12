package CheckerGame;

public enum Player {
	GRAY, RED;
	
	/** Returns next player. */
	public Player next() {
		return this == GRAY ? RED : GRAY;
	}
}
