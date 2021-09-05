package TurismoenlaTierraMedia;

public class PromoAxB extends Producto {
	
	private Atracciones atrGratis;
	
	public PromoAxB(Atracciones [] atracciones, Atracciones atrGratis) {
			super(atracciones);
			this.atrGratis = atrGratis;
	}
		
	// Obtener precio CON descuento
	@Override
	public Double getPrecioDescuento () {
		return super.getCostoTotal() - this.getDescuento();
	}
	
	public double getDescuento () {
		double descuento = this.atrGratis.getCostoAtraccion();
		return descuento;
	}
}
