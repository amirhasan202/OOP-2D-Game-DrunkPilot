import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Jimbo extends GameMovableElementAdapter
{	
	
	private  int ShoutwaitTime = 70;
	private long lastShoutTime;



	public Jimbo(int x , int y)
	{
		super("Images/Jimbo0.png" , x , y,5);
		this.setSpeedX(0);
		this.setSpeedY(1);
	}
	
	protected void goNextPoint()
	{
		// if you have EQUATION of MOVEMENT
		// have to override this method and put equation of movement here
		setpX(getX());
		setpY(getY());
		setRightDirection();
		setXY(getX()+getSpeedX() , getY()+getSpeedY());
	}
	
	public void Step()
	{
		super.Step(); // now it is empty
		this.goNextPoint();
		
	}

	protected void nextImage()//////// need to create 5 image for each airplane and change the name of image to class !!!
	{
		int i = 0 ,j=0;
		while (i < getNOP())
			if( lastShoutTime+ShoutwaitTime<System.currentTimeMillis())
			{
				j=(((j+1) % this.getNOP()));
				ChangeImage(getImage(j));
				lastShoutTime=System.currentTimeMillis();
				i++;
			}							
	}


	public void Reset()
	{
		this.setXY(2,400); // set to first status
	}
	
	
	private void Fire()
	{			
				// Create new Bullet and shoot up from Right and Left
			Ammunition b=AmmoFactory(GGame.getTotalFires());
			b.setXY(this.getX()+this.getWidth() , this.getY()+25);
			b.setRightDirection();
			GGame.addNewEntity(b);
			GGame.DecreaseFires(b.getNeededScore());
			SoundStore.get().Play(Sounds.Fire);
			this.nextImage();
			
	}
	
	private Ammunition AmmoFactory (int score)
	{
		Ammunition Ammo;
		if (score >= 200)
			Ammo= new Torpedo(0, 0);
		else if(score >=100)
			Ammo= new Rocket(0, 0);
		else 
			Ammo = new Bullet(0, 0);
		
		return Ammo;
	}
	
	public void CollideWith(GameElementAdapter element)
	{
		if (element instanceof Coin )
			GGame.IncreaseFires(((Coin) element).getScore());
	}
	
	protected void CollideDownBorder()
	{
		super.CollideDownBorder();
		GGame.DecreaseLive();
		this.Reset();
	}

	
	
	// need to get Key Events
	public boolean WantKeyEvents()
	{
		return true;
	}
		
	public void KeyPressed(KeyEvent e)
	{		
		if (e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			Fire();
			//this.setShooting(true);
		}
		
		if (e.getKeyCode()==KeyEvent.VK_UP)			
				setUpDirection();			
		
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
			setDownDirection();
		
	}
	
	public void KeyReleased(KeyEvent e)
	{
		if (e.getKeyCode()==KeyEvent.VK_UP)		
				setDownDirection();
		
	}
	
	public boolean WantMouseEvents()
	{
		return true;
	}
	
	public void mousePressed(MouseEvent e)
	{
			this.setUpDirection();
	}
	
	public void mouseReleased(MouseEvent e)
	{
			this.setDownDirection();
	}

	public void mouseWheelMoved(MouseWheelEvent e)
	{
		this.Fire();
		
	}

	

	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}
	

}
