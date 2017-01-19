package animal;

import cell.Unit;

public class Animals extends Unit implements Live  {
	protected boolean alive = false;
	
	public Animals(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	

	
	@Override
	public String toString()
	{
		return"Animals";
	}
	
	@Override
	public void reborn() {
		// TODO Auto-generated method stub
		alive = true;
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		alive = false;
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
			System.out.println("r");
			break;
		case 'l':
			posX --;
			System.out.println("l");
			break;
		}
		
	}



	@Override
	public boolean see() {
		
		return false;
	}


}
