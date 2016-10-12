package CheckerGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class CheckerPanel extends JPanel {
	
	//add more icons for kings, also not sure if i actually need another class for just normal pieces
	//seems like bad coding
	
	//instance variables
	private JButton[][] board;
	private CheckerModel model;
	public JMenuBar topMenu;
	
	//images for icons
	private Image redPieces;
	private Image grayPieces;
	private Image grayPieceResize;
	private Image redPieceResize;
	//Icons
	private ImageIcon rPieces;
	private ImageIcon gPieces;
	
	
	public CheckerPanel() {
		
		addIcons();
		model = new CheckerModel();
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(8, 8));
		add(center, BorderLayout.CENTER);
		board = new JButton[8][8];
		topMenu = new JMenuBar();
		
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				board[r][c] = new JButton("");
				board[r][c].addMouseListener(listener);
				board[r][c].setPreferredSize(new Dimension(80, 80));
				center.add(board[r][c]);
			}
		}
		displayBoard();
	}
	
	private void displayBoard() {
		
		for(int a = 0; a < 8; a++) {
			for(int b = 0; b < 8; b++) {
				if(a % 2 == b % 2) {
					board[a][b].setBackground(Color.RED);
				}
				else {
					board[a][b].setBackground(Color.BLACK);
				}
				if(model.pieceAt(a, b) != null) {
					if(model.pieceAt(a, b).type().equals("Pawn")) {
						if(model.pieceAt(a, b).player() == Player.GRAY) {
							board[a][b].setIcon(gPieces);
						}
						if(model.pieceAt(a, b).player() == Player.RED) {
							board[a][b].setIcon(rPieces);
						}
					}
				}
			}
		}
	}
	
	private void addIcons() {
		//load graphics
		
		try {
			//load images
			redPieces = ImageIO.read(getClass().getResource("/Resources/beer-cap-icon-67249.png"));
			grayPieces = ImageIO.read(getClass().getResource("/Resources/ff-bottle-cap.png"));
			//resize images
			redPieceResize = redPieces.getScaledInstance(105, 105, 105);
			grayPieceResize = grayPieces.getScaledInstance(120, 120, 120);
			//set icons
			rPieces = new ImageIcon(redPieceResize);
			gPieces = new ImageIcon(grayPieceResize);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void reset() {
		model = new CheckerModel();
	}
	
	MouseListener listener = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent a) {
			//movement and shit
			//right click pauses game? maybe with a JOption or some shit. With options to resume, restart, and quit.
			
			for(int r = 0; r < 8; r++) {
				for(int c = 0; c < 8; c++) {
					if(a.getButton() == MouseEvent.BUTTON3) {
						//JOptionPane.showMessageDialog(null, "Game is Paused.");
						Object[] buttons = {"Resume", "Quit", "Restart"};
						JPanel p = new JPanel();
						p.add(new JLabel("Game Paused..." + "Please Select an Option"));
						JTextField text = new JTextField(10);
						p.add(text);
						
						int result = JOptionPane.showOptionDialog(null, p, "Checkers", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, null);
						if(result == 0) {
							//
						}
						if(result == 1) {
							System.exit(0);
						}
						if(result == 2) {
							reset();
						}
					}
					if(a.getButton() == MouseEvent.BUTTON1) {
						//actually moving a piece.
					}
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent a) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent a) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent a) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent a) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
}
