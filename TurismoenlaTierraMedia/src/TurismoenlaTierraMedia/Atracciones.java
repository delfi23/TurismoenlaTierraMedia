package TurismoenlaTierraMedia;

import java.util.ArrayList;

public class Atracciones extends Producto implements Comparable<Atracciones> {

	private int cupoPersonas;

	public Atracciones(String nombreAtraccion, double costoAtraccion, double duracionAtraccion, int cupoPersonas,
			TipoAtraccion tipoDeAtraccion) {
		super(costoAtraccion, duracionAtraccion, nombreAtraccion, tipoDeAtraccion);
		this.cupoPersonas = cupoPersonas;
	}

	public Atracciones(String nombreAtraccion, double costoAtraccion, double duracionAtraccion) {
		super(costoAtraccion, duracionAtraccion, nombreAtraccion);
	}

	public Atracciones() {
		super();
	}

	// informa el nombre de la atraccion
	public String getNombreAtraccion() {
		return super.nombreProducto;
	}

	// informa el costo de la atraccion.
	public double getCostoAtraccion() {
		return super.costoTotal;
	}

	// informa la duracion de la atraccion.
	public double getDuracionAtraccion() {
		return super.duracionTotal;
	}

	// informa el cupo de personas que queda.
	public int getCupoPersonas() {
		return cupoPersonas;
	}
	
	public boolean tieneCupo() {
		return this.getCupoPersonas() > 0;
	}

	// Descuenta 1 persona al total
	public void descontarCupoAtraccion() {
		this.cupoPersonas -= 1;
	}

	// Descuenta 1 persona al total
	@Override
	public void descontarCupoProducto() {
		this.descontarCupoAtraccion();
	}

	// Para la lista producto
	@Override
	public double getPrecioDescuento() {
		return super.costoTotal;
	}

	// Para la lista producto comvierto el nombre a string
	@Override
	public ArrayList<String> getNombreAtracciones() {
		ArrayList<String> nombres = new ArrayList<>();
		nombres.add(super.nombreProducto);
		return nombres;
	}

	@Override
	public String toString() {
		return super.nombreProducto + "," + super.costoTotal + "," + super.duracionTotal + "," + cupoPersonas + ","
				+ super.tipoAtraccion;
	}

	// Guarda esta atraccion en un ArrayList
	@Override
	public ArrayList<Atracciones> getAtracciones() {
		ArrayList<Atracciones> atrac = new ArrayList<>();
		atrac.add(this);
		return atrac;
	}

	@Override
	public int compareTo(Atracciones o) {
		return super.nombreProducto.compareTo(o.nombreProducto);

	}
}