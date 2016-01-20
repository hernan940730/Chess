package utilities;

import java.io.Serializable;
import java.util.ArrayList;

import pieces.Pieces;

public class DataBase implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Pieces> pieces = new ArrayList<Pieces>();
	private ArrayList<Pair> positions = new ArrayList<Pair>();
	private ArrayList<Boolean> castling = new ArrayList<Boolean>();
	private boolean turn = false;
	private boolean checkToWhite = false;
	private boolean checkToBlack = false;
	private int difficult = 0;
	
	public int getDifficult() {
		return difficult;
	}

	public void setDifficult(int difficult) {
		this.difficult = difficult;
	}

	public DataBase(){
		super();
	}

	public DataBase(ArrayList<Pieces> pieces, ArrayList<Pair> positions,
			ArrayList<Boolean> castling, boolean turn, boolean checkToWhite,
			boolean checkToBlack, int difficult) {
		super();
		this.pieces = pieces;
		this.positions = positions;
		this.castling = castling;
		this.turn = turn;
		this.checkToWhite = checkToWhite;
		this.checkToBlack = checkToBlack;
		this.difficult = difficult;
	}

	public ArrayList<Pieces> getPieces() {
		return pieces;
	}

	public void setPieces(ArrayList<Pieces> pieces) {
		this.pieces = pieces;
	}

	public ArrayList<Pair> getPositions() {
		return positions;
	}

	public void setPositions(ArrayList<Pair> positions) {
		this.positions = positions;
	}

	public ArrayList<Boolean> getCastling() {
		return castling;
	}

	public void setCastling(ArrayList<Boolean> castling) {
		this.castling = castling;
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public boolean isCheckToWhite() {
		return checkToWhite;
	}

	public void setCheckToWhite(boolean checkToWhite) {
		this.checkToWhite = checkToWhite;
	}

	public boolean isCheckToBlack() {
		return checkToBlack;
	}

	public void setCheckToBlack(boolean checkToBlack) {
		this.checkToBlack = checkToBlack;
	}
}
