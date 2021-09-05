package TurismoenlaTierraMedia;

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
	// Abro archivos Atracciones

	public static LinkedList<Atracciones> getAtracciones(String archivo) {

		LinkedList<Atracciones> atracciones = new LinkedList<Atracciones>();

		Scanner sc = null;

		try {

			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {

				// Leo cada linea del archivo
				String linea = sc.nextLine();
				String datosAtracciones[] = linea.split(",");
				String nombreAtraccion = String.valueOf(datosAtracciones[0]);
				int costo = Integer.parseInt(datosAtracciones[1]);
				double tiempoAtraccion = Double.parseDouble(datosAtracciones[2]);
				int cupos = Integer.parseInt(datosAtracciones[3]);
				TipoAtraccion tipo = TipoAtraccion.valueOf(datosAtracciones[4]);

				Atracciones atraccion = new Atracciones(nombreAtraccion, costo, tiempoAtraccion, cupos, tipo);

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

	public static void escribirCompras(String nombre, double tiempoTotal, int dineroTotal, List<Atracciones> atraccion,
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

		// Escribe el pie con los totales de tiempo y dinero

		salida.println("---------------------------------------------");
		salida.println("Su gasto total es de " + dineroTotal + " monedas");
		salida.println("Su tiempo de permanencia " + tiempoTotal + " horas");

		//

		salida.close();

	}

	// PRUEBO DEVOLVER ATRACCIONES QUE LE GUSTAN

	public static List<Atracciones> getMeGustan(List<Atracciones> atracciones, TipoAtraccion tipo) {

		List<Atracciones> queMeGustan = new ArrayList<Atracciones>();

		for (Atracciones ca : atracciones)
			if (ca.getTipoDeAtraccion() == tipo)
				queMeGustan.add(ca);

		for (Atracciones ca : atracciones)
			if (ca.getTipoDeAtraccion() != tipo)
				queMeGustan.add(ca);

		return queMeGustan;
	}

	// -----------------------
	// Abro archivo Promociones y creo Lista

	public static LinkedList<Producto> getProductos(String archivo) {

		LinkedList<Producto> productos = new LinkedList<Producto>();
		Scanner sc = null;

		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {

				// Leo cada linea del archivo
				String linea = sc.nextLine();
				String[] datosPromo = linea.split(",");

				String tipo = String.valueOf(datosPromo[0]);

				Producto promo = null;
				Atracciones[] atracIncluidas = null;

				// Agrega al array de atracciones aquellas incluidas en la Promo
				for (int i = 1; i < datosPromo.length - 1; i++) {
					atracIncluidas[i] = obtenerAtraccion(datosPromo[i]);
				}

				if (tipo.equalsIgnoreCase("Por")) {
					/*
					 * PromoPorcentual la creo mandando el array atracciones en primer parametro y
					 * el dato del porcentaje de descuento como segundo
					 */
					promo = new PromoPorcentaje(atracIncluidas,
							(double) Integer.parseInt(datosPromo[datosPromo.length - 1]));
				} else if (tipo.equalsIgnoreCase("AxB")) {
					/*
					 * PromoPorcentual la creo mandando el array atracciones en primer parametro y
					 * la atraccion que es gratuita en segundo
					 */
					promo = new PromoAxB(atracIncluidas, obtenerAtraccion(datosPromo[datosPromo.length - 1]));
				} else if (tipo.equalsIgnoreCase("Abs")) {
					/*
					 * PromoPorcentual la creo mandando el array atracciones en primer parametro y
					 * el dato del costo final obtenido del archivo
					 */
					promo = new PromoAbsoluta(atracIncluidas,
							(double) Integer.parseInt(datosPromo[datosPromo.length - 1]));
				}

				// Agrego la promo a la lista de productos
				productos.add(promo);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// cierro archivo
		sc.close();

		return productos;
	}

	// Obtiene el objeto Atraccion a partir del String "nombreAtraccion" del archivo
	// promociones
	private static Atracciones obtenerAtraccion(String nombreAtraccion) {
		Atracciones atraccion = null;

		// obtengo la lista a iterar
		LinkedList<Atracciones> lista = Sistema.getAtracciones("atracciones.in");

		// creo el objeto Iterator para recorrer la lista de Atracciones
		Iterator<Atracciones> atracIterar = lista.iterator();

		while (atracIterar.hasNext()) {
			Atracciones atrac = atracIterar.next();

			// si el nombre pasado como parametro coincide con el del iterador
			// devuelvo esa atraccion
			if (nombreAtraccion.equalsIgnoreCase(atrac.nombreAtraccion)) {
				atraccion = atrac;
			}
		}
		return atraccion;
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