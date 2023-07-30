public abstract class Levels
{
	public static final int	FinalLevel	=5;
	
	public static void SetLevel(GGame game , int level)
	{
		if (level==1)
		{
			// configuration of Level 1
			PlayerInfo p=new PlayerInfo();
			p.setLives(3);
			p.setFires(10);
			p.setScore(0);
			p.setPlayerName("Amir Hasan");
			p.setCurrentLevel(1);
			
			game.setPlayerInfo(p);
			LoadMap(game , 1);
		}
		
		else if (level<=FinalLevel)
		{
			PlayerInfo p=game.getPlayerInfo();
			p.setCurrentLevel(p.getCurrentLevel()+1);
			game.setPlayerInfo(p);
			LoadMap(game , level);
		}
		
	}
	
	private static void LoadMap(GGame game , int level)
	{
		if (level==1)
			LoadMap1(game);
	}
	
	
	
	private static void LoadMap1(GGame game)
	{
		game.clearEntities();
		// Static parts
		game.setNextEntity(new GBackground(0 , 0 , 0));
		game.setNextEntity(new Jimbo(50 , 400));
		game.setNextEntity(new silver_coin(200 , 400));
		game.setNextEntity(new gold(300 , 400));
		
		game.setNextEntity(new BigPipe(700, 285));
		game.setNextEntity(new BigPipeDown(900, 0));
			
		
		game.setNextEntity(new BigPipe(1200, 285));
		game.setNextEntity(new SmallPipeDown(1200, 0));
		game.setNextEntity(new BigPipeDown(1600, 0));
		game.setNextEntity(new SmallPipe(1600, 430));
		game.setNextEntity(new Yellow(2200, 430));
		game.setNextEntity(new Red(2200, 20));
		
		game.setNextEntity(new BigPipe(2500, 285));
		game.setNextEntity(new BigPipeDown(2800, 0));

		
		game.setNextEntity(new Yellow(3100, 430));
		game.setNextEntity(new Red(3100, 20));

		game.setNextEntity(new Yellow(4000, 430));
		game.setNextEntity(new Red(4000, 20));
	
	}
	
}
