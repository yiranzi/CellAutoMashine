package animal;

import java.util.ArrayList;

import cell.Cell;
import cell.Unit;

public interface Live {
	//public void born(int x,int y);//reborn变为unit的操作.所有绘图元素都有reborn操作.
	public void die();
	
	public boolean isAlive();
	public void move(char dir);
	public ArrayList<Cell> see();
	public Cell feed(ArrayList<Cell> c); 
	public ArrayList<Cell> GetEmpty(ArrayList<Cell> unitAround);
	public int AgeAdd();
	public void OldDead();
	//public void ReBoren();//复活
	
	public void action();

}
