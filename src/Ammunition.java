
public abstract class Ammunition extends GameMovableElementAdapter
{
	private long ExplosionDuring=5;
	private long LastExplosionTime=0;
	private boolean	 Explosion;///Explosion
	private long ImagelastTime =0;
	private int ImgewaitTime =1;
	private int cI;
	private int NeededScore=0; 

	
	

	public Ammunition(String ref ,int x , int y , int NumberOfPhotos)
	{
		super(ref , x , y, NumberOfPhotos);
		
		this.setSpeedX(1);
		this.setSpeedY(0);
		this.StartMoving();
		this.setWaitTime(5);
		this.setLastTime(0);
	}
	
	public void Step()
	{
		super.Step();
		
		while (this.Explosion && ImagelastTime+ImgewaitTime<System.currentTimeMillis())
		{			
			this.nextImage();
			this.setLeftDirection();
			ImagelastTime=System.currentTimeMillis();
		}	
	}
	
	@Override
	protected void nextImage()//////// need to create 5 image for each airplane and change the name of image to class !!!
	{				
		if (cI<this.getNOP())
			ChangeImage(this.getImage(cI++));		
	}
	
	public void CollideWith(GameElementAdapter element)
	{
		LastExplosionTime=System.currentTimeMillis();
		
		while (LastExplosionTime + ExplosionDuring > System.currentTimeMillis())
			this.Explosion = true;
		
		if (LastExplosionTime + ExplosionDuring < System.currentTimeMillis())
			this.Explosion = false;
		
		if (element instanceof Coin)
			return;	
	}


	
	protected void CollideLeftBorder()
	{
		this.Destroy();
	}
	
	protected void CollideRightBorder()
	{
		this.Destroy();
	}			
	
	
	public int getNeededScore() {
		return NeededScore;
	}

	public void setNeededScore(int neededScore) {
		NeededScore = neededScore;
	}

}
