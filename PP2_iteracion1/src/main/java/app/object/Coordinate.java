package app.object;

public class Coordinate {
	private double x;
	private double y;
	
	public Coordinate(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double getX() 
	{
		return x;
	}

	public void setX(double x) 
	{
		this.x = x;
	}

	public double getY() 
	{
		return y;
	}

	public void setY(double y) 
	{
		this.y = y;
	}
	
	public boolean validate(Size size)
	{
		return this.x>0 && this.y>0 && this.x<size.getAncho() && this.y<size.getAlto();
	}

	@Override
	public String toString() 
	{
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}
	
	
}
