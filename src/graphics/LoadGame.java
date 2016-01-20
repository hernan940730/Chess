package graphics;

import entities.Board;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import utilities.DataBase;
import utilities.MySerialize;
import AI.AI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoadGame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DataBase db = new DataBase();

	/**
	 * Create the frame.
	 */
	public LoadGame(final MenuWindow mw) {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPartida = new JButton("Partida 1");
		btnPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					db=MySerialize.deserializeGame("Game1.ser");
					Board.setPieces(db.getPieces());
					for(int c=0; c<db.getPieces().size(); c++){
						Board.getPieces().get(c).setPosition(db.getPositions().get(c).getX(), db.getPositions().get(c).getY());
						Board.getPieces().get(c).setCastling(db.getCastling().get(c));
					}
					AI.setDifficulty(db.getDifficult());
					BoardGraphics bg = new BoardGraphics(mw);
					bg.setVisible(true);
					setVisible(false);
					mw.setVisible(false);
				}
				catch(Exception ex){
					Warning w = new Warning();
					w.setVisible(true);
				}
			}
		});
		btnPartida.setBounds(184, 50, 89, 23);
		contentPane.add(btnPartida);
		
		JButton btnPartida_1 = new JButton("Partida 2");
		btnPartida_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					db=MySerialize.deserializeGame("Game2.ser");
					Board.setPieces(db.getPieces());
					for(int c=0; c<db.getPieces().size(); c++){
						Board.getPieces().get(c).setPosition(db.getPositions().get(c).getX(), db.getPositions().get(c).getY());
						Board.getPieces().get(c).setCastling(db.getCastling().get(c));
					}
					AI.setDifficulty(db.getDifficult());
					BoardGraphics bg = new BoardGraphics(mw);
					bg.setVisible(true);
					setVisible(false);
					mw.setVisible(false);
				}
				catch(Exception ex){
					Warning w = new Warning();
					w.setVisible(true);
				}
			}
		});
		btnPartida_1.setBounds(184, 84, 89, 23);
		contentPane.add(btnPartida_1);
		
		JButton btnPartida_2 = new JButton("Partida 3");
		btnPartida_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					db=MySerialize.deserializeGame("Game3.ser");
					Board.setPieces(db.getPieces());
					for(int c=0; c<db.getPieces().size(); c++){
						Board.getPieces().get(c).setPosition(db.getPositions().get(c).getX(), db.getPositions().get(c).getY());
						Board.getPieces().get(c).setCastling(db.getCastling().get(c));
					}
					AI.setDifficulty(db.getDifficult());
					BoardGraphics bg = new BoardGraphics(mw);
					bg.setVisible(true);
					setVisible(false);
					mw.setVisible(false);
				}
				catch(Exception ex){
					Warning w = new Warning();
					w.setVisible(true);
				}
			}
		});
		btnPartida_2.setBounds(184, 118, 89, 23);
		contentPane.add(btnPartida_2);
		
		JButton btnPartida_3 = new JButton("Partida 4");
		btnPartida_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					db=MySerialize.deserializeGame("Game4.ser");
					Board.setPieces(db.getPieces());
					for(int c=0; c<db.getPieces().size(); c++){
						Board.getPieces().get(c).setPosition(db.getPositions().get(c).getX(), db.getPositions().get(c).getY());
						Board.getPieces().get(c).setCastling(db.getCastling().get(c));
					}
					AI.setDifficulty(db.getDifficult());
					BoardGraphics bg = new BoardGraphics(mw);
					bg.setVisible(true);
					setVisible(false);
					mw.setVisible(false);
				}
				catch(Exception ex){
					Warning w = new Warning();
					w.setVisible(true);
				}
			}
		});
		btnPartida_3.setBounds(184, 152, 89, 23);
		contentPane.add(btnPartida_3);
		
		JButton btnPartida_4 = new JButton( "Partida 5" );
		btnPartida_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					db=MySerialize.deserializeGame("Game5.ser");
					Board.setPieces(db.getPieces());
					for(int c=0; c<db.getPieces().size(); c++){
						Board.getPieces().get(c).setPosition(db.getPositions().get(c).getX(), db.getPositions().get(c).getY());
						Board.getPieces().get(c).setCastling(db.getCastling().get(c));
					}
					AI.setDifficulty( db.getDifficult() );
					BoardGraphics bg = new BoardGraphics(mw);
					bg.setVisible(true);
					setVisible(false);
					mw.setVisible(false);
				}
				catch(Exception ex){
					Warning w = new Warning();
					w.setVisible(true);
				}
			}
		});
		btnPartida_4.setBounds(184, 186, 89, 23);
		contentPane.add(btnPartida_4);
	}
}
