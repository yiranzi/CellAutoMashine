package cell;

import java.awt.Graphics;

import field.Field;

public abstract class Unit implements Cell {
	protected int posX;
	protected int posY;
	private Field field;

	
	
//	@Override
//	public String GetType() {
//		// TODO Auto-generated method stub
//		return sType;
//	}
	public Unit(int x,int y)
	{
		posX = x;
		posY = y;
	}
	@Override
	public int GetX() {
		// TODO Auto-generated method stub
		return posX;
	}

	@Override
	public int GetY() {
		// TODO Auto-generated method stub
		return posY;
	}

	@Override
	public void draw(Graphics g, int x, int y, int size) {
		// TODO Auto-generated method stub
		g.drawRect(x, y, size, size);
		//g.fillRect(x, y, size, size);
	}
}
