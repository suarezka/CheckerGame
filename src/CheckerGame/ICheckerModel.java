package CheckerGame;

public interface ICheckerModel {
	boolean isComplete();
	
	//boolean isValidMove(Move move);
	
	//void move(Move move);
	
	boolean gameOver(Player winner);
	
	Player currentPlayer();
	
}
