

package alquileres.modelo;


import java.lang.StringBuilder;


/**
 * @author Daniel Marín Martos
 */

public abstract class Vehiculo implements Comparable <Vehiculo>
{
	private String matricula;
	private String marca;
	private String modelo;
	private double precioDia;

	
	public Vehiculo(String matricula, String marca, String modelo, double precioDia)
	{
		this.matricula = matricula.toUpperCase();
		this.marca = marca.toUpperCase();
		this.modelo = modelo.toUpperCase();
		this.precioDia = precioDia;
	}


	public String getMatricula()
	{
		return matricula;
	}


	public String getMarca()
	{
		return marca;
	}

	
	public String getModelo()
	{
		return modelo;
	}


	public double getPrecioDia()
	{
		return precioDia;
	}
	
	
	public abstract double calcularPrecioAlquiler(int diasDeAlquiler);
	
	
	public int compareTo(Vehiculo vehiculo)
	{
		return this.getMatricula().compareTo(vehiculo.getMatricula());
	}
	
	
	public boolean equals(Object object)
	{
		if (object == null) return false;
		if (object == this) return true;
		if (object.getClass() != this.getClass()) return false;

		Vehiculo vehiculo = (Vehiculo) object;
		
		return vehiculo.getMatricula().equals(this.getMatricula());
	}
	
	
	@Override
	public int hashCode()
	{
		return matricula.hashCode() * 13;
	}
	
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(getClass().getSimpleName().toUpperCase()).append("\n");
		
		sb.append("Matrícula: ").append(getMatricula()).append(" | ");
		sb.append("Marca: ").append(getMarca()).append(" | ");
		sb.append("Modelo: ").append(getModelo()).append("\n");
		
		sb.append("Precio día alquiler: ").append(getPrecioDia()).append("€ | ");
		
		return sb.toString();
	}
}
