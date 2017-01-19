package field;

import java.util.ArrayList;

import cell.Unit;

public class Field {
	private int width;
	private int height;
	private Unit[][] field;
	
	public Field(int width, int height) {
		this.width = width;
		this.height = height;
		field = new Unit[height][width];
	}
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	public void place(Unit o) {
		int x = o.GetX();
		int y = o.GetY();
		field[x][y] = o;		
	}
		
	public Unit[] See(Unit o)
	{
		int x = o.GetX();
		int y = o.GetY();
		ArrayList<Unit> list = new ArrayList<Unit>();
		for ( int i=-1; i<2; i++ ) {
			for ( int j=-1; j<2; j++ ) {
				int r = x+i;
				int c = y+j;
				if ( r >-1 && r<height && c>-1 && c<width && !(r== x && c == y) ) {
					list.add(field[r][c]);
				}
			}
		}
		return list.toArray(new Unit[list.size()]);
	}

	
	public void clear() {
		for ( int i=0; i<height; i++ ) {
			for ( int j=0; j<width; j++ ) {
				field[i][j] = null;
			}
		}
	}
}
