package cell;

import java.awt.Graphics;

public class Location implements Cell {
	private int x = 0;
	private int y = 0;
	private boolean bGo = false;
	public Location(int x,int y)
	{
		this.x = x;
		this.y = y;
		this.bGo = true;
	}
	
	public int GetX()
	{
		return x;
	}
	
	public int GetY()
	{
		return y;
	}

	@Override
	public void draw(Graphics g, int x, int y, int size) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean GetVisible() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
