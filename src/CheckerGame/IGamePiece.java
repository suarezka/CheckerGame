package CheckerGame;

import java.lang.*;

public interface IGamePiece {
	
	/** Returns the player of piece. */
	Player player();
	
	/** Returns piece color. */
	String type();
	
	/** Validates piece movement. */
	boolean isValidMove(Move move, IGamePiece[][] board);
	
	
	
}
