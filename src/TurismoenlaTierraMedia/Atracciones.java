package TurismoenlaTierraMedia;



public class Atracciones implements Comparable<Atracciones> {

	private String nombreAtraccion;
	private int costoAtraccion;
	private double duracionAtraccion;
	private int cupoPersonas;
	private TipoAtraccion tipoDeAtraccion;

	public Atracciones(String nombreAtraccion, int costoAtraccion, double duracionAtraccion, int cupoPersonas,
			TipoAtraccion tipoDeAtraccion) {
		this.nombreAtraccion = nombreAtraccion;
		this.costoAtraccion = costoAtraccion;
		this.duracionAtraccion = duracionAtraccion;
		this.cupoPersonas = cupoPersonas;
		this.tipoDeAtraccion = tipoDeAtraccion;

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
	public TipoAtraccion getTipoDeAtraccion() {
		return this.tipoDeAtraccion;
	}

	// informa el cupo de personas que queda.
	public int getCupoPersonas() {
		return cupoPersonas;
	}
	
	//Descuenta 1 persona al total
	public void descontarCupo() {
		this.cupoPersonas -=1;
	}
	
	
	
	@Override
	public String toString() {
		return nombreAtraccion+","+
               costoAtraccion+","+
			   duracionAtraccion+","+
		       cupoPersonas+","+
		       tipoDeAtraccion;
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
		if (tipoDeAtraccion != other.tipoDeAtraccion)
			return false;
		return true;
	}

	@Override
	public int compareTo(Atracciones o) {
		return this.nombreAtraccion.compareTo(o.nombreAtraccion);

	}

}
