package pieces;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

import entities.Board;
import utilities.Pair;

public class King extends Pieces implements Serializable{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public King() {
		super();
	}
	
	public King(Pair position, boolean color) {
		this.position = position;
		this.color=color;
		this.castling=true;
	}
	
	@Override
	public Image getImage(){
		if(this.getColor()){
		return new ImageIcon("textures/WhiteKing.png").getImage();
		}
		return new ImageIcon("textures/BlackKing.png").getImage();
	}
	
	@Override
	public boolean movement( final int newX , final int newY)
	{
		if (((Math.abs(newX - position.getX()) + Math.abs(newY - position.getY()))<=1 || 
				((Math.abs(newX - position.getX())==1) && (Math.abs(newY - position.getY()))==1))){
			
			if(Board.getBoard()[newY][newX].getChar()!=' '){
				if(Board.getBoard()[newY][newX].getColor()!=this.color){
					eat(Board.getBoard()[newY][newX].getPosition());
					this.setPosition(newX, newY);
					this.castling=false;
					return true;
				}
				else{
					return false;
				}
			}
			this.setPosition(newX, newY);
			this.castling=false;
			return true;
		}
		if( newY==this.getPosition().getY() && newX==2 && this.castling && 
				(Board.getBoard()[this.getPosition().getY()][0]).getCastling() && !this.getCheck()){
			for(int x=(newX-1); x<this.getPosition().getX();){
				if(Board.getBoard()[this.getPosition().getY()][x].getChar()!=' '){
					return false;
				}
				x++;
			}
			this.setPosition(newX, newY);
			Board.getBoard()[this.getPosition().getY()][0].setPosition(3, this.getPosition().getY());
			this.castling=false;
			return true;
		}
		if(newY==this.getPosition().getY() && newX==6 && this.castling && 
				(Board.getBoard()[this.getPosition().getY()][7]).getCastling() && !this.getCheck()){
			for(int x=newX; x>this.getPosition().getX();){
				if(Board.getBoard()[this.getPosition().getY()][x].getChar()!=' '){
					return false;
				}
				x--;
			}
			this.setPosition(newX, newY);
			Board.getBoard()[this.getPosition().getY()][7].setPosition(5, this.getPosition().getY());
			this.castling=false;
			return true;
		}
		return false;
	}
	
	@Override
	public char getChar(){
		return 'k';
	}
	@Override
	public boolean getCastling(){
		return castling;
	}
}
