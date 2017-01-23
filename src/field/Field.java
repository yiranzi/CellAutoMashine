package field;

import java.util.ArrayList;

import cell.Cell;
import cell.Location;
import cell.Unit;

public class Field {
	private int width;
	private int height;
	private Cell[][] field;
	private Location[][] location;
	
	public Field(int width, int height) {
		this.width = width;
		this.height = height;
		field = new Cell[width][height];
		location = new Location[width][height];
		for(int i = 0;i<width;i++)
		{
			for(int j = 0;j<height;j++)
			{
				location[i][j] = new Location(i,j);
			}
		}
	}
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	public void place(Unit o) {
		int x = o.GetX();
		int y = o.GetY();
		field[x][y] = o;		
	}
		
	public void delete(Unit unit) {
		// TODO Auto-generated method stub
		int x = unit.GetX();
		int y = unit.GetY();
		field[x][y] = null;		
	}
	
	public void move(Cell From,Cell To) {
		// TODO Auto-generated method stub
		int x1 = From.GetX();
		int y1 = From.GetY();
		int x2 = To.GetX();
		int y2 = To.GetY();
		if(field[x2][y2]!=null)
		{
			return;
		}
		field[x2][y2] = field[x1][y1];	
		field[x1][y1] = null; 
	}
	
	public ArrayList<Cell> See(Unit o)
	{
		int x = o.GetX();
		int y = o.GetY();
		ArrayList<Cell> list = new ArrayList<Cell>();
		for ( int i=-1; i<2; i++ ) {
			for ( int j=-1; j<2; j++ ) {
				int r = x+i;
				int c = y+j;
				if ( r >-1 && r<height && c>-1 && c<width && !(r== x && c == y) ) {
					if(field[r][c] == null)
					{
						list.add(location[r][c]);
					}
					else list.add(field[r][c]);
				}
			}
		}
		return list;
		//return list.toArray(new Unit[list.size()]);
	}

	
	public void clear() {
		for ( int i=0; i<height; i++ ) {
			for ( int j=0; j<width; j++ ) {
				field[i][j] = null;
				location[i][j] = null;
			}
		}
	}

}
