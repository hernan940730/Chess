package utilities;

import pieces.Pieces;
import entities.Board;
import AI.AI;

public class Utilities {
	private static Pieces eatenPiece=new Pieces();
	
	public static Pieces getEatenPiece() {
		return eatenPiece;
	}

	public static void setEatenPiece(Pieces eatenPiece) {
		Utilities.eatenPiece = eatenPiece;
	}

	/**
	 * This method seeks the king's color indicated in the boolean (true-white, false-Black) 
	 * and returns the piece of the king.
	 * 
	 * @param Color the color of the piece
	 * @return King indicated color
	 */
	public static Pieces findKing(boolean Color){
		
		for(int c=0; c<Board.getPieces().size(); c++){
			if(Board.getPieces().get(c).getColor()==Color && Board.getPieces().get(c).getChar()=='k'){
				return Board.getPieces().get(c);
			}
		}
		return null;
	}
	
	/**
	 * Check that the king is not threatened by an enemy piece
	 */
	public static void reviewCheck(){
		
		for(int c=0; c<Board.getPieces().size(); c++){
			if(Board.getPieces().get(c).getColor()){
				if(Board.getPieces().get(c).checkMovement(findKing(false).getPosition().getX(), findKing(false).getPosition().getY())){
					findKing(false).setCheck(true);
					break;
				}
				else{
					findKing(false).setCheck(false);
				}
			}
		}
		for(int c=0; c<Board.getPieces().size(); c++){
			if(!Board.getPieces().get(c).getColor()){
				if(Board.getPieces().get(c).checkMovement(findKing(true).getPosition().getX(), findKing(true).getPosition().getY())){
					findKing(true).setCheck(true);
					break;
				}
				else{
					findKing(true).setCheck(false);
				}
			}
		}
	}
	
	/**
	 * checks that a White king is not in checkmate
	 * @return True when white king is in checkmate
	 */
	public static boolean checkMateToWhite(){
		
		if(AI.whitePlayerPlays(false)==0 && findKing(true).getCheck()){
			return true;
		}
		return false;
	}
	
	/**
	 * checks that a black king is not in checkmate
	 * @return True when black king is in checkmate
	 */
	public static boolean checkMateToBlack(){
		
		if(AI.blackPlayerPlays(false)==0 && findKing(false).getCheck()){
			return true;
		}
		return false;
	}
	
	
	
}
