package TurismoenlaTierraMedia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AppTierraMedia {

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

			LinkedList<Producto> misGustos = new LinkedList<Producto>();

			misGustos.addAll(Sistema.getProductosQueMeGustan(productosFinales, user.getPreferencia()));

			// SE CREA LISTA PARA GUARDAR ITINERARIO
			LinkedList<Atracciones> itinerario = new LinkedList<Atracciones>();

			// se crean contadores para guardar dinero y tiempo.
			int dineroTotal = 0;
			double tiempoTotal = 0;

			System.out.println(user.getNombreDeUsuario() + " Bienvenido/a Tierra Media");
			System.out.println("------------------------------------");
			System.out.println("Tenemos las siguientes Sugerencias para vos!");

			for (Producto opciones : misGustos) {

				ArrayList<String> nombresAtrIncluidas = opciones.getNombreAtracciones();

				// if puede comprar y no está en Itinerario y si tiene cupo
				if (user.puedeComprar(opciones) && AppTierraMedia.noEstaEnItinerario(opciones, itinerario) && AppTierraMedia.tieneCupo(opciones)){

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
						dineroTotal += opciones.getPrecioDescuento();
						tiempoTotal += opciones.getDuracionTotal();

						// agrega al itinerario la compra
						ArrayList<Atracciones> atrac = opciones.getAtracciones();
						for(int i = 0; i < atrac.size(); i++) {
							itinerario.add(atrac.get(i));
						}
					} // CIERRA EL IF
				} // CIERRA EL IF SI TIENE DINERO

				System.out.println(" ");

				String archSalida = ("Itinerario" + user.getNombreDeUsuario() + ".out");

				Sistema.escribirCompras(user.getNombreDeUsuario(), tiempoTotal, dineroTotal, itinerario, archSalida);

			} // TERMINA FOR

		}

	}
	
	public static boolean noEstaEnItinerario(Producto producto, LinkedList<Atracciones> itinerario) {
		boolean noEncontrado = true;
		
		// guarda en arrayList la atraccion simple o las atracciones incluidas en una promo
		ArrayList<String> nombresAtrIncluidas = producto.getNombreAtracciones();

		// if itinerario contains el producto/la atraccion
		for (int j = 0; j < nombresAtrIncluidas.size(); j++) {	
				for(int i = 0; i < itinerario.size(); i++){
					//noEncontrado = !itinerario.contains(nombresAtrIncluidas.get(j));
				if(itinerario.get(i).getNombreAtraccion().equals(nombresAtrIncluidas.get(j))) {
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
		
		for(int i = 0; i < atrac.size(); i++) {
			if(atrac.get(i).getCupoPersonas() < 1) {
				hayCupo = false;
			}
		}
		return hayCupo;
	}

}