public class Bullet extends Ammunition
{

	
	public Bullet(int x , int y)
	{
		super("Images/Bullet0.png", x , y ,1);
		this.setNeededScore(0);
	}
	public void CollideWith(GameElementAdapter element)
	{		
		if (element instanceof Coin)
			return;		
	}

	
}
