

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
	private String nombre;
	private List <Vehiculo> flota;

	
	public AgenciaAlquiler(String nombre)
	{
		this.nombre = nombre;
		this.flota = new ArrayList<>();
	}

	
	public void addVehiculo(Vehiculo vehiculo)
	{
		if(!flota.contains(vehiculo)) flota.add(vehiculo);
	}

	
	private Vehiculo obtenerVehiculo(String lineaDatos)
	{
		String[] datosSeparados = lineaDatos.split(",");
		
		for(String dato : datosSeparados)
		{
			dato = dato.trim();
		}
		
		if(datosSeparados[0].equalsIgnoreCase("F"))
		{
			return new Furgoneta(datosSeparados[1].toUpperCase(),
								 datosSeparados[2].toUpperCase(),
								 datosSeparados[3].toUpperCase(),
								 Double.parseDouble(datosSeparados[4]),
								 Double.parseDouble(datosSeparados[5]));
		}
		else
		{
			return new Coche(datosSeparados[1].toUpperCase(),
							 datosSeparados[2].toUpperCase(),
							 datosSeparados[3].toUpperCase(),
							 Double.parseDouble(datosSeparados[4]),
					         Integer.parseInt(datosSeparados[5]));
		}
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

