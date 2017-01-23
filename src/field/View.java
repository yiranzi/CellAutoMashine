package field;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import animal.Animals;
import cell.Cell;

public class View extends JPanel {
	private static final long serialVersionUID = -5258995676212660595L;
	private static final int GRID_SIZE = 16;
	private int countX;
	private int countY;
	private Cell[] SomeCells;	
	private boolean b = false;

	public View(Cell[] cellList,int widthnumber,int heightNumber)
	{
		this.SomeCells = cellList;
		countX = widthnumber;
		countY = heightNumber;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(!b)
		{
			for ( int row = 0; row<countX; row++ ) {
				for ( int col = 0; col<countY; col++ ) 
				{
					//cell.draw(g, col*GRID_SIZE, row*GRID_SIZE, GRID_SIZE);
					g.drawRect(col*GRID_SIZE, row*GRID_SIZE, GRID_SIZE, GRID_SIZE);
				}
			}
			b =true;
		}
		for(Cell cell:SomeCells)
		{
			if(cell!=null && cell.GetVisible())
			cell.draw(g, cell.GetX()*GRID_SIZE, cell.GetY()*GRID_SIZE, GRID_SIZE);
		}


	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(countX*GRID_SIZE+1, countY*GRID_SIZE+1);
	}
//	@Override
//	public Dimension getPreferredSize() {
//		return new Dimension(theField.getWidth()*GRID_SIZE+1, theField.getHeight()*GRID_SIZE+1);
//	}

	public static void main(String[] args) {
//		Field field = new Field(10,10);
//		for ( int row = 0; row<field.getHeight(); row++ ) {
//			for ( int col = 0; col<field.getWidth(); col++ ) {
//				//field.place(row, col, new Cell());
//			}
//		}
//		//View view = new View(field);
//		JFrame frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setResizable(false);
//		frame.setTitle("Cells");
//		frame.add(view);
//		frame.pack();
//		frame.setVisible(true);
	}

}
