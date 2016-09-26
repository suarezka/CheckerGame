package CheckerGame;

public class NormalPiece extends GamePiece {
	
	public Player owner;
	
	protected NormalPiece(Player player) {
		this.owner = player;
		//sets player to piece
	}

	public Player player() {
		return owner;
	}
	
	@Override
	public String type() {
		return "Pawn";
	}
	
	@Override
	public boolean isValidMove(Move move, IGamePiece[][] board) {
		if(board[move.fromRow][move.fromColumn].player() == Player.GRAY) {
			//for gray players (Starting at the top)
			if(move.fromRow == move.toRow || move.fromColumn == move.toColumn) {
				return false;
			}
			if(Math.abs(move.fromColumn-move.toColumn) > 1) {
				return false;
			}
			if(move.fromRow - move.toRow != 1) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			//for red players (Starting at the bottom)
			if(move.fromRow == move.toRow || move.fromColumn == move.toColumn) {
				return false;
			}
			if(Math.abs(move.fromColumn - move.toColumn) > 1) {
				return false;
			}
			if(move.fromRow - move.toRow != -1) {
				return false;
			}
			else {
				return true;
			}
		}
	}
}
