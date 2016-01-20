package pieces;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

import entities.Board;
import utilities.Pair;

public class Horse extends Pieces implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Horse()
	{
		super();
	}
	public Horse(Pair position, boolean color)
	{
		this.position=position;
		this.color=color;
	}
	
	@Override
	public Image getImage(){
		if(this.getColor()){
		return new ImageIcon("textures/WhiteHorse.png").getImage();
		}
		return new ImageIcon("textures/BlackHorse.png").getImage();
	}
	
	@Override
	public boolean movement(final int newX, final int newY){
		
	
		if(( newX==(position.getX()-2) && newY==(position.getY()-1) || 
		( newX==(position.getX()-2) && newY==(position.getY()+1)) ||
		( newX==(position.getX()+2) && newY==(position.getY()-1)) ||
		( newX==(position.getX()+2) && newY==(position.getY()+1)) ||
		( newX==(position.getX()-1) && newY==(position.getY()+2)) ||
		( newX==(position.getX()-1) && newY==(position.getY()-2)) ||
	    ( newX==(position.getX()+1) && newY==(position.getY()+2)) ||
		( newX==(position.getX()+1) && newY==(position.getY()-2))))
		{
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
		return 'h';
	}
}
