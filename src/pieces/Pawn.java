package pieces;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

import entities.Board;
import utilities.Pair;

public class Pawn extends Pieces implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Pawn() {
		super();
	}
	
	public Pawn ( Pair position, boolean color)
	{
		this.position = position;
		this.color=color;
	}
	
	@Override
	public Image getImage(){
		if(this.getColor()){
		return new ImageIcon("textures/WhitePawn.png").getImage();
		}
		return new ImageIcon("textures/BlackPawn.png").getImage();
	}
	
	@Override
	public boolean movement(final int newX ,final int newY)
	{
		if(this.color){
			if(((this.getPosition().getY()==6 && newY==4 && Board.getBoard()[newY+1][newX].getChar()==' ') || 
					((this.getPosition().getY()-newY==1)))&& Board.getBoard()[newY][newX].getChar()==' ' && 
					newX==this.getPosition().getX()){
				this.setPosition(newX, newY);
				return true;
			}
			if((newX==(this.getPosition().getX()-1)||newX==(this.getPosition().getX()+1)) && 
					(newY==this.getPosition().getY()-1)){
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
			}
			return false;
		}
		else{
			if(((this.getPosition().getY()==1 && newY==3 && Board.getBoard()[newY-1][newX].getChar()==' ') || 
					((newY-this.getPosition().getY()==1)))&& Board.getBoard()[newY][newX].getChar()==' ' && 
					newX==this.getPosition().getX()){
				this.setPosition(newX, newY);
				return true;
			}
			
			if((newX==(this.getPosition().getX()-1)||newX==(this.getPosition().getX()+1)) && 
					(newY==this.getPosition().getY()+1)){
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
			}
			return false;
		}
	}
	@Override
	public char getChar(){
		return 'p';
	}
}
