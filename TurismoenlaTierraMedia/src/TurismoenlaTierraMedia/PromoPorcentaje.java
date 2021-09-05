package TurismoenlaTierraMedia;

public class PromoPorcentaje extends Producto {
	private Double porcentajeDescuento;

	public PromoPorcentaje(Atracciones[] atracciones, Double Porcent) {
		super(atracciones);
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
		return this.porcentajeDescuento;
	}
}
