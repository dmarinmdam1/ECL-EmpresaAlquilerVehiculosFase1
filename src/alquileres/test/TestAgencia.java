

package alquileres.test;


import java.util.Map;
import java.util.Set;

import alquileres.modelo.AgenciaAlquiler;
import alquileres.modelo.Coche;
import alquileres.modelo.Furgoneta;


/**
 * @author Daniel Marín Martos
 */

public class TestAgencia
{
	private AgenciaAlquiler agencia;
	
	
	public TestAgencia(String nombre)
	{
		agencia = new AgenciaAlquiler(nombre);
		agencia.cargarFlota();
		
		System.out.println(agencia.toString());
		
		hacerPausa();
	}

	
	public void testBuscarCoches()
	{
		int dias = 7;
		
		System.out.println("Coches de alquiler en la agencia");
		System.out.println(agencia.buscarCoches(dias));
		System.out.println();
		
		hacerPausa();
	}

	
	public void testCochesOrdenadosMatricula()
	{
		System.out.println("Coches de más de 4 plazas ordenados por matrícula (de < a >)\n");
		
		for (Coche coche : agencia.cochesOrdenadosMatricula())
		{
			System.out.println(coche.toString());
			System.out.print("-----------------------------------------------------");
			System.out.println("\n");
		}
		
		hacerPausa();
	}

	
	public void testFurgonetasOrdenadasPorVolumen()
	{
		System.out.println("Furgonetas ordenadas de mayor a menor volumen\n");

		for (Furgoneta furgoneta : agencia.furgonetasOrdenadasPorVolumen())
		{
			System.out.println(furgoneta.toString());
			System.out.println("-----------------------------------------------------\n");
		}
		
		hacerPausa();
	}

	
	public void testMarcasConModelos()
	{
		System.out.println("Marcas y modelos de vehículos por marca\n");
		
		Map<String, Set<String>> marcasModelos = agencia.marcasConModelos();
		
		for (Map.Entry<String, Set<String>> entrada : marcasModelos.entrySet())
		{
			System.out.println("Marca: " + entrada.getKey() + "\n       Modelos : " + entrada.getValue());
		}
	}

	
	public void hacerPausa()
	{
		@SuppressWarnings("resource")
		
		java.util.Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.println("Pulsar <intro> para continuar");
		
		teclado.nextLine();
	}

	
	public static void main(String[] args)
	{
		if(args.length != 1)
		{
			System.out.println("Error en nº argumentos");
			System.out.println("Sintaxis: java TestAgencia <nombre-agencia>\n");
			
			System.out.println("-----------------------------------------------------\n");
			
			TestAgencia test = new TestAgencia("Rent-A-Car");
	
			test.testBuscarCoches();
			test.testCochesOrdenadosMatricula();
			test.testFurgonetasOrdenadasPorVolumen();
	
			test.testMarcasConModelos();
		}
		else
		{
			TestAgencia test = new TestAgencia(args[0]);
			
			test.testBuscarCoches();
			test.testCochesOrdenadosMatricula();
			test.testFurgonetasOrdenadasPorVolumen();
	
			test.testMarcasConModelos();
		}
	}
}

