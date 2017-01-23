package cellmachine;

import java.util.ArrayList;

import javax.swing.JFrame;

import com.sun.javafx.print.Units;

import animal.Animals;
import animal.Live;
import animal.People;
import cell.Cell;
import cell.Spawn;
import cell.Unit;
import field.Field;
import field.View;
import item.Item;

public class CellMachine {
	static ArrayList<Unit> unitList = new ArrayList<Unit>();
	static ArrayList<Unit> deadList = new ArrayList<Unit>();
	static ArrayList<Live> liveList = new ArrayList<Live>();
	
	public static void UpdataList()
	{
		liveList = new ArrayList<Live>();
		//拿到所有的生物
		for(Unit units : unitList)
		{

			if(units instanceof Live && ((Live)units).isAlive() )
			{
				
				liveList.add((Live)units);
			}
		}
	}
	public static void main(String[] args) {
		int size = 70;
		
		Cell[] cellList = new Cell[size * size];
		//初始化存储位置的field
		Field field = new Field(size,size);
		//生成unit管理器
		Spawn unitSpawn = new Spawn(unitList,deadList);
		//传入unit
		Unit.InitField(field,unitSpawn);
		//初始化所有的生物
		People person = new People(size/2,size/2);
//		Item stone1 = new Item(0,0);
//		Item stone2 = new Item(1,0);
//		Item stone3 = new Item(2,0);
//		Item stone4 = new Item(0,1);
//		Item stone5 = new Item(2,1);
//		Item stone6 = new Item(0,2);
//		Item stone7 = new Item(1,2);
//		Item stone8 = new Item(2,2);

		UpdataList();
		//给生物的状态做初始化
//		for(Live lives : liveList)
//		{
//			lives.reborn();
//		}
	
		//关联上图形界面
		View view = new View(cellList,size,size);
		//更新图像数据
		unitList.toArray(cellList);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Cells");
		frame.add(view);
		frame.pack();
		frame.setVisible(true);
		
		//进行周期处理
		
		int count = 0;
		for ( int i=0; i<1000000; i++ ) {	
			//People.myNew(size/2,size/2);
			count++;
			System.out.println("第几轮" +count +"轮");
			//人的回合
			UpdataList();
//			if((i+1) % 100 ==0)
//			{
//				if(unitList.size()<900)
//				{
//					People.myNew(0, 0);
//					People.myNew(29, 0);
//				}
//				else
//				{
//					People.myNew(0, 0);
//					People.myNew(29, 0);
//				}
//			}
			for(Live live : liveList)
			//for(Unit units : unitList)
			{
				//如果是生物
				//if(units instanceof Live)
				//{
					//Live live= (Live)units;
					live.action();
//					//看
//					if(live.see()==0)
//					{
//						if(count<50)live.move('r');
//						else if(count<100)live.move('l');
//						else count =-1;
//					}
//					else
//					{
//						live.die();
//					}
					//运动	
				//}
			}
	
			unitList.toArray(cellList);
			System.out.println(liveList.size() + "/"+unitList.size() + "/" +deadList.size());
			UpdataList();
//			for(int k=0;k<liveList.size();k++)
//			{
//				int posx=((Animals)liveList.get(k)).GetX();
//				int posy=((Animals)liveList.get(k)).GetY();
//				int age=((Animals)liveList.get(k)).age;
//				System.out.println(age +" "+ "第"+k+"个: ("+posx+","+posy+")");
//			}
			frame.repaint();
			try {
//				if(unitList.size()>10000)
//				{
//					unitList.clear();
//					for(int k=0;i<cellList.length;i++)
//					{
//						cellList[k] = null;
//					}
//					
//					field.clear();
//				}
				if(unitList.size()>50000)
				{
					Thread.sleep(1000);
				}
				else Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}



}
