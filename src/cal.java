
public class cal {

	
	
	private String[] Images=new String [5];
	private int cImage;
	public  void setImage()
	{
		int i=0;
		while (i<5)							
			this.Images[i++]="Images/"+this.getClass().getSimpleName()+(cImage++)+".png";

		
	}
	
	public String getImage(int i)
	{
		if (i<5)
			return this.Images[i];
		else 
			return null;
	}

	
	public static void main(String[] args) 
	{
		int i = 0 ;
		cal example = new cal();
		example.setImage();
		
		while(i<5)
		{
			System.out.println(""+example.getImage(i));
			i++;
		}
		
		
		
		
//		double y = 400;
//		for (int i = 0 ; i< 10 ; i++)
//		{
//			
//			double E = (1/-1*(Math.pow(x,2.0)));
//			
//			 y = y-(int)((Math.pow(2 , x)));////degree of movement
//			
//			 System.out.println("  X:"+x+"  Y:"+y);
//			x++;
//		}		
	
	}

}
