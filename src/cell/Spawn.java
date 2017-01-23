package cell;

import java.util.ArrayList;

import animal.People;

public class Spawn {
	//检测是否有这类的已经死亡的
		public ArrayList<Unit> unitList;
		public ArrayList<Unit> deadList;

		public Spawn(ArrayList<Unit> unitList2,ArrayList<Unit> deadList2)
		{
			unitList = unitList2;
			deadList = deadList2;
		}
		
		//记录并保存编号
		public int Add(Unit unit) {
			// TODO Auto-generated method stub
			unitList.add(unit);
			return unitList.size();
		}
		
		public void delete(Unit unit) {
			// TODO Auto-generated method stub
			deadList.add(unit);
		}
			
		public Unit CheckSpawn(Unit unit)
		{
			int pos = deadList.indexOf(unit);
			if(pos ==- 1)
			{
				//自己生成
				unit = null;
			}
			else
			{
				unit = deadList.get(pos);
				deadList.remove(pos);
			}
			return unit;
//			
//			Unit unit = null;
//			if(deadList.isEmpty())
//			{
//				//自己生成
//			}
//			else
//			{
//				unit = deadList.get(0);
//				deadList.remove(0);
//			}
//			return unit;
		}
		
//		public void ReSpawn(int x,int y)
//		{
//
//		}
//		
//		
//		private void reborn()
//		{
//
//		}


}
