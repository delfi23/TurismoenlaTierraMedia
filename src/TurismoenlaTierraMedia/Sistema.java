package turismoenlatierramedia;

import java.io.*;
import java.util.*;


public class Sistema {

	// Se crea la lista de Usuarios

	public static LinkedList<Usuario> getUsuario(String archivo) {

		LinkedList<Usuario> usuario = new LinkedList<Usuario>();

		Scanner sc = null;

		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {

				// Leo cada linea del archivo
				String linea = sc.nextLine();
				String datosDeUsuario[] = linea.split(",");

				// Creo un Usuario a partir de los datos leidos

				String nombre = String.valueOf(datosDeUsuario[0]);
				int dinero = Integer.parseInt(datosDeUsuario[1]);
				double tiempo = Double.parseDouble(datosDeUsuario[2]);
				TipoAtraccion prefe = TipoAtraccion.valueOf(datosDeUsuario[3]);

				Usuario nuevoUsuario = new Usuario(nombre, dinero, tiempo, prefe);

				// Agrego el usuario a la lista
				usuario.add(nuevoUsuario);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// cierro archivo
		sc.close();

		return usuario;
	}
	// -------------------------------------------------
	// Abro archivos Promociones

	public static LinkedList<Atracciones> getAtracciones(String archivo) {

		LinkedList<Atracciones> atracciones = new LinkedList<Atracciones>();

		Scanner sc = null;

		try {

			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {

				// Leo cada linea del archivo
				String linea = sc.nextLine();
				String datosPromociones[] = linea.split(",");
				String nombreAtraccion = String.valueOf(datosPromociones[0]);
				int costo = Integer.parseInt(datosPromociones[1]);
				double tiempoAtraccion = Double.parseDouble(datosPromociones[2]);
				int cupos = Integer.parseInt(datosPromociones[3]);
				TipoAtraccion prefe2 = TipoAtraccion.valueOf(datosPromociones[4]);

				Atracciones atraccion = new Atracciones(nombreAtraccion, costo, tiempoAtraccion, cupos, prefe2);

				// Agrego las atracciones a la lista

				atracciones.add(atraccion);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// cierro archivo
		sc.close();

		return atracciones;
	}

	// ---------------------------------------
	// ORDENAR ATRACCIONES X COSTO
	public static void ordenarCosto(List<Atracciones> atraccion) {
		Collections.sort(atraccion, new AtraccionesOrdenadasPrecio());
	}

	// --------------------
	// GRABAR COMPRAS
	

	
	public static void escribirCompras(String nombre,double tiempoTotal, int dineroTotal, List<Atracciones> atraccion,
			String file)

			throws IOException {

		// Se crea el printwriter
		PrintWriter salida = new PrintWriter(new FileWriter(file));

		// Escribe un encabezado con el nombre

		salida.println("Gracias : " + nombre + " por visitar Tierra Media");
		salida.println("---------------------------------------------");
		salida.println("Sus atracciones compradas son : ");
		salida.println("---------------------------------------------");

		// recorre la lista de compras que genero el usuario
		for (Atracciones compra : atraccion) {
			
			salida.println(compra.getNombreAtraccion());

			
		}
		
		//Escribe el pie con los totales de tiempo y dinero
			
		salida.println("---------------------------------------------");
		salida.println("Su gasto total es de "+dineroTotal+" monedas");
		salida.println("Su tiempo de permanencia "+tiempoTotal+" horas");
		
		//
		
		salida.close();

	}
	
	
	// PRUEBO DEVOLVER ATRACCIONES QUE LE GUSTAN
	
	public static List<Atracciones> getMeGustan (List<Atracciones> atracciones, TipoDeAtraccion tipo){
		
		List <Atracciones> queMeGustan = new ArrayList <Atracciones>();
		
		for(Atracciones ca : atracciones)
			if (ca.getTipoDeAtraccion() == tipo)
				 queMeGustan.add(ca);
		
		for(Atracciones ca : atracciones)
			if (ca.getTipoDeAtraccion() != tipo)
				 queMeGustan.add(ca);
		
		return queMeGustan;
	}
	

	// sugerir la compra de promociones segun sus gustos

	// si compra actualizar saldo de dinero y tiempo

	// actualizar atracciones las que ya fueron compradas

	// abrir archivo de atracciones

	// sugerir atracciones

	// //si compra actualizar saldo de dinero y tiempo

	// actualizar atracciones las que ya fueron compradas

	// mostrar el resto de promociones que no son
	// de su gusto.

}