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
		
		List<Producto> promociones = Sistema.getProductos("promociones.txt");

		Sistema.ordenarCosto(atracciones);

		// Crea un ciclo for e interactua con cada usuario.

		for (Usuario user : usuario) {

			// Se crea una lista poniendo primero las preferencias

			LinkedList<Atracciones> misGustos = new LinkedList<Atracciones>();
			misGustos.addAll(Sistema.getMeGustan(atracciones, user.getPreferencia()));

			// System.out.println(misGustos);

			// SE crea una lista para guardar lo que compra el cliente

			LinkedList<Atracciones> itinerario = new LinkedList<Atracciones>();

			// se crean contadores para guardar dinero y tiempo.
			int dineroTotal = 0;
			double tiempoTotal = 0;

			System.out.println(user.getNombreDeUsuario() + " Bienvenido/a Tierra Media");
			System.out.println("------------------------------------");
			System.out.println("Tenemos las siguientes Sugerencias para vos!");

			for (Atracciones atr : misGustos) {

				if (user.puedeComprar(atr)) {
					
					// imprime por consola el saldo y el tiempo disponible
					System.out.println("Su saldo es : " + user.getDineroDisponible() + " Su tiempo disponible es : "
							+ user.getTiempoDisponible());

					System.out.println(">>>------------------------------------<<<");

					System.out.println(
							atr.getNombreAtraccion() + " a un precio de " + atr.getCostoAtraccion() + " Monedas");

					System.out.println("La duracion en horas es : " + atr.getDuracionAtraccion());

					// Solicita si quiere comprar esa Atraccion

					Scanner opcion = new Scanner(System.in);
					System.out.println("Desea comprar esta oferta S/N");
					String opt = opcion.next();

					System.out.println(opt);

					if (opt.equals("S") || opt.equals("s")) {

						System.out.println(">>> Usted compro " + atr.getNombreAtraccion());
						System.out.println("-----------------------------------------");

						// descuenta CUPO en atracciones

						atr.descontarCupo();

						// Descuenta tiempo y dinero en usuario
						user.descontarDineroDisponible(atr.getCostoAtraccion());
						user.descontarTiempoDisponible(atr.getDuracionAtraccion());

						// contadores para totalizar
						dineroTotal += atr.getCostoAtraccion();
						tiempoTotal += atr.getDuracionAtraccion();

						

						// agrega al itinerario la compra
						itinerario.add(atr);

					} // CIERRA EL IF

				} // CIERRA EL IF SI TIENE DINERO
				
				System.out.println();
				String archSalida = ("Itinerario" + user.getNombreDeUsuario() + ".out");

				Sistema.escribirCompras(user.getNombreDeUsuario(), tiempoTotal, dineroTotal, itinerario, archSalida);


			} // TERMINA FOR

			
		}
		
				
		// CHEQUEO QUE SE GUARDEN BIEN LAS PROMOCIONES
		// Imprimo lo que incluye mas precio con descuento y duracion
		
		for(Producto promo: promociones) {
			Atracciones [] atrIncluidas = promo.getAtracciones();
			System.out.println("Inluye: ");
			for( int i = 0; i < atrIncluidas.length; i++) {
				System.out.println(atrIncluidas[i].getNombreAtraccion());
			}
			System.out.println("a un precio de " + promo.getPrecioDescuento() + 
					" monedas y dura " + promo.getDuracionTotal());
			System.out.println();
		}
		
	}

}
