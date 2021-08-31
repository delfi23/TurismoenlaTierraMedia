package TurismoenlaTierraMedia;

import java.io.*;
import java.util.*;



public class Sistema {
	//USAR LISTS

	// abrir archivo de clientes

	// cargar el primer cliente

	// abrir archivos de promociones

	// sugerir la compra de promociones segun sus gustos

	// si compra actualizar saldo de dinero y tiempo

	// actualizar atracciones las que ya fueron compradas

	// abrir archivo de atracciones

	// sugerir atracciones

	// //si compra actualizar saldo de dinero y tiempo

	// actualizar atracciones las que ya fueron compradas

	// mostrar el resto de promociones que no son
	// de su gusto.

	public static void main(String[] args) {

		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			fr = new FileReader("usuarios.txt");
			br = new BufferedReader(fr);
			// Lectura del fichero

			String linea = br.readLine();

			while ((linea != null)) {

				String[] cortaUsuarios = linea.split(",");
				String nombre = String.valueOf(cortaUsuarios[0]);
				int dinero = Integer.parseInt(cortaUsuarios[1]);
				double tiempo = Double.parseDouble(cortaUsuarios[2]);
				TipoAtraccion prefe = TipoAtraccion.valueOf(cortaUsuarios[3]);

				Usuario usuario = new Usuario(nombre, dinero, tiempo, prefe);

				System.out.println("¡Te damos la bienvenida " + usuario.getNombreDeUsuario() + " a La Tierra Media!");
				System.out.println("Nuestro sistema te guiará según tus preferencias de " + usuario.getPreferencia()+".");
				System.out.println("Tu dinero disponible es " + usuario.getDineroDisponible()
						+ " y tu tiempo disponible es " + usuario.getTiempoDisponible()+".");

				System.out.println("Tenemos las siguientes Ofertas y Promociones");

				// -------------------------------------

				FileReader f2r = null;
				BufferedReader b2r = null;

				try {
					// Apertura del fichero y creacion de BufferedReader para poder
					// hacer una lectura comoda (disponer del metodo readLine()).
					f2r = new FileReader("atracciones.txt");
					b2r = new BufferedReader(f2r);
					// Lectura del fichero

					String lineaAtraccion = b2r.readLine();
					
					//Se creo arraylist para tener las atracciones en una lista
					
					ArrayList<Atraccion> listaAtracciones = new ArrayList<Atraccion>();

					while ((lineaAtraccion != null)) {

						String[] cortaAtracciones = lineaAtraccion.split(",");
						String nombreAtraccion = String.valueOf(cortaAtracciones[0]);
						System.out.println(nombreAtraccion);
						int costo = Integer.parseInt(cortaAtracciones[1]);
						double tiempoAtraccion = Double.parseDouble(cortaAtracciones[2]);
						int cupos = Integer.parseInt(cortaAtracciones[3]);
						TipoAtraccion prefe2 = TipoAtraccion.valueOf(cortaAtracciones[4]);

						Atraccion atraccion = new Atraccion(nombreAtraccion, costo, tiempoAtraccion, cupos, prefe2);

						System.out.println("Atraccion " + atraccion.getNombreAtraccion());
						System.out.println("De tipo " + atraccion.getTipoAtraccion());
						System.out.println("Costo de la Atraccion = " + atraccion.getCostoAtraccion());
						System.out.println("Duracion de la atraccion " + atraccion.getDuracionAtraccion());

						// ----------------------------------------------

						/*Scanner opcion = new Scanner(System.in);
						System.out.println("Desea comprar esta oferta S/N");
						String opt = opcion.next();

						System.out.println(opt);

						if (opt.equals("S")) {
							System.out.println("usted compro un paquete");
						}*/
						
						//------------------------------------------------
						
						
						
						listaAtracciones.add(atraccion);
						
						System.out.println("----------"+(listaAtracciones.size()));
						
						/*Iterator Atracciones itrAtracciones = atraccion.iterator();
						
						itrAtracciones = atraccion.iterator();
						
						while(listaAtracciones.hasNext()){
							Atracciones atraccion = itrPartidos.next();
							System.out.println(atraccion.getNombreAtraccion());
						}*/
						
						
						
						
						
						lineaAtraccion = b2r.readLine();

					}
				} catch (IOException e3) {
					e3.printStackTrace();

				} finally {
					// En el finally cerramos el fichero, para asegurarnos
					// que se cierra tanto si todo va bien como si salta
					// una excepcion.
					try {
						if (f2r != null) {
							f2r.close();
						}
					} catch (Exception e4) {
						e4.printStackTrace();
					}

					
					
					
					linea = br.readLine();

				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}