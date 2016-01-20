package entities;

import graphics.BoardGraphics;

import java.util.ArrayList;

import pieces.Bishop;
import pieces.Horse;
import pieces.King;
import pieces.Pawn;
import pieces.Pieces;
import pieces.Queen;
import pieces.Tower;

import utilities.Pair;

/**
 * 
 * @author Camilo Cort�s - Ivan Arevalo - Hern�n Olarte
 *
 */
public class Board {
	private static ArrayList<Pieces> pieces = new ArrayList <Pieces>();
	private static Pieces[][] board= new Pieces[8][8];
	private static boolean turn=true;
	public Board(){
		super();
	}


	public static Pieces nulPiece = new Pieces();
	
	/**
	 * Place the game on an initial state
	 */
	public static void setGame(){
		
		ArrayList<Pawn> whitePawnList= new  ArrayList<Pawn>();
		ArrayList<Bishop> whiteBishopList= new  ArrayList<Bishop>();
		ArrayList<Bishop> blackBishopList= new  ArrayList<Bishop>();
		ArrayList<Pawn> blackPawnList= new  ArrayList<Pawn>();
		ArrayList<Horse> whiteHorseList= new  ArrayList<Horse>();
		ArrayList<Horse> blackHorseList= new  ArrayList<Horse>();
		ArrayList<Tower> whiteTowerList= new  ArrayList<Tower>();
		ArrayList<Tower> blackTowerList= new  ArrayList<Tower>();
		
		
		for(int i = 0 ; i < 8 ; i++){
			whitePawnList.add(new Pawn(new Pair(i , 6), true));
			blackPawnList.add(new Pawn(new Pair(i , 1), false));
		}
		
		for(int  i =  0 ; i < 2 ; i++){
			whiteBishopList.add(new Bishop(new Pair((i+5)-(i*4) ,7), true));
			blackBishopList.add(new Bishop(new Pair((i+5)-(i*4) , 0), false));
			whiteHorseList.add(new Horse(new Pair((i+6)-(i*6) ,7), true));
			blackHorseList.add(new Horse(new Pair((i+6)-(i*6) , 0), false));
			whiteTowerList.add(new Tower(new Pair((i+7)-(i*8) ,7), true));
			blackTowerList.add(new Tower(new Pair((i+7)-(i*8) , 0), false));
		}
		King whiteKing=new King(new Pair(4 , 7),true);
		King blackKing=new King(new Pair(4 , 0),false);
		Queen whiteQueen=new Queen(new Pair(3 , 7),true);
		Queen blackQueen=new Queen(new Pair(3 , 0),false);
		
		
		pieces.addAll(whitePawnList);
		pieces.addAll(blackPawnList);
		pieces.addAll(whiteBishopList);
		pieces.addAll(blackBishopList);
		pieces.addAll(whiteHorseList);
		pieces.addAll(blackHorseList);
		pieces.addAll(whiteTowerList);
		pieces.addAll(blackTowerList);
		pieces.add(whiteKing);
		pieces.add(whiteQueen);
		pieces.add(blackQueen);
		pieces.add(blackKing);

	}
	
	/**
	 * This method fill the board of nullPieces.
	 */
	public static void setNull(){
		for(int i= 0 ; i< 8 ; i++){
			for(int j =0 ; j<8 ; j++){
				board[i][j] = nulPiece;
			}
		}
	}
	
	/**
	 * This method places the pieces on the board
	 */
	public static void setPiecesInBoard(){
		Board.setNull();
		for(int c=0; c<pieces.size(); c++){
			board[pieces.get(c).getPosition().getY()][pieces.get(c).getPosition().getX()] = pieces.get(c);
		}
		
	}
	
	/**
	 * This method prints a board
	 */
	public static void printGame(){
		setPiecesInBoard();
		if(turn){
			System.out.println("Turn: White");
		}
		else{
			System.out.println("Turn: Black");
		}
		System.out.println("BLACK");
		for(int i = 0 ; i<8 ; i++){
			for(int j = 0 ; j < 8 ; j++){
				System.out.print("["+board[i][j].getChar()+"]");	
			}
			System.out.println("");
		}
		System.out.println("WHITE");	
	}
	
	public static Pieces[][] getBoard(){
		return board;
	}
	public static ArrayList<Pieces> getPieces(){
		return pieces;
	}
	public static void setPieces(ArrayList<Pieces> newPieces){
		pieces=newPieces;
	}
	public static boolean getTurn(){
		if(turn){
			BoardGraphics.getLabel_1().setText("Blancas");
		}else{
			BoardGraphics.getLabel_1().setText("Negras");
		}
		return turn;
	}
	public static void setTurn(boolean newTurn){
		turn=newTurn;
	}
	
}
