package item;

import java.awt.Color;
import java.awt.Graphics;

import animal.People;
import cell.Unit;

public class Item extends Unit {
	
	@Override
	public void draw(Graphics g, int x, int y, int size) {
		g.setColor(new Color(0, 0, 0, 255));
		g.drawRect(x, y, size, size);
		g.fillRect(x, y, size, size);
		
	}
	public static Item myNew(int x,int y)
	{
		Item o = new Item(x,y);
		Unit unit = spawn.CheckSpawn(o);
		if(unit!=null)
		{
			o = (Item)unit;
			RePlace(o,x,y);	
		}
		return o;
	}
	public Item(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Item";
	}

}
