package animal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import cell.Cell;
import cell.Unit;

public class People extends Animals {
	public static People p = new People();
	public static People myNew(int x,int y)
	{
		Unit unit = spawn.CheckSpawn(p);
		//可以复用
		if(unit!=null)
		{
			p = (People)unit;//p从开没真正使用.
			ReBoren(p,x,y);		
		}
		else
		{
			p =new People(x,y);
		}
		return p;	
	}
	public People(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public People() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw(Graphics g, int x, int y, int size) {
		int alpha = (int)((1-getAgePercent())*255);
		g.setColor(new Color(255, 0, 0, alpha));
		g.drawRect(x, y, size, size);
		if ( this.isAlive()) {
			g.fillRect(x, y, size, size);
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "People";
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof People)return true;
		else return false;
	}
	
	@Override
	public Cell feed(ArrayList<Cell> unitArounds) {
		// TODO Auto-generated method stub
		Cell c = super.feed(unitArounds);
		if(c!=null)
		{
			//System.out.println("born:"+c.GetX() +"/"+c.GetY());
			return People.myNew(c.GetX(), c.GetY());			
			//Walk
		}
		return c;
	}
	
	@Override
	public Cell Walk(ArrayList<Cell> unitArounds) {
		// TODO Auto-generated method stub
		Cell c = super.Walk(unitArounds);
		if(c!=null)
		{
			field.move(this, c);
			this.posX = c.GetX();
			this.posY = c.GetY();
			//Walk
		}
		return c;
	}
	
	
	
}
