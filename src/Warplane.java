
public abstract class Warplane extends GameMovableElementAdapter
{
	private long last=0;
	private int wait=3000;
	
	public Warplane(String ref, int x, int y) 
	{
		super(ref, x, y,5);	
		this.StartMoving();
		this.setSpeedX(1);
		this.setSpeedY(1);
		this.setLeftDirection();

		this.setWaitTime(1000);
	}
	
	@Override
	public void Step()
	{
		super.Step();
		this.nextImage();
		if(wait+last < System.currentTimeMillis() && this.getX()<GameConstants.Game_Width)
		{
			this.Fire();
			last=System.currentTimeMillis();
		}		
	}
	
	@Override
	public void CollideWith(GameElementAdapter element)
	{
		if (element instanceof Bullet1)  //       || instance of explosion 
			return;
		else if (element instanceof Ammunition)
			this.Destroy();
	}
	
	@Override
	protected void CollideLeftBorder()
	{
		super.CollideLeftBorder();
		this.Destroy();
	}
	
	@Override
	protected void CollideUpBorder()
	{
		super.CollideLeftBorder();
//		this.setSpeedX(0);
		this.setDownDirection();
	}
	@Override
	protected void CollideDownBorder()
	{
		super.CollideLeftBorder();
//		this.setSpeedX(0);
		this.setUpDirection();
	}


	private void Fire()
	{			
		// Create new Bullet and shoot up from Right and Left
		Ammunition b=new Bullet1(0 , 0);
		b.setXY(this.getX()-10 , this.getY()+35);
		b.setSpeedX(4);
		b.setLeftDirection();
		GGame.addNewEntity(b);
		SoundStore.get().Play(Sounds.Fire);
	}		
}
