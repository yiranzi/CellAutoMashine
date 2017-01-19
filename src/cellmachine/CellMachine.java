package cellmachine;

import java.util.ArrayList;

import javax.swing.JFrame;

import com.sun.javafx.print.Units;

import animal.Animals;
import animal.Live;
import animal.People;
import cell.Cell;
import cell.Unit;
import field.Field;
import field.View;
import item.Item;

public class CellMachine {
	private static final String AnimalList = null;

	public static void main(String[] args) {
		int size = 30;
		int iType = 1;
		ArrayList<Unit> unitList = new ArrayList<Unit>();
		ArrayList<Live> liveList = new ArrayList<Live>();
		Cell[] cellList = new Cell[size * size];
		//初始化存储位置的field
		Field field = new Field(size,size);
		//初始化所有的生物
		People person = new People(15,15);
		unitList.add(person);
		field.place(person);
		Item stone = new Item(20,20);
		unitList.add(stone);
		field.place(stone);

		//拿到所有的生物
		for(Unit units : unitList)
		{
			System.out.println(units instanceof Live);
			if(units instanceof Live)
			{
				liveList.add((Live)units);
			}
		}
		
		//给生物的状态做初始化
		for(Live lives : liveList)
		{
			lives.reborn();
		}
	
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
		for ( int i=0; i<1000; i++ ) {
			//人的回合
			for(Live lives : liveList)
			{
				if(count<50)lives.move('r');
				else if(count<100)lives.move('l');
				else count =-1;
			}
			count++;
			System.out.println("UPDATE");
			frame.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}



}
