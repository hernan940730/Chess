package pieces;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

import entities.Board;
import utilities.Pair;

public class Queen extends Pieces implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Queen(){
		super();
	}
	public Queen(Pair position, boolean color){
		this.position=position;
		this.color=color;
	}
	
	@Override
	public Image getImage(){
		if(this.getColor()){
		return new ImageIcon("textures/WhiteQueen.png").getImage();
		}
		return new ImageIcon("textures/BlackQueen.png").getImage();
	}
	
	@Override
	public boolean movement(final int newX,final int newY){
		if((newX==position.getX()) && (newY==position.getY())){
			return false;
		}
		
		if((Math.abs(newX-position.getX())==Math.abs(newY-position.getY()))){
			
			for(int x=newX,y=newY ;x != position.getX() && y != position.getY() ;){
				
				
				if(newX > position.getX()){
					x -= 1;	
				}
				else{
					x += 1;
				}
				if(newY > position.getY()){
					y -= 1;	
				}
				else{
					y += 1;
				}
				
				if(Board.getBoard()[y][x].getChar() != ' '&& (x!=position.getX() || y!=position.getY())){
					return false;
				}
			}
			if(Board.getBoard()[newY][newX].getChar()!=' '){
				if(Board.getBoard()[newY][newX].getColor()!=this.color){
					eat(Board.getBoard()[newY][newX].getPosition());
					this.setPosition(newX, newY);
					return true;
				}
				else{
					return false;
				}
			}
			this.setPosition(newX, newY);
			return true;
		}
		if((newX == position.getX()) || (newY == position.getY())){
			for(int x=newX,y=newY ;x != position.getX() || y != position.getY() ;){
				
				
				if(newY == position.getY() ){
					if(newX> position.getX()){
						x -= 1;	
					}
					else {
						x += 1 ;
					}
				}
				
				if(newX == position.getX() ){
					if(newY> position.getY()){
						y -= 1;	
					}
					else {
						y += 1 ;
					}
				}
				if(Board.getBoard()[y][x].getChar() != ' ' && (x!=position.getX() || y!=position.getY())){
					return false;
				}
			}
			if(Board.getBoard()[newY][newX].getChar()!=' '){
				if(Board.getBoard()[newY][newX].getColor()!=this.color){
					eat(Board.getBoard()[newY][newX].getPosition());
					this.setPosition(newX, newY);
					return true;
				}
				else{
					return false;
				}
			}
			this.setPosition(newX, newY);
			return true;
		}
		return false;
	}
	@Override
	public char getChar(){
		return 'q';
	}
}
