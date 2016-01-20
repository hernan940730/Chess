package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

public class Warning extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public Warning() {
		setBounds(100, 100, 408, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArchivoCorruptoNo = new JLabel("Archivo Corrupto, No se Puede Abrir! ");
		lblArchivoCorruptoNo.setBounds(10, 0, 424, 175);
		lblArchivoCorruptoNo.setForeground(Color.RED);
		lblArchivoCorruptoNo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		contentPane.add(lblArchivoCorruptoNo);
	}

}
