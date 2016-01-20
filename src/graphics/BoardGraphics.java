package graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;


import pieces.Pieces;

import entities.Board;

import AI.AI;
import utilities.*;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;



public class BoardGraphics extends JFrame implements MouseListener, MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int mx=-1, my=-1;
	private static boolean mouseCLicked = false;
	
	private static JLabel lblJuego = DefaultComponentFactory.getInstance().createTitle("");
	
	private Pieces piece=new Pieces();
	private int x;
	private int y;
	private int newX;
	private int newY;
	private JLabel label = new JLabel("");
	private static JLabel label_1 = new JLabel("");
	
	public static JLabel getLabel_1() {
		return label_1;
	}

	public void setLabel_1(JLabel newLabel) {
		label_1 = newLabel;
	}

	public static boolean getMouseCLicked() {
		return mouseCLicked;
	}

	public static void setMouseCLicked(boolean mouseCLicked1) {
		mouseCLicked = mouseCLicked1;
	}
	
	public void paint(Graphics g)
	{	
		super.paint(g);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 1240, 1240);
		int width = 64, height = 64;
		for(int i = 1; i <= 8; i++){
			for(int j = 1; j <= 8; j++){
				
				if( i%2==1){
					if( j%2==0 )
						g.setColor(new Color(205,133,63));
					else
						g.setColor(Color.WHITE);
				}
				if( i%2==0){
					if( j%2==0 )
						g.setColor(Color.WHITE);
					else
						g.setColor(new Color(205,133,63));
				}					
				g.fillRect(j*64,i*64, width, height);
			}
			
			for(int h =0 ; h < 30 ; h ++){
				if(h %2 == 0) {
					g.setColor(Color.WHITE);
				}
				else{
					g.setColor(Color.BLACK);
				}
				g.drawRect(64-h, 64-h, (64*8)+(2*h), (64*8)+(2*h));
			}
		
		}

		
			for(int  i =0 ; i< Board.getPieces().size() ; i ++){
				{
					g.drawImage(Board.getPieces().get(i).getImage(), (64*Board.getPieces().get(i).getPosition().getX())+64 ,  (64*Board.getPieces().get(i).getPosition().getY())+64 , this);			
				}
			}			
	

			
			if(!Board.getTurn()){
				label.setText("");
				AI.blackPlayerPlays(true);
				
				Utilities.reviewCheck();
				
				Board.setTurn(true);
				

				if(Utilities.findKing(true).getCheck()){
					System.out.println("Check To White");
					label.setText("Jaque a Blancos");					
				}	

					
				if(Utilities.checkMateToWhite()){
					System.out.println("Check Mate");
					System.out.println("Blacks Win");
					label.setText("Jaque Mate\nNegros Ganan");
				}
				
				if(Utilities.checkMateToBlack()){
					Board.setTurn(false);
					System.out.println("Check Mate");
					System.out.println("White Win");
					label.setText("Jaque Mate\nBlancos Ganan");
				
				}
				Board.printGame();
				if(Board.getTurn()){
					repaint();
				}
			}
						
	}
	
	public BoardGraphics(final MenuWindow mw)
	{
	
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize(864,620);
		getContentPane().setLayout(null);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("");
				Board.getPieces().clear();
				Board.setGame();
				Board.setTurn(true);
				repaint();
			}
		});
		btnReiniciar.setBounds(659, 211, 98, 98);
		getContentPane().add(btnReiniciar);		
		label.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 16));
		label.setBounds(617, 11, 259, 67);
		getContentPane().add(label);
		
		
		label_1.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 18));
		label_1.setBounds(617, 116, 140, 26);
		getContentPane().add(label_1);
		
		
		JLabel lblPlay = new JLabel("Juegan");
		lblPlay.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 18));
		lblPlay.setBounds(617, 79, 140, 26);
		getContentPane().add(lblPlay);
		
		JButton btnSalva = new JButton("Salvar \r\nPartida");
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveGame sg=new SaveGame();
				sg.setVisible(true);
			}
		});
		btnSalva.setBounds(652, 349, 119, 56);
		getContentPane().add(btnSalva);
		
		getContentPane().add(lblJuego);
		
		JLabel lblDifficult = DefaultComponentFactory.getInstance().createTitle("Difficultad: "+AI.getDifficulty());
		lblDifficult.setBounds(659, 543, 88, 14);
		getContentPane().add(lblDifficult);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mw.setVisible(true);
				Board.getPieces().clear();
				Board.setGame();
				setVisible(false);
			}
		});
		btnVolver.setBounds(652, 472, 89, 23);
		getContentPane().add(btnVolver);
		setVisible(true);
		
	}
/**
 * Convert the mouse position to a Matrix Position
 * @return Matrix position 
 */
	
	public static Pair converter(){
		Pair partialCoordinate = new Pair(-1,-1);
		for(int i =0 ; i<8 ; i++){
			if((i*64)+64< mx ){
			for(int j =0 ; j<8 ; j++){
					if((j*64)+64 < my){
						partialCoordinate.setX(i);
						partialCoordinate.setY(j);
					}
				}
			}
		}
		return partialCoordinate;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	/**
	 * select the piece that the player want move
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
		lblJuego.setText("");
		mouseCLicked=true;
		mx= e.getX();
		my= e.getY();
		if(Board.getTurn()){
			x=converter().getX();
			y=converter().getY();
			piece = Board.getBoard()[y][x];
			System.out.println(piece.hashCode());
			System.out.println(AI.playScore(Board.getPieces()));
			AI.setTotalScore(0);
			possibleMovementPaint();
		}
		else{
			x=-1;
			y=-1;
		}
	}
/**
 * Select the position that the player want move the selected piece
 */
	@Override
	public void mouseReleased(MouseEvent e) {
		mouseCLicked=false;
		
		if(Board.getTurn()){
			mx= e.getX();
			my= e.getY();
			newX=converter().getX();
			newY=converter().getY();

			System.out.println(x+"-"+y);
			System.out.println(newX+"-"+newY);
			if(x<=7 && y<=7 && x>=0 && y>=0 && newX<=7 && newY<=7 && newX>=0 && newY>=0){
				GamePlays gp=new GamePlays();
				gp.saveStade(new Pair(newX, newY));
				if(Board.getBoard()[y][x].getColor() && Board.getBoard()[y][x].movement(newX, newY)){
					Board.setPiecesInBoard();
					Utilities.reviewCheck();
					if(Utilities.findKing(true).getCheck()){
						gp.loadStade();
					}
					else{
						Board.setTurn(false);
						for(int i = 0 ; i < Board.getPieces().size(); i ++){
							if(Board.getPieces().get(i).getChar() == 'p'  && Board.getPieces().get(i).getPosition().getY()==0){
								Board.getPieces().remove(i);
								PieceSelector.setP(new Pair(newX, newY));
								PieceSelector ps = new PieceSelector(this);
								ps.setVisible(true);
								Board.setTurn(true);
							}
						}
						Utilities.reviewCheck();
						label.setText("");
						if(Utilities.findKing(false).getCheck()){
							System.out.println("Check To Black");
							label.setText("Jaque a Negros");					
						}
					}
				}
			}
		}
		else{
			newX=-1;
			newY=-1;
		}
		
		Board.setPiecesInBoard();
		Board.printGame();
		repaint();
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
	
	/**
	 * paint the possible movements of the selected piece
	 */
	public void possibleMovementPaint(){
		Graphics g = this.getGraphics();
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(piece.checkMovement(i, j) && piece.getColor()){
					g.setColor(Color.BLUE);		
					if(Board.getBoard()[j][i].getChar()!=' ' && !Board.getBoard()[j][i].getColor()){
						g.setColor(Color.RED);	
					}
					for(int c=0; c<5; c++){
						g.drawRoundRect((i+1)*64 -c,(j+1)*64-c, 64-c, 64-c,15-c,15-c);
					}
					
				}
			}
		}
	}

	public static JLabel getLblJuego() {
		return lblJuego;
	}

	public static void setLblJuego(JLabel lblJuego1) {
		lblJuego = lblJuego1;
	}
}
             