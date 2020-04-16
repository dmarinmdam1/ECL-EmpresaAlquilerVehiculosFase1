

package alquileres.modelo;


/**
 * @author Daniel Marín Martos
 */

public class Coche extends Vehiculo
{
	private int plazas;
	

	public Coche(String matricula, String marca, String modelo, double precioDia, int plazas)
	{
		super(matricula, marca, modelo, precioDia);
		
		this.plazas = plazas;
	}


	public int getPlazas()
	{
		return plazas;
	}

	
	public void setPlazas(int plazas)
	{
		this.plazas = plazas;
	}
	

	public double calcularPrecioAlquiler(int diasDeAlquiler)
	{
		if(plazas > 4) return (this.getPrecioDia() + 5) * diasDeAlquiler;
		
		return diasDeAlquiler * this.getPrecioDia();
	}
	

	public String toString()
	{
		return super.toString() + "Plazas: " + plazas;
	}
}

