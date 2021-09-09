package turismotierramedia;

public abstract class Producto {
	
	protected String nombreProducto;
	protected TipoAtraccion tipoAtraccion;
	protected double costoTotal;
	protected double duracionTotal;
	
	

	// Constructor para Producto con Promos
	public Producto(Atracciones[] atracciones, String nombreProducto, TipoAtraccion tipoAtraccion) {
		this.setCostoTotal(atracciones);
		this.setDuracionTotal(atracciones);
		this.nombreProducto=nombreProducto;
		this.tipoAtraccion=tipoAtraccion;
		
		
		
	}
	
	// Constructor para Producto con Atracciones
	public Producto (double costo, double duracion, String nombreAtraccion, TipoAtraccion tipoDeAtraccion) {
		this.costoTotal = costo;
		this.duracionTotal = duracion;
		this.nombreProducto=nombreAtraccion;
		this.tipoAtraccion=tipoDeAtraccion;
	}
	
	// Constructor para Producto con Atracciones
		public Producto (double costo, double duracion, String nombreAtraccion) {
			this.costoTotal = costo;
			this.duracionTotal = duracion;
			this.nombreProducto=nombreAtraccion;
			
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
	public abstract double getPrecioDescuento();
	

	// Set el tiempo total
	public void setDuracionTotal(Atracciones[] atrIncluidas) {
		double tiempo = 0;
		for (int i = 0; i < atrIncluidas.length; i++) {
			tiempo += atrIncluidas[i].getDuracionAtraccion();
		}
		this.duracionTotal = tiempo;
	}
	
	
	//descontar cupo
	
	public abstract void descontarCupoProducto();
		
		
		
		
	
	

	// Obtener duracion total
	public double getDuracionTotal() {
		return this.duracionTotal;
	}
	
	//obtenertipoAtraccion
	public TipoAtraccion getTipoDeAtraccion() {
		return this.tipoAtraccion;
	}
}
