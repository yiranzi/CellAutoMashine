package animal;

import java.awt.Graphics;

public class People extends Animals {

	public People(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g, int x, int y, int size) {
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


}
