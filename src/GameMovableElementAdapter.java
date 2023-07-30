import java.awt.Graphics;

public abstract class GameMovableElementAdapter extends GameElementAdapter
{
	private int		pX , pY;	// Previous X,Y
	private int		speedX;	// Speed in X direction (Right or Left)
	private int		speedY;	// Speed in Y direction (Up or Down)
	private boolean	ismoving;	// Object is moving or static
	
	private String			Images[] ;///////
	private int				cImage		=0;/////
	private long			waitTime	=20;//////
	private long			lastTime	=0;/////
	private int 			NOP;
								
	public GameMovableElementAdapter(String ref , int x , int y, int NumberOfPhoto)
	{
		super(ref , x , y);
		this.speedX=0;
		this.speedY=0;
		this.ismoving=false;
		this.pX=getX();
		this.pY=getY();
		
		this.NOP=NumberOfPhoto;
//		System.out.println("NOP:"+NOP);
		this.Images=new String [this.NOP];
		this.setImage();/////
		
		SetLimits(0 , GameConstants.Game_Width-this.getWidth() , 0 ,
				GameConstants.Game_Height-this.getHeight());
	}
	
	public void Step()
	{
		super.Step(); // now it is empty
		goNextPoint();
	}
	
	
	protected void goNextPoint()
	{
		// if you have EQUATION of MOVEMENT
		// have to override this method and put equation of movement here
		if (ismoving)
		{
			pX=getX();
			pY=getY();
			setXY((int)(getX()+speedX) ,(int)(getY()+speedY));
		}
	}
	
	protected void goBack()
	{
		setXY(pX , pY);
	}
	
	public void setXY(int x , int y)
	{
		if (x<this.getminX())
			CollideLeftBorder();
		else if (x>this.getmaxX())
			CollideRightBorder();
		else if (y<this.getminY())
			CollideUpBorder();
		else if (y>this.getmaxY())
			CollideDownBorder();
		else
			super.setXY(x , y);
	}

	////////////////////////////////////////////////////////////////////////////////////////////// Photo Changing Part
	private void setImage()
	{
		int i=0;
		while (i<NOP)
		{
			String name ="Images/"+this.getClass().getSimpleName()+(cImage++)+".png";
			this.Images[i++]=name;
		}
		cImage=0;
	}

	protected String getImage(int i)
	{
		if (i<NOP)
			return this.Images[i];			
		else 
			return null;
	}

	protected void nextImage()//////// need to create 5 image for each airplane and change the name of image to class !!!
	{
			if (lastTime+waitTime<System.currentTimeMillis())
			{
				cImage=(cImage+1)%NOP;
				ChangeImage(getImage(cImage));
				lastTime=System.currentTimeMillis();
			}				
	}
	
	public void draw(Graphics g)
	{
			this.getSprite().draw(g , getX() , getY());
	}


////////////////////////////////////////////////////////////////////////////
	
	protected void CollideLeftBorder()
	{
		// you can do something in child classes
	}
	
	protected void CollideRightBorder()
	{
		// you can do something in child classes
	}
	
	protected void CollideUpBorder()
	{
		// you can do something in child classes
	}
	
	protected void CollideDownBorder()
	{
		// you can do something in child classes
	}
	
	protected void setRightDirection()
	{
		speedX=Math.abs(speedX);
	}
	
	protected void setLeftDirection()
	{
		speedX=-1*Math.abs(speedX);
	}
	
	protected void setUpDirection()
	{
		speedY=-1*Math.abs(speedY);
	}
	
	protected void setDownDirection()
	{
		speedY=Math.abs(speedY);
	}
	
	protected boolean isMoving()
	{
		return ismoving;
	}
	
	protected void StopMoving()
	{
		ismoving=false;
	}
	
	protected void StartMoving()
	{
		ismoving=true;
	}
	
	protected void setSpeedX(int newSpeedX)
	{
		speedX=Math.abs(newSpeedX);
	}
	
	protected void setSpeedY(int newSpeedY)
	{
		speedY=Math.abs(newSpeedY);
	}
	
	protected int getSpeedX()
	{
		return speedX;
	}
	
	protected int getSpeedY()
	{
		return speedY;
	}
	public int getpX() {
		return pX;
	}

	public void setpX(int pX) {
		this.pX = pX;
	}

	public int getpY() {
		return pY;
	}

	public void setpY(int pY) {
		this.pY = pY;
	}

	public int getNOP() {
		return NOP;
	}

	public void setNOP(int nOP) {
		NOP = nOP;
	}

	public long getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(long waitTime) {
		this.waitTime = waitTime;
	}

	public long getLastTime() {
		return lastTime;
	}

	public void setLastTime(long lastTime) {
		this.lastTime = lastTime;
	}

	public int getcImage() {
		return cImage;
	}

	public void setcImage(int cImage) {
		this.cImage = cImage;
	}


	
}
