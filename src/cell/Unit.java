package cell;

import java.awt.Graphics;
import java.util.ArrayList;

import animal.Animals;
import animal.People;
import field.Field;

public class Unit implements Cell{
	protected int posX;
	protected int posY;
	protected static Field field;
	
	public int number;//这个值在add的时候就定死了.
	protected boolean visible = false;
	
	protected static Spawn spawn;
	public static Unit deadU;
	
	public static void InitField(Field field2,Spawn spawn2)
	{
		// TODO Auto-generated method stub
		field = field2;
		spawn = spawn2;
	}
	
	public static void RePlace(Unit o,int x,int y) {
		// TODO Auto-generated method stub
		o.posX = x;
		o.posY = y;
		o.visible = true;
	}
	
	//这里面想传入一个类型.而不是对象.
	//public static void myNew(Unit units,int x,int y)
	//{
//		Unit unit = spawn.CheckSpawn(units);
//		if(unit!=null)
//		{
//			//reborn
//			unit.posX = x;
//			unit.posY = y;
//			unit.visible = true;
//		}
//		else
//		{
//			unit = new Unit(x,y);
//		}
	//}
		
	public Unit(int x,int y)
	{
		posX = x;
		posY = y;	
		visible = true;
		number = spawn.Add(this);
		field.place(this);
	}
	
	public Unit()
	{}
	
	//让外部清除绘制
	public void RemoveOut() {
		// TODO Auto-generated method stub
		//先死亡 死亡后之后的绘制变化
		this.visible = false;
		spawn.delete(this);
		field.delete(this);
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


	@Override
	public boolean GetVisible() {
		// TODO Auto-generated method stub
		return visible;
	}
	
}
