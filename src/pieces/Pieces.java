package pieces;

import java.awt.Image;
import java.io.Serializable;


import entities.Board;
import AI.AI;
import utilities.GamePlays;
import utilities.Pair;

public class Pieces implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Pair position=null;
	protected boolean color;
	protected boolean castling=false;
	protected boolean check=false;
	protected Image pieceImage = null;
	public Pieces(){
		super();	
	}
	
	/**
	 * Collect the position you want to move the piece and see if the move is valid.
	 * 
	 * @param newX Gets the X position at which the piece moved.
	 * @param newY Gets the Y position at which the piece moved.
	 * @return returns true if the move is valid and false otherwise.
	 */
	public boolean movement(int newX, int newY){
		return false;
	}
	
	public Image getImage(){
		return pieceImage;
	}
	
	/**
	 * This method uses the method movement to see 
	 * if it is a valid move and if true executes the movement.
	 * 
	 * @param newX Gets the X position at which the piece moved.
	 * @param newY Gets the Y position at which the piece moved.
	 * 
	 * @return True if the piece is moved.
	 */
	public boolean checkMovement(int newX, int newY){
		GamePlays gamePlay=new GamePlays();
		gamePlay.saveStade(new Pair(newX,newY));
		if(this.movement(newX, newY)){
			gamePlay.loadStade();
			return true;
		}
		return false;
	}
	
	/**
	 * This method is overridden so that a numerical value to a move
	 */
	@Override
	public int hashCode() {
		int result = AI.pieceScore(this);
		return result;
	}
	
	/**
	 * This method checks if the place to which a piece is moved an enemy piece, 
	 * and if so removes the enemy piece.
	 * 
	 * @param position
	 */
	public void eat(Pair position){
		for(int c = 0; c < Board.getPieces().size(); c++){
			if(Board.getPieces().get(c)==Board.getBoard()[position.getY()][position.getX()]){
				Board.getPieces().remove(c);		
			}
		}		
	}
	public Pair getPosition(){
		return position;
	}
	public void setPosition(int x, int y){
		this.position=new Pair(x,y);
	}
	public char getChar(){
		return ' ';
	}
	public boolean getColor(){
		return color;
	}
	public void setCastling(boolean castling){
		this.castling=castling;
	}
	public boolean getCastling(){
		return castling;
	}
	
	public void setCheck(boolean check){
		this.check=check;
	}
	public boolean getCheck(){
		return check;
	}


}
