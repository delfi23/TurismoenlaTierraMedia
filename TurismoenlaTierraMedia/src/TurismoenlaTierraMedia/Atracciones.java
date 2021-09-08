package TurismoenlaTierraMedia;

public class Atracciones extends Producto implements Comparable<Atracciones> {

	protected String nombreAtraccion;
	private int cupoPersonas;
	private TipoAtraccion tipoDeAtraccion;

	public Atracciones(String nombreAtraccion, double costoAtraccion, double duracionAtraccion, int cupoPersonas,
			TipoAtraccion tipoDeAtraccion) {
		super (costoAtraccion, duracionAtraccion);
		this.nombreAtraccion = nombreAtraccion;
		this.cupoPersonas = cupoPersonas;
		this.tipoDeAtraccion = tipoDeAtraccion;

	}
	
	public Atracciones(String nombreAtraccion, double costoAtraccion, double duracionAtraccion) {
		super (costoAtraccion, duracionAtraccion);
		this.nombreAtraccion = nombreAtraccion;
	}

	public Atracciones() {
		super();
	}

	// informa el nombre de la atraccion
	public String getNombreAtraccion() {
		return this.nombreAtraccion;
	}

	// informa el costo de la atraccion.
	public Double getCostoAtraccion() {
		return super.costoTotal;
	}

	// informa la duracion de la atraccion.
	public double getDuracionAtraccion() {
		return super.duracionTotal;
	}

	// informa el tipo de atraccion que es.
	public TipoAtraccion getTipoDeAtraccion() {
		return this.tipoDeAtraccion;
	}

	// informa el cupo de personas que queda.
	public int getCupoPersonas() {
		return cupoPersonas;
	}

	// Descuenta 1 persona al total
	public void descontarCupo() {
		this.cupoPersonas -= 1;
	}
	
	// Para la lista producto
	@Override
	public Double getPrecioDescuento() {
		return super.costoTotal;
	}
	
	// Para la lista producto comvierto el nombre a string
	@Override
	public String[] getNombreAtracciones() {
		String [] nombre = new String [1];
		nombre[0]  = this.nombreAtraccion;
		return nombre;
	}

	@Override
	public String toString() {
		return nombreAtraccion + "," + super.costoTotal + "," + super.duracionTotal + "," + cupoPersonas + ","
				+ tipoDeAtraccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + super.costoTotal);
		result = prime * result + cupoPersonas;
		long temp;
		temp = Double.doubleToLongBits(super.duracionTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nombreAtraccion == null) ? 0 : nombreAtraccion.hashCode());
		result = prime * result + ((tipoDeAtraccion == null) ? 0 : tipoDeAtraccion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atracciones other = (Atracciones) obj;
		if (super.costoTotal != other.getCostoAtraccion())
			return false;
		if (cupoPersonas != other.cupoPersonas)
			return false;
		if (Double.doubleToLongBits(super.duracionTotal) != Double.doubleToLongBits(other.getCostoAtraccion()))
			return false;
		if (nombreAtraccion == null) {
			if (other.nombreAtraccion != null)
				return false;
		} else if (!nombreAtraccion.equals(other.nombreAtraccion))
			return false;
		if (tipoDeAtraccion != other.tipoDeAtraccion)
			return false;
		return true;
	}

	@Override
	public int compareTo(Atracciones o) {
		return this.nombreAtraccion.compareTo(o.nombreAtraccion);

	}
}
