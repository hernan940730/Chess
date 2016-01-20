package AI;


import java.util.ArrayList;

import entities.Board;

import pieces.Pieces;
import pieces.Queen;
import utilities.*;

public class AI {
	private static int totalScore=0;
	private static GamePlays bestGamePlay=new GamePlays();
	private static int level=0;
	private static int difficult=0;
	
	public AI () {
		super();
	}
	
	/**
	 * Gets a numeric score according to the piece and the position in which this is.
	 * 
	 * @param piece The piece is evaluated
	 * @return The score
	 */
	public static int pieceScore (Pieces piece){
		int score = 0;
		int pawn = 2;
		int bishop = 7;
		int horse = 5;
		int tower = 10;
		int king = 0;
		int queen = 15;
		
		switch (piece.getChar()){
		case 'p':{
			if(!piece.getColor()){
				score+=getScoreForBlackPawnPosition(piece.getPosition());
			}
			else{
				score+=getScoreForWhitePawnPosition(piece.getPosition());
			}
			score+=pawn;
			break;
		}
		case 'b':{
			score+=bishop;
			break;
		}
		case 'h':{
			score+=horse;
			break;
		}
		case 't':{
			score+=tower;
			break;
		}
		case 'q':{
			score+=queen;
			break;
		}
		case 'k':{
			score+=king;
			break;
		}
	}				
	return score;	
}
	
	/**
	 * This method gives a score to a black pawn according to its position on the board.
	 * @param p The position of a piece
	 * @return The score
	 */
	private static int getScoreForBlackPawnPosition( Pair p ) {
		byte[][] positionWeight =
			{ {0,0,0,0,0,1,2,9}
			 ,{0,0,0,0,0,1,2,9}
			 ,{0,0,0,0,0,1,2,9}
			 ,{0,0,0,0,0,1,2,9}
			 ,{0,0,0,0,0,1,2,9}
			 ,{0,0,0,0,0,1,2,9}
			 ,{0,0,0,0,0,1,2,9}
			 ,{0,0,0,0,0,1,2,9}
			 };
		return positionWeight[p.getX()][p.getY()];
	}
	/**
	 * This method gives a score to a white pawn according to its position on the board.
	 * @param p The position of a piece
	 * @return The score
	 */
	private static int getScoreForWhitePawnPosition( Pair p ) {
		byte[][] positionWeight =
		{ {9,2,1,0,0,0,0,0}
		 ,{9,2,1,0,0,0,0,0}
		 ,{9,2,1,0,0,0,0,0}
		 ,{9,2,1,0,0,0,0,0}
		 ,{9,2,1,0,0,0,0,0}
		 ,{9,2,1,0,0,0,0,0}
		 ,{9,2,1,0,0,0,0,0}
		 ,{9,2,1,0,0,0,0,0}
		 };
		return positionWeight[p.getX()][p.getY()];
	}
	/**
	 * This method adds the condition of the pieces on the board and 
	 * subtracts the state of the enemy pieces to give a score to a play.
	 * 
	 * @param pieces Game pieces
	 * @return The Score of the play
	 */
	public static int playScore(ArrayList<Pieces> pieces){
		for(int c=0; c<pieces.size();c++){
			if(!pieces.get(c).getColor()){
				totalScore+=pieces.get(c).hashCode();
				if(pieces.get(c).getChar()=='t' && pieces.get(c).getCastling() && Utilities.findKing(false).getCastling()){
					totalScore+=1;
				}
			}
			else{
				totalScore-=pieces.get(c).hashCode();
			}
			
			
		}

		if(Utilities.findKing(true).getCheck()){
			totalScore+=1;
		}
		if(Utilities.findKing(false).getCheck()){
			totalScore-=1;
		}
		
		return totalScore;
	}
	
	public static int getTotalScore() {
		return totalScore;
	}

	public static void setTotalScore(int totalScore1) {
		totalScore = totalScore1;
	}
	
	/**
	 * Save the best Play of a set of plays
	 * 
	 * @param p The position of a piece
	 */
	public static void saveBestPlay(Pair p){
		GamePlays gp=new GamePlays();
		gp.saveStade(p);
		bestGamePlay=gp;
	}
	
	/**
	 * Load the best Play of a set of plays
	 * 
	 * @param p The position of a piece
	 */
	public static void loadBestPlay(){
		bestGamePlay.loadStade();
		totalScore=0;
	}
	
	/**
	 * Check all possible moves you can make white pieces.
	 * @param atack if true	check if is a white play
	 * @return if atack=false Number of plays that can make the white player else, score of best White play
	 */
	public static int whitePlayerPlays(boolean atack){
		int plays=0;
		int score=1000;
		int tmpScore=0;
		if(atack){
			level++;
		}
		GamePlays gamePlay=new GamePlays();
		for(int c = 0; c < Board.getPieces().size();c++){
			for(int i = 0 ; i < 8 ; i++){
				for(int j =0 ; j <8 ; j++){	
					if(Board.getPieces().get(c).getColor() && Board.getBoard()[i][j].getChar()!='k'){
						gamePlay.saveStade(new Pair(j,i));
						if(Board.getPieces().get(c).movement(j, i) ){
							Board.setPiecesInBoard();
							Utilities.reviewCheck();
							if(!Utilities.findKing(Board.getBoard()[i][j].getColor()).getCheck()){
								plays++;
								if(atack){
									if(level==2){	
										AI.setTotalScore(0);
										AI.playScore(Board.getPieces());
										tmpScore=AI.getTotalScore()+blackPlayerPlays(true);
										if(score>=tmpScore){
											score=tmpScore;
										}
									}
								}
							}
							gamePlay.loadStade();
							
						}
					}
				}
			}
		}	
		if(atack){
			
			level--;
			if(score==1000 && !Utilities.findKing(true).getCheck()){
				return 0;
			}
			return score;
		}
		return plays;
	}

	/**
	 * Check all possible moves you can make black pieces.
	 * @param atack if true	check if is a black play
	 * @return if atack=false Number of plays that can make the black player else, score of best Black play
	 */
	public static int blackPlayerPlays(boolean atack){
		int plays=0;
		int score=-1000;
		int tmpScore=0;
		if(atack){
			level++;
			
		}
		if(atack && level==1){
			score=-3000;
		}
		GamePlays gamePlay=new GamePlays();
		for(int c = 0; c < Board.getPieces().size();c++){
			for(int i = 0 ; i < 8 ; i++){
				for(int j =0 ; j <8 ; j++){	
					if(!Board.getPieces().get(c).getColor() && Board.getBoard()[i][j].getChar()!='k'){
						gamePlay.saveStade(new Pair(j,i));
						if(Board.getPieces().get(c).movement(j, i)){
							Board.setPiecesInBoard();
							Utilities.reviewCheck();
							if(!Utilities.findKing(Board.getBoard()[i][j].getColor()).getCheck()){
								plays++;
								if(atack){
									if(level==3){
										AI.setTotalScore(0);
										AI.playScore(Board.getPieces());
										if(score<=AI.getTotalScore() && (Math.random()*10<(3*difficult))){
											score=AI.getTotalScore();
										}
									
									}
									if(level==1){
										
										AI.setTotalScore(0);
										AI.playScore(Board.getPieces());									
										tmpScore=AI.getTotalScore()+whitePlayerPlays(true);
										if(score<=tmpScore){
											score=tmpScore;
											AI.saveBestPlay(new Pair(j,i));
										}
										
									
									}
								}
							}
							gamePlay.loadStade();
						}
					}
				}
			}
		}
		if(atack && level==1 && plays!=0){
			AI.loadBestPlay();
			for(int c=0; c< Board.getPieces().size(); c++){
				if(Board.getPieces().get(c).getChar() == 'p'  && Board.getPieces().get(c).getPosition().getY()==7){
					Board.getPieces().add(new Queen(Board.getPieces().get(c).getPosition(), false));
					Board.getPieces().remove(c);
				}	
			}
			Board.setPiecesInBoard();
		}
		if(atack){
			level--;
			return score;
		}
		return plays;
	}
	
	public static int getLevel() {
		return level;
	}
	
	public static int getDifficulty() {
		return difficult;
	}

	public static void setDifficulty(int newDifficulty) {
		difficult = newDifficulty;
	}
	
}
