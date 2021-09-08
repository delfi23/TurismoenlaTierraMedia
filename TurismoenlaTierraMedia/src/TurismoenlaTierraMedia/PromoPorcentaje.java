package TurismoenlaTierraMedia;

public class PromoPorcentaje extends Producto{
	
	protected Atracciones[] atracciones;
	private Double porcentajeDescuento;

	public PromoPorcentaje(Atracciones[] atracciones, Double Porcent) {
		super(atracciones);
		this.atracciones = atracciones;
		this.setPorcentajeDescuento(Porcent);
	}

	public void setPorcentajeDescuento(Double porcentaje) {
		this.porcentajeDescuento = porcentaje;
	}

	// Obtener precio CON descuento
	@Override
	public Double getPrecioDescuento() {
		return super.getCostoTotal() - (super.getCostoTotal() * this.getPorcentajeDescuento());
	}
	
	public double getPorcentajeDescuento() {
		return this.porcentajeDescuento/100;
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
