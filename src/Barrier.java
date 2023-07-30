
public abstract class Barrier extends GameMovableElementAdapter
{

	public Barrier(String ref, int x, int y) 
	{
		super(ref , x , y,1);
		
		this.setSpeedX(1);
		this.setSpeedY(0);
		this.setLeftDirection();
		this.StartMoving();
	}
		
	protected void CollideLeftBorder()
	{
		this.Destroy();
	}

	
	public void CollideWith(GameElementAdapter element)
	{
		if (element instanceof Jimbo)
		{
			GGame.DecreaseLive();
			this.Destroy();
			return;
		}
		else if(element instanceof Rocket || element instanceof Torpedo )
		{
			this.Destroy();
			return;
		}

	}

}
