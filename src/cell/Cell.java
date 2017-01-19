package cell;

import java.awt.Graphics;
//把cell做成接口
//这个接口为了满足field
public interface Cell {
	public int GetX();
	public int GetY();
	public void draw(Graphics g, int x, int y, int size);	

}