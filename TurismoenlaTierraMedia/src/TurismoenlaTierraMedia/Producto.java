package TurismoenlaTierraMedia;

public abstract class Producto {
	
	protected Double costoTotal;
	protected Double duracionTotal;

	// Constructor para Producto con Promos
	public Producto(Atracciones[] atracciones) {
		this.setCostoTotal(atracciones);
		this.setDuracionTotal(atracciones);
	}
	
	// Constructor para Producto con Atracciones
	public Producto (Double costo, Double duracion) {
		this.costoTotal = costo;
		this.duracionTotal = duracion;
	}

	public Producto() {
	}
	
	// obtener el nombre de las atracciones, cada subclase lo implementa distinto
	public abstract String[] getNombreAtracciones();
	
	// Set el precio SIN el descuento
	public void setCostoTotal(Atracciones[] atrIncluidas) {
		double costo = 0;
		for (int i = 0; i < atrIncluidas.length; i++) {
			costo += atrIncluidas[i].getCostoAtraccion();
		}
		this.costoTotal = costo;
	}
	
	// Obtener el precio SIN descuento
	public Double getCostoTotal(){
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
