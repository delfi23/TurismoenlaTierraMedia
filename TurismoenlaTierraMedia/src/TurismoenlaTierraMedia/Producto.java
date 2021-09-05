package TurismoenlaTierraMedia;

public abstract class Producto {

	protected Atracciones[] atracciones;
	private double costoTotal;
	private double duracionTotal;

	// Constructor
	public Producto(Atracciones[] atracciones) {
		this.atracciones = atracciones;
		this.setCostoTotal(atracciones);
		this.setDuracionTotal(atracciones);
	}

	public Atracciones[] getAtracciones() {
		return this.atracciones;
	}

	// Set el precio SIN el descuento
	public void setCostoTotal(Atracciones[] atrIncluidas) {
		double costo = 0;
		for (int i = 0; i < atrIncluidas.length; i++) {
			costo += atrIncluidas[i].getCostoAtraccion();
		}
		this.costoTotal = costo;
	}

	// Obtener el precio SIN descuento
	public Double getCostoTotal() {
		return this.costoTotal;
	}

	// Obtenga precio con descuento
	public abstract Double getPrecioDescuento();

	// Set el tiempo total
	public void setDuracionTotal(Atracciones[] atrIncluidas) {
		double tiempo = 0;
		for (int i = 0; i < atrIncluidas.length; i++) {
			tiempo += atrIncluidas[i].getDuracionAtraccion();
		}
		this.duracionTotal = tiempo;
	}

	// Obtener duracion total
	public Double getDuracionTotal() {
		return this.duracionTotal;
	}

}
