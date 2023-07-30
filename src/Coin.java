
public abstract class Coin extends GameMovableElementAdapter
{

	private int Score;
	

	public Coin(String ref, int x, int y, int NumberOfPhoto) 
	{
		super(ref, x, y, NumberOfPhoto);
		
		this.setSpeedX(1);
		this.setSpeedY(0);
		this.StartMoving();
		this.setLeftDirection();
		this.setWaitTime(20);
		this.setLastTime(0);

	}

	public void Step()
	{
		super.Step();
		this.nextImage();
	}

	@Override
	protected void nextImage()//////// need to create 5 image for each airplane and change the name of image to class !!!
	{		
		super.nextImage();
	}
	
	protected void CollideLeftBorder()
	{
		this.Destroy();
	}
				
	
	public void CollideWith(GameElementAdapter element)
	{
		if (element instanceof Jimbo)
			this.Destroy();	
		
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}


}
