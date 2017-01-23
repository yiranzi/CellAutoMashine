package animal;

import java.util.ArrayList;

import cell.Cell;
import cell.Location;
import cell.Unit;
import item.Item;

public class Animals extends Unit implements Live  {
	protected boolean alive = false;
	//protected Unit[] arounds = new Unit[8];

	public int age;
	protected int ageLimit = 7;
	
	public static void ReBoren(Animals o,int x,int y) {
		// TODO Auto-generated method stub
		o.posX = x;
		o.posY = y;
		o.visible = true;
		o.alive = true;
		o.age = 0;
		field.place(o);
	}
	public Animals(int x, int y) {
		super(x, y);
		this.alive = true;
		this.age = 0;
		// TODO Auto-generated constructor stub
	}
	
	public Animals()
	{
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		//System.out.println("siwangP:" + this.GetX() + "/" +this.GetY());
		this.alive = false;
		this.RemoveOut();
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return alive;
	}

	@Override
	public void move(char dir) {
		// TODO Auto-generated method stub
		switch(dir){
		case 'r':
			posX ++;
			break;
		case 'l':
			posX --;
			break;
		case 't':
			posY ++;
			break;
		case 'b':
			posY --;
			break;		
		}
		
	}
	
	@Override
	public ArrayList<Cell> see() {
		return field.See(this);
//		int number = 0;
//		for(Unit u : this.unitArounds)
//		{
//			if(u instanceof Item)
//			{
//				number ++;
//			}
//		}
//		return number;
	}

	@Override
	public void action() {
		ArrayList<Cell> unitArounds = new ArrayList<Cell>();	
		ArrayList<Cell> cellArounds = new ArrayList<Cell>();	
		//int actionTime = 1;
		AgeAdd();
		if(alive)
		{
			unitArounds = this.see();
			cellArounds = GetEmpty(unitArounds);
			if(Math.random()<0.5)
			{			
				Cell c =feed(cellArounds);
				
			}	
			else
			{
			}	
			unitArounds = this.see();
			cellArounds = GetEmpty(unitArounds);
			Cell c =Walk(cellArounds);		
		}
		OldDead();

	}

	protected double getAgePercent() {
		return (double)age/ageLimit;
	}
	@Override
	public Cell feed(ArrayList<Cell> cellArounds) {
		// TODO Auto-generated method stub
		if(cellArounds.isEmpty())return null;
		Cell cell1 = null;
		if(this.age>3 && Math.random()>0.2 && (spawn.unitList.size() - spawn.deadList.size())<100000)
		{	
			int a = ((int)(Math.random()*cellArounds.size()));
			cell1 = cellArounds.get(a);		
		}
		return cell1;
	}
	
	public Cell Walk(ArrayList<Cell> cellArounds) {
		// TODO Auto-generated method stub
		if(cellArounds.isEmpty())return null;
		Cell cell1 = null;
		int a = ((int)(Math.random()*cellArounds.size()));
		//System.out.println(cellArounds);
		//System.out.println("hehe" +cellArounds.size()+"//"+cellArounds.get(0).GetX()+"//"+cellArounds.get(0).GetY());
		cell1 = cellArounds.get(a);		
		return cell1;
//		if(cell1!=null)
//		{
//			//Walk
//		}
	}

	@Override
	public ArrayList<Cell> GetEmpty(ArrayList<Cell> unitAround) {
		// TODO Auto-generated method stub
		ArrayList<Cell> c = new ArrayList<Cell>();
		for(Cell cell2:unitAround)
		{
			if(cell2 instanceof Location)
			{
				c.add(cell2);
			}
		}
		return c;
	}

	@Override
	public int AgeAdd() {
		// TODO Auto-generated method stub
		return this.age++;
	}

	@Override
	public void OldDead() {
		// TODO Auto-generated method stub
		if(this.age>=ageLimit)
		{
			this.die();
		}
	}


}
