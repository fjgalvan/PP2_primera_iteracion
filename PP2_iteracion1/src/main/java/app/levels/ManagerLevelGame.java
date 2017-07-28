package app.levels;

public abstract class ManagerLevelGame 
{
	private ManagerLevelGame next;
	
	public abstract DataLevelGame getDataLevelGame();	
	
	public DataLevelGame buildDataGame()
	{
		DataLevelGame data = this.getDataLevelGame();
		if(data != null)
			return data;
		
		if (next!=null)
			return next.buildDataGame();
		else 
			return new ManagerLevelGameDefault().getDataLevelGame();
	}
	
	protected void setNext(ManagerLevelGame next)
	{
		this.next = next;
	}
}