package CheckerGame;

public class CheckerModel implements ICheckerModel {

	private IGamePiece[][] board;
	private Player player;
	
	public CheckerModel() {
		
		//create the board
		board = new IGamePiece[8][8];
		//add pieces to board, need to finish game pieces before adding
		board[0][0] = new NormalPiece(Player.GRAY);
		//board[0][0] = new GamePiece() {
	}
	
	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isValidMove(Move move) {
		// TODO Auto-generated method stub
		return false;
	}

	public void move(Move move) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean gameOver(Player winner) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player currentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public IGamePiece pieceAt(int row, int column) {
		return board[row][column];
	}
	
}
