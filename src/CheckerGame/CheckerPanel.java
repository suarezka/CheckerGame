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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
				board[r][c].setPreferredSize(new Dimension(200, 200));
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
					board[a][b].setBackground(Color.GRAY);
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
			redPieceResize = redPieces.getScaledInstance(220, 220, 220);
			grayPieceResize = grayPieces.getScaledInstance(250, 250, 250);
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
		public void mouseClicked(MouseEvent arg0) {
			//movement and shit
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
}
