

package alquileres.modelo;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.lang.StringBuilder;
import java.util.Iterator;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Collections;


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
		
		for(int i = 0; i < datosSeparados.length; i++)
		{
			datosSeparados[i] = datosSeparados[i].trim();
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
		StringBuilder sb = new StringBuilder();
		
		sb.append("Vehículos en alquiler de la agencia ").append(nombre).append("\n");
		sb.append("Total vehículos: ").append(flota.size()).append("\n\n");

		for(Vehiculo vehiculo : flota)
		{
			sb.append(vehiculo.toString()).append("\n");
			sb.append("-----------------------------------------------------\n");
		}
		
		return sb.toString();
	}

	
	public String buscarCoches(int diasAAlquilar)
	{
		StringBuilder sb = new StringBuilder();
		
		for(Vehiculo vehiculo: flota)
		{
			if(vehiculo instanceof Coche)
			{
				sb.append("\n").append(vehiculo.toString()).append("\n");
				sb.append("Coste alquiler ").append(diasAAlquilar).append(" días: ").append(vehiculo.calcularPrecioAlquiler(diasAAlquilar)).append("€").append("\n");
				sb.append("-----------------------------------------------------");
			}
		}
		
		return sb.toString();
	}

	
	public List<Coche> cochesOrdenadosMatricula()
	{
		ArrayList <Coche> retorno = new ArrayList<>();
		
		Iterator <Vehiculo> it = flota.iterator();
		
		while(it.hasNext())
		{
			Vehiculo vehiculo = it.next();
			
			if(vehiculo instanceof Coche)
			{
				if(((Coche) vehiculo).getPlazas() > 4)
				{
					retorno.add((Coche) vehiculo);
				}
			}
		}
		
		retorno.sort(Comparator.comparing(Coche::getMatricula));
		
		return retorno;
	}

	
	public List<Furgoneta> furgonetasOrdenadasPorVolumen()
	{
		ArrayList<Furgoneta> retorno = new ArrayList<>();
		
		Iterator<Vehiculo> it = flota.iterator();
		
		while(it.hasNext())
		{
			Vehiculo vehiculo = it.next();
			
			if(vehiculo instanceof Furgoneta)
			{
				retorno.add((Furgoneta) vehiculo);
			}
		}
		
		retorno.sort(Comparator.comparing(Furgoneta::getVolumenDeCarga));
		
		Collections.reverse(retorno);
		
		return retorno;
	}

	
	public Map<String, Set<String>> marcasConModelos()
	{
		TreeMap<String, Set<String>> retorno = new TreeMap<>();
		
		Iterator<Vehiculo> it = flota.iterator();
		
		while(it.hasNext())
		{
			Vehiculo vehiculo = it.next();
			
			String marca = vehiculo.getMarca();
			String modelo = vehiculo.getModelo();
			
			if(retorno.get(marca) == null)
			{
				TreeSet<String> nombres = new TreeSet<>();
				
				nombres.add(modelo);
				
				retorno.put(marca, nombres);
			}
			else
			{
				retorno.get(marca).add(modelo);
			}
		}
		
		return retorno;
	}
}

