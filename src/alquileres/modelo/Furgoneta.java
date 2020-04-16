

package alquileres.modelo;


/**
 * @author Daniel Marín Martos
 */

public class Furgoneta extends Vehiculo
{
	private double volumenDeCarga;
	
	
	public Furgoneta(String matricula, String marca, String modelo, double precioDia, double volumenDeCarga)
	{
		super(matricula, marca, modelo, precioDia);
		
		this.volumenDeCarga = volumenDeCarga;
	}


	public double getVolumenDeCarga() {
		return volumenDeCarga;
	}


	public void setVolumenDeCarga(double volumenDeCarga)
	{
		this.volumenDeCarga = volumenDeCarga;
	}
	

	public double calcularPrecioAlquiler(int diasDeAlquiler)
	{
		if(volumenDeCarga <   5) return (getPrecioDia() + 10) * diasDeAlquiler;
		if(volumenDeCarga <= 10) return (getPrecioDia() + 15) * diasDeAlquiler;
								 return (getPrecioDia() + 25) * diasDeAlquiler;
	}
	

	public String toString()
	{
		return super.toString() + "Volumen: " + volumenDeCarga + " (m3)";
	}
}

