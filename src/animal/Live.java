package animal;

public interface Live {
	public void reborn();
	public void die();
	
	public boolean isAlive();
	public void move(char dir);
	public boolean see();

}
