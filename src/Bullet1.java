
public class Bullet1 extends Ammunition 
{

	public Bullet1(int x, int y) 
	{
		super("Images/Bullet1.png", x, y, 1);
		this.setNeededScore(0);
	}
	public void CollideWith(GameElementAdapter element)
	{		
		if (element instanceof Coin)
			return;		
	}


}
