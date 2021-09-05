package TurismoenlaTierraMedia;

public class PromoAbsoluta extends Producto {
	private Double descAbsoluto;

	public PromoAbsoluta(Atracciones[] atracciones, Double descAbsoluto) {
		super(atracciones);
		this.setDescuentoAbsoluto(descAbsoluto);
	}

	private void setDescuentoAbsoluto(Double descuento) {
		this.descAbsoluto = descuento;
	}

	// Obtener precio CON descuento
	@Override
	public Double getPrecioDescuento() {
		return super.getCostoTotal() - this.getDescuento();
	}

	public Double getDescuento() {
		return this.descAbsoluto;
	}
}
