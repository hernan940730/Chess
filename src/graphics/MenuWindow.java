package graphics;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

import AI.AI;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MenuWindow mw= this;

	public void paint(Graphics g)
	{
		
		super.paint(g);
		for(int i =0 ; i < 30 ; i ++){
			if(i %2 == 0) {
				g.setColor(Color.WHITE);
			}
			else{
				g.setColor(Color.BLACK);
			}
			g.drawRect(130-i, 110-i, 145+(2*i), 170+(2*i));
		}
	}

	/**
	 * Create the frame.
	 */
	public MenuWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 336);
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane(contentPane);
		contentPane.setBackground(Color.ORANGE);
		contentPane.setLayout( null );
		
		
		JLabel Title = new JLabel("Chess Game PRO");
		Title.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		Title.setForeground(Color.BLUE);
		Title.setBounds(68, 11, 250, 43);
		contentPane.add(Title);
		
		JButton btnNivel = new JButton("Nivel 1");
		btnNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AI.setDifficulty(1);
				BoardGraphics bg = new BoardGraphics(mw);
				bg.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnNivel.setBounds(142, 94, 106, 29);
		contentPane.add(btnNivel);
		
		JButton btnNivel_1 = new JButton("Nivel 2");
		btnNivel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AI.setDifficulty(2);
				BoardGraphics bg = new BoardGraphics(mw);
				bg.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnNivel_1.setBounds(142, 133, 106, 29);
		contentPane.add(btnNivel_1);
		
		JButton btnNivel_2 = new JButton("Nivel 3");
		btnNivel_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AI.setDifficulty(3);
				BoardGraphics bg = new BoardGraphics(mw);
				bg.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnNivel_2.setBounds(142, 173, 106, 29);
		contentPane.add(btnNivel_2);
		
		JButton btnLoadGame = new JButton("Cargar");
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadGame lg= new LoadGame(mw);
				lg.setVisible(true);
			}
		});
		btnLoadGame.setBounds(142, 213, 106, 29);
		contentPane.add(btnLoadGame);
		
		setVisible(true);
	}
}
