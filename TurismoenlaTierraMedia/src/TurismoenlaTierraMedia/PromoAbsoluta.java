package TurismoenlaTierraMedia;

public class PromoAbsoluta extends Producto{
	
	private Double precioFinal;
	protected Atracciones [] atracciones;

	public PromoAbsoluta(Atracciones[] atracciones, Double precioFinal) {
		super(atracciones);
		this.setDescuentoAbsoluto(precioFinal);
		this.atracciones = atracciones;
	}

	private void setDescuentoAbsoluto(Double precio) {
		this.precioFinal = precio;
	}

	// Obtener precio CON descuento
	@Override
	public Double getPrecioDescuento() {
		return this.precioFinal;
	}
	
	// Obtener el nombre de las atracciones
	@Override
	public String[] getNombreAtracciones() {
		String [] nombres = new String [2];
		for (int i = 0; i < this.atracciones.length; i++) {
			nombres[i] = this.atracciones[i].getNombreAtraccion();
		}
		return nombres;
	}
}
