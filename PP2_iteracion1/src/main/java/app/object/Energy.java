package app.object;

public class Energy {
	
	Integer valor;
	
	public Energy(Integer val)
	{
		this.valor = val;
		validarEnergy();
	}
	
	public void subirEnergy()
	{
		this.valor +=1;
		validarEnergy();
	}
	
	public void bajarEnergy()
	{
		this.valor -=1;
		validarEnergy();
	}
	
	private void validarEnergy()
	{
		if (this.valor < 0)
		{
			this.valor = 0;
		}
		else if(this.valor > 3)
		{
			this.valor = 3;
		}
	}
	
	public String toString()
	{
		return this.valor.toString();
	}
	public Integer getValor()
	{
		return this.valor;
	}

	public static void main(String[] args) {
		

	}

}
