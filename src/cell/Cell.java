package cell;

import java.awt.Graphics;
public class Cell {
	private boolean alive = false;
	private boolean fultureAlive;
	
	public void die() { alive = false; }
	public void reborn() { alive = true; }
	public void ReTurn()
	{
		if(alive == true )alive = false;
		else alive = true;
	}
	public boolean isAlive()
	{ return alive; }
	
	public void prepare(boolean alive)
	{
		this.fultureAlive = alive;
	}
	
	public void readyAlive()
	{
		this.alive = this.fultureAlive;
	}
	
	public void draw(Graphics g, int x, int y, int size) {

		g.drawRect(x, y, size, size);
		if ( alive ) {
			g.fillRect(x, y, size, size);
		}
	}
}