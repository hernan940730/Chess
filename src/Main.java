import entities.*;
import graphics.MenuWindow;


public class Main {

	
	public static void main(String[] args) throws InterruptedException {		
		MenuWindow mw=new MenuWindow();
		mw.setVisible(true);
		Board.setGame();
		Board.setPiecesInBoard();
	}
}
