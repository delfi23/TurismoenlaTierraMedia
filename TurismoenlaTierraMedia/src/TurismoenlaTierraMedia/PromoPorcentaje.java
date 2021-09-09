package turismotierramedia;

public class PromoPorcentaje extends Producto{
	
	protected Atracciones[] atracciones;
	private double porcentajeDescuento;

	public PromoPorcentaje(Atracciones[] atracciones, double Porcent, String nombre, TipoAtraccion tipoAtraccion) {
		super(atracciones, nombre, tipoAtraccion);
		this.atracciones = atracciones;
		this.setPorcentajeDescuento(Porcent);
	}

	public void setPorcentajeDescuento(double porcentaje) {
		this.porcentajeDescuento = porcentaje;
	}

	// Obtener precio CON descuento
	@Override
	public double getPrecioDescuento() {
		return super.getCostoTotal() - (super.getCostoTotal() * this.getPorcentajeDescuento());
	}
	
	public double getPorcentajeDescuento() {
		return this.porcentajeDescuento/100;
	}
	
	@Override
	public void descontarCupoProducto() {
	
	for (int i = 0; i < this.atracciones.length; i++) {
		
		this.atracciones[i].descontarCupoAtraccion();
		
		}

}
	
	
	
	
	

	// obtener nombre atracciones
	@Override
	public String[] getNombreAtracciones() {
		String [] nombres = new String [2];
		for (int i = 0; i < this.atracciones.length; i++) {
			nombres[i] = this.atracciones[i].getNombreAtraccion();
		}
		return nombres;
	}
	
}
