package app.levels;

public class ManagerLevelGameDefault extends ManagerLevelGame
{
	public ManagerLevelGameDefault() 
	{
		this.setNext(this);
	}
	
	@Override
	public DataLevelGame getDataLevelGame() 
	{
		return new DataLevelGame();
	}

}
