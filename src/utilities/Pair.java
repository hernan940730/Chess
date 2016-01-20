package utilities;

import java.io.Serializable;

public class Pair  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x; // Position in X
	private int y; // Position in Y
	
	public Pair(){
		super();
	}
	public Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
