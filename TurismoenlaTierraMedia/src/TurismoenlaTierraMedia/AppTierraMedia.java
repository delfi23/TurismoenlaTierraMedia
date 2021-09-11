package TurismoenlaTierraMedia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AppTierraMedia {

	protected static double dineroTotal;
	protected static double tiempoTotal;

	public static void main(String[] args) throws IOException {

		List<Usuario> usuario = Sistema.getUsuario("usuarios.in");

		List<Atracciones> atracciones = Sistema.getAtracciones("atracciones.in");

		// Crea una lista tipo Producto con sólo las Promos
		List<Producto> promociones = Sistema.getPromociones("promociones.txt");

		// Crea una lista tipo Producto con todos los productos finales
		List<Producto> productosFinales = Sistema.getProductoFinal(promociones);

		Sistema.ordenarPromosPorPrecio(productosFinales);

		// ------------------------------------------------------------------------------------------------------

		for (Usuario user : usuario) {

			// se crean y setean contadores para guardar dinero y tiempo.
			dineroTotal = AppTierraMedia.setCosto(0.0);
			tiempoTotal = AppTierraMedia.setTiempo(0.0);

			LinkedList<Producto> misGustos = new LinkedList<Producto>();

			misGustos.addAll(Sistema.getProductosQueMeGustan(productosFinales, user.getPreferencia()));

			// SE CREA LISTA PARA GUARDAR ITINERARIO
			LinkedList<Atracciones> itinerario = new LinkedList<Atracciones>();

			System.out.println(user.getNombreDeUsuario() + " Bienvenido/a Tierra Media");
			System.out.println("------------------------------------");
			System.out.println("Tenemos las siguientes Sugerencias para vos!");

			// >>> PRIMERO TIENE QUE SUGERIR SEGUN SUS PREFERENCIAS
			// >>> LUEGO OTRAS OPCIONES

			// sugiere segun preferencias
			AppTierraMedia.sugerirProductos(user, misGustos, itinerario, dineroTotal, tiempoTotal);

			System.out.println(" ");
			System.out.println("LAS OFERTAS DE TIPO " + user.getPreferencia() + " SE NOS HAN ACABADO.");
			System.out.println("PERO TENEMOS OTRAS QUE PUEDEN SER DE SU INTERÉS!:");
			System.out.println("-------------------------------------------------------");

			// sugiere de otros tipos cuando se acaban de su preferencia
			AppTierraMedia.sugerirProductos(user, productosFinales, itinerario, dineroTotal, tiempoTotal);

			System.out.println(" ");

			String archSalida = ("Itinerario" + user.getNombreDeUsuario() + ".out");

			Sistema.escribirCompras(user.getNombreDeUsuario(), tiempoTotal, dineroTotal, itinerario, archSalida);

		} // TERMINA FOR

	}

	private static double setTiempo(double d) {
		if (d == 0)
			tiempoTotal = d;
		else
			tiempoTotal += d;
		return tiempoTotal;
	}

	private static double setCosto(double d) {
		if (d == 0)
			dineroTotal = d;
		else
			dineroTotal += d;
		return dineroTotal;
	}

	private static void sugerirProductos(Usuario user, List<Producto> misGustos, LinkedList<Atracciones> itinerario,
			double dineroTotal, double tiempoTotal) {
		for (Producto opciones : misGustos) {

			ArrayList<String> nombresAtrIncluidas = opciones.getNombreAtracciones();

			// if puede comprar y no está en Itinerario y si tiene cupo
			if (user.puedeComprar(opciones) && AppTierraMedia.noEstaEnItinerario(opciones, itinerario)
					&& AppTierraMedia.tieneCupo(opciones)) {

				// imprime por consola el saldo y el tiempo disponible
				System.out.println("Su saldo es: " + user.getDineroDisponible() + " Su tiempo disponible es: "
						+ user.getTiempoDisponible());

				System.out.println(">>>------------------------------------<<<");

				System.out.println("Nuestra sugerencia es:  " + opciones.nombreProducto);

				System.out.println("Que incluye las atracciones ");
				for (int i = 0; i < nombresAtrIncluidas.size(); i++) {
					System.out.println(nombresAtrIncluidas.get(i));
				}
				System.out.println("A un precio de " + opciones.getPrecioDescuento() + " Monedas");
				System.out.println("La duracion en horas es : " + opciones.getDuracionTotal());

				// Solicita si quiere comprar esa Atraccion
				Scanner opcion = new Scanner(System.in);
				System.out.println("Desea comprar esta oferta S/N");
				String opt = opcion.next();

				System.out.println(opt);

				if (opt.equals("S") || opt.equals("s")) {

					System.out.println(">>> GRACIAS POR SU COMPRA ");
					System.out.println("-----------------------------------------");

					// descuenta CUPO en atracciones
					opciones.descontarCupoProducto();

					// Descuenta tiempo y dinero en usuario
					user.descontarDineroDisponible(opciones.getPrecioDescuento());
					user.descontarTiempoDisponible(opciones.getDuracionTotal());

					// contadores para totalizar
					dineroTotal += AppTierraMedia.setCosto(opciones.getPrecioDescuento());
					tiempoTotal += AppTierraMedia.setTiempo(opciones.getDuracionTotal());

					// agrega al itinerario la compra
					ArrayList<Atracciones> atrac = opciones.getAtracciones();
					for (int i = 0; i < atrac.size(); i++) {
						itinerario.add(atrac.get(i));
					}
				} // CIERRA EL IF
			} // CIERRA EL IF SI TIENE DINERO
		}
	}

	public static boolean noEstaEnItinerario(Producto producto, LinkedList<Atracciones> itinerario) {
		boolean noEncontrado = true;

		// guarda en arrayList la atraccion simple o las atracciones incluidas en una
		// promo
		ArrayList<String> nombresAtrIncluidas = producto.getNombreAtracciones();

		// if itinerario contains el producto/la atraccion
		for (int j = 0; j < nombresAtrIncluidas.size(); j++) {
			for (int i = 0; i < itinerario.size(); i++) {
				// noEncontrado = !itinerario.contains(nombresAtrIncluidas.get(j));
				if (itinerario.get(i).getNombreAtraccion().equals(nombresAtrIncluidas.get(j))) {
					noEncontrado = false;
				}
			}
		}
		return noEncontrado;
	}

	public static boolean tieneCupo(Producto producto) {
		boolean hayCupo = true;

		// obtengo las atracciones contenidas en producto
		ArrayList<Atracciones> atrac = producto.getAtracciones();

		for (int i = 0; i < atrac.size(); i++) {
			if (atrac.get(i).getCupoPersonas() < 1) {
				hayCupo = false;
			}
		}
		return hayCupo;
	}

}