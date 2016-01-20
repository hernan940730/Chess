package utilities;

import java.util.ArrayList;

import pieces.Pieces;

import entities.Board;

public class GamePlays {
	
	private int eatenPiecePosition=0;
	private ArrayList <Pair> originalPosition=new ArrayList<Pair>();
	private Pieces eatenPiece=new Pieces();
	private int originalPiecesSize=Board.getPieces().size();
	private ArrayList <Boolean> originalCastling=new ArrayList<Boolean>();
	private boolean originalWhiteCheck=false;
	private boolean originalBlackCheck=false;
	private Pair eatingPositionPair= new Pair();
	public GamePlays(){
		super();
	}
	
	/**
	 * Save the game in an instant.
	 * @param newPosition The move of a piece.
	 */
	public void saveStade(Pair newPosition){
		
		eatingPositionPair=newPosition;
		this.originalWhiteCheck=Utilities.findKing(true).getCheck();
		this.originalBlackCheck=Utilities.findKing(false).getCheck();
		for(int c = 0; c <  Board.getPieces().size();c++){
			this.originalPosition.add(Board.getPieces().get(c).getPosition());
			this.originalCastling.add(Board.getPieces().get(c).getCastling());
		}

		this.eatenPiece=Board.getBoard()[newPosition.getY()][newPosition.getX()];
		for(int l = 0 ; l < Board.getPieces().size(); l++){
			if(Board.getPieces().get(l)==this.eatenPiece){
				this.eatenPiecePosition=l;
				break;
			}
		}
	
		
	}
	
	/**
	 * Load the game.
	 * 
	 */
	public void loadStade(){
		if(this.originalPiecesSize>Board.getPieces().size()){
			Board.getPieces().add(this.eatenPiecePosition, this.eatenPiece);
		}
		if(this.originalPiecesSize<Board.getPieces().size()){
			for(int c=0;c<Board.getPieces().size();c++){
				if(Board.getPieces().get(c)==Board.getBoard()[eatingPositionPair.getY()][eatingPositionPair.getX()]){
					Board.getPieces().remove(c);
				}
			}
			
		}
		Utilities.findKing(true).setCheck(this.originalWhiteCheck);
		Utilities.findKing(false).setCheck(this.originalBlackCheck);
		for(int k = 0; k < Board.getPieces().size(); k++){
			Board.getPieces().get(k).setPosition(this.originalPosition.get(k).getX(),this.originalPosition.get(k).getY());
			Board.getPieces().get(k).setCastling(this.originalCastling.get(k));
		}
		
		Board.setPiecesInBoard();
	}
}
