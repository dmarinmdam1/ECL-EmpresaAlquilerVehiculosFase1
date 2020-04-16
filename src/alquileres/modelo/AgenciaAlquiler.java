

package alquileres.modelo;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author Daniel Marín Martos
 */

public class AgenciaAlquiler
{
	private String nombre; // el nombre de la agencia
	private List<Vehiculo> flota; // la lista de vehÃ­culos

	
	public AgenciaAlquiler(String nombre)
	{
		this.nombre = nombre;
		this.flota = new ArrayList<>();
	}

	
	public void addVehiculo()
	{

	}

	
	private Vehiculo obtenerVehiculo()
	{
		return null;
	}

	
	public void cargarFlota()
	{
		String[] datos = Utilidades.obtenerLineasDatos();
		
		String error = null;
		
		try
		{
			for(String linea : datos)
			{
				error = linea;
				
				Vehiculo vehiculo = obtenerVehiculo(linea);
				
				this.addVehiculo(vehiculo);
			}
		}
		catch (Exception e)
		{
			System.out.println(error);
		}
	}

	
	@Override
	public String toString()
	{
		return null;
	}

	
	public String buscarCoches()
	{
		return null;
	}

	
	public List<Coche> cochesOrdenadosMatricula()
	{
		return null;
	}

	
	public List<Furgoneta> furgonetasOrdenadasPorVolumen()
	{
		return null;
	}

	
	public Map<String, Set<String>> marcasConModelos()
	{
		return null;
	}
}

