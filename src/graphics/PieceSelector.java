package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import pieces.*;
import utilities.Pair;

import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import entities.Board;

import java.awt.Color;

public class PieceSelector extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Pair p = new Pair();

	public PieceSelector(){
		super();
	}
	
	public static Pair getP() {
		return p;
	}

	public static void setP(Pair p1) {
		p = p1;
	}

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PieceSelector(final JFrame bg) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 229);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnQueen = new JButton("");
		btnQueen.addActionListener(new ActionListener() {
			public void  actionPerformed(ActionEvent e) {
				
				Board.getPieces().add(new Queen(p, true));
				setVisible(false);
				Board.setTurn(false);
				bg.repaint();
				
			}
		});
		btnQueen.setIcon(new ImageIcon("textures/WhiteQueen.png"));
		btnQueen.setBounds(17, 118, 64, 64);
		contentPane.add(btnQueen);
		
		JButton btnTower = new JButton("");
		btnTower.addActionListener(new ActionListener() {
			public void  actionPerformed(ActionEvent e) {
				
				Board.getPieces().add(new Tower(p, true));
				setVisible(false);
				Board.setTurn(false);
				bg.repaint();
				
			}
		});
		btnTower.setIcon(new ImageIcon("textures/WhiteTower.png"));
		btnTower.setBounds(93, 118, 64, 64);
		contentPane.add(btnTower);
		
		JButton btnBishop = new JButton("");
		btnBishop.addActionListener(new ActionListener() {
			public void  actionPerformed(ActionEvent e) {
				
				Board.getPieces().add(new Bishop(p, true));
				setVisible(false);
				Board.setTurn(false);
				bg.repaint();
				
			}
		});
		btnBishop.setIcon(new ImageIcon("textures/WhiteBishop.png"));
		btnBishop.setBounds(169, 119, 64, 64);
		contentPane.add(btnBishop);
		
		JButton btnHorse = new JButton("");
		btnHorse.addActionListener(new ActionListener() {
			public void  actionPerformed(ActionEvent e) {
				
				Board.getPieces().add(new Horse(p, true));
				setVisible(false);
				Board.setTurn(false);
				bg.repaint();
				
			}
		});
		btnHorse.setIcon(new ImageIcon("textures/WhiteHorse.png"));
		btnHorse.setBounds(245, 118, 64, 64);
		contentPane.add(btnHorse);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Escoja la pieza que desea :)");
		lblNewJgoodiesTitle.setForeground(Color.BLUE);
		lblNewJgoodiesTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewJgoodiesTitle.setBounds(28, 6, 281, 100);
		contentPane.add(lblNewJgoodiesTitle);
	}
}
