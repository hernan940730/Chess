package graphics;

import entities.Board;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import utilities.DataBase;
import utilities.MySerialize;
import utilities.Pair;
import utilities.Utilities;
import AI.AI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class SaveGame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DataBase db = new DataBase();

	/**
	 * Create the frame.
	 */
	public SaveGame() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPartida = new JButton("Partida 1");
		btnPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Pair> positions = new ArrayList<Pair>();
				ArrayList<Boolean> castling = new ArrayList<Boolean>();
				for(int c=0; c<Board.getPieces().size(); c++){
					positions.add(Board.getPieces().get(c).getPosition());
					castling.add(Board.getPieces().get(c).getCastling());
				}
				db=new DataBase(Board.getPieces(), positions, castling, Board.getTurn(), Utilities.findKing(true).getCheck(), Utilities.findKing(false).getCheck(), AI.getDifficulty());
				try{
					MySerialize.serializeGame("Game1.ser", db);
					setVisible(false);
					BoardGraphics.getLblJuego().setText("Juego Guardado");
					BoardGraphics.getLblJuego().setBounds(652, 427, 100, 20);
				}
				catch(Exception ex){
					
				}
			}
		});
		btnPartida.setBounds(184, 50, 89, 23);
		contentPane.add(btnPartida);
		
		JButton btnPartida_1 = new JButton("Partida 2");
		btnPartida_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Pair> positions = new ArrayList<Pair>();
				ArrayList<Boolean> castling = new ArrayList<Boolean>();
				for(int c=0; c<Board.getPieces().size(); c++){
					positions.add(Board.getPieces().get(c).getPosition());
					castling.add(Board.getPieces().get(c).getCastling());
				}
				db=new DataBase(Board.getPieces(), positions, castling, Board.getTurn(), Utilities.findKing(true).getCheck(), Utilities.findKing(false).getCheck(), AI.getDifficulty());
				try{
					MySerialize.serializeGame("Game2.ser", db);
					setVisible(false);
					BoardGraphics.getLblJuego().setText("Juego Guardado");
					BoardGraphics.getLblJuego().setBounds(652, 427, 100, 20);
				}
				catch(Exception ex){
					
				}
			}
		});
		btnPartida_1.setBounds(184, 84, 89, 23);
		contentPane.add(btnPartida_1);
		
		JButton btnPartida_2 = new JButton("Partida 3");
		btnPartida_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Pair> positions = new ArrayList<Pair>();
				ArrayList<Boolean> castling = new ArrayList<Boolean>();
				for(int c=0; c<Board.getPieces().size(); c++){
					positions.add(Board.getPieces().get(c).getPosition());
					castling.add(Board.getPieces().get(c).getCastling());
				}
				db=new DataBase(Board.getPieces(), positions, castling, Board.getTurn(), Utilities.findKing(true).getCheck(), Utilities.findKing(false).getCheck(), AI.getDifficulty());
				try{
					MySerialize.serializeGame("Game3.ser", db);
					setVisible(false);
					BoardGraphics.getLblJuego().setText("Juego Guardado");
					BoardGraphics.getLblJuego().setBounds(652, 427, 100, 20);
				}
				catch(Exception ex){
					
				}
			}
		});
		btnPartida_2.setBounds(184, 118, 89, 23);
		contentPane.add(btnPartida_2);
		
		JButton btnPartida_3 = new JButton("Partida 4");
		btnPartida_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Pair> positions = new ArrayList<Pair>();
				ArrayList<Boolean> castling = new ArrayList<Boolean>();
				for(int c=0; c<Board.getPieces().size(); c++){
					positions.add(Board.getPieces().get(c).getPosition());
					castling.add(Board.getPieces().get(c).getCastling());
				}
				db=new DataBase(Board.getPieces(), positions, castling, Board.getTurn(), Utilities.findKing(true).getCheck(), Utilities.findKing(false).getCheck(), AI.getDifficulty());
				try{
					MySerialize.serializeGame("Game4.ser", db);
					setVisible(false);
					BoardGraphics.getLblJuego().setText("Juego Guardado");
					BoardGraphics.getLblJuego().setBounds(652, 427, 100, 20);
				}
				catch(Exception ex){
					
				}
			}
		});
		btnPartida_3.setBounds(184, 152, 89, 23);
		contentPane.add(btnPartida_3);
		
		JButton btnPartida_4 = new JButton("Partida 5");
		btnPartida_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Pair> positions = new ArrayList<Pair>();
				ArrayList<Boolean> castling = new ArrayList<Boolean>();
				for(int c=0; c<Board.getPieces().size(); c++){
					positions.add(Board.getPieces().get(c).getPosition());
					castling.add(Board.getPieces().get(c).getCastling());
				}
				db=new DataBase(Board.getPieces(), positions, castling, Board.getTurn(), Utilities.findKing(true).getCheck(), Utilities.findKing(false).getCheck(), AI.getDifficulty());
				try{
					MySerialize.serializeGame("Game5.ser", db);
					setVisible(false);
					BoardGraphics.getLblJuego().setText("Juego Guardado");
					BoardGraphics.getLblJuego().setBounds(652, 427, 100, 20);
				}
				catch(Exception ex){
					
				}
			}
		});
		btnPartida_4.setBounds(184, 186, 89, 23);
		contentPane.add(btnPartida_4);
	}
}
