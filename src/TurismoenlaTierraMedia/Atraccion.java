package TurismoenlaTierraMedia;



import java.util.Objects;

public class Atraccion implements Comparable<Atraccion> {

	private String nombreAtraccion;
	private int costoAtraccion;
	private double duracionAtraccion;
	private int cupoPersonas;
	private TipoAtraccion tipoAtraccion;

	public Atraccion(String nombreAtraccion, int costoAtraccion, double duracionAtraccion, int cupoPersonas,
			TipoAtraccion tipoAtraccion) {
		this.nombreAtraccion = nombreAtraccion;
		this.costoAtraccion = costoAtraccion;
		this.duracionAtraccion = duracionAtraccion;
		this.cupoPersonas = cupoPersonas;
		this.tipoAtraccion = tipoAtraccion;

	}

	// informa el nombre de la atraccion
	public String getNombreAtraccion() {
		return this.nombreAtraccion;
	}

	// informa el costo de la atraccion.
	public Integer getCostoAtraccion() {
		return this.costoAtraccion;
	}

	// informa la duracion de la atraccion.
	public double getDuracionAtraccion() {
		return this.duracionAtraccion;
	}

	// informa el tipo de atraccion que es.
	public TipoAtraccion getTipoAtraccion() {
		return this.tipoAtraccion;
	}

	// informa el cupo de personas que queda.
	public int getCupoPersonas() {
		return cupoPersonas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + costoAtraccion;
		result = prime * result + cupoPersonas;
		long temp;
		temp = Double.doubleToLongBits(duracionAtraccion);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nombreAtraccion == null) ? 0 : nombreAtraccion.hashCode());
		result = prime * result + ((tipoAtraccion == null) ? 0 : tipoAtraccion.hashCode());
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
		Atraccion other = (Atraccion) obj;
		if (costoAtraccion != other.costoAtraccion)
			return false;
		if (cupoPersonas != other.cupoPersonas)
			return false;
		if (Double.doubleToLongBits(duracionAtraccion) != Double.doubleToLongBits(other.duracionAtraccion))
			return false;
		if (nombreAtraccion == null) {
			if (other.nombreAtraccion != null)
				return false;
		} else if (!nombreAtraccion.equals(other.nombreAtraccion))
			return false;
		if (tipoAtraccion != other.tipoAtraccion)
			return false;
		return true;
	}

	@Override
	public int compareTo(Atraccion o) {
		return this.nombreAtraccion.compareTo(o.nombreAtraccion);

	}

}