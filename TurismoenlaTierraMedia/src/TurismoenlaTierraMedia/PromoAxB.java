package TurismoenlaTierraMedia;

public class PromoAxB extends Producto {

	private Atracciones atrGratis;

	public PromoAxB(Atracciones[] atracciones, Atracciones atrGratis) {
		super(atracciones);
		this.atrGratis = atrGratis;
	}

	// Obtener precio CON descuento
	@Override
	public Double getPrecioDescuento() {
		return this.getCostoTotal() - this.getDescuento();
	}

	public double getDescuento() {
		double descuento = this.atrGratis.getCostoAtraccion();
		return descuento;
	}
	
	// Obtener precio SIN descuento
	@Override
	public Double getCostoTotal() {
		return super.costoTotal + atrGratis.getCostoAtraccion();
	}
	
	// Obtener duracion sumando el tiempo de la Atraccion gratis
	public Double getDuracionTotal() {
		return super.duracionTotal + atrGratis.getDuracionAtraccion();
	}
	
	// Para que guarde en atracciones incluidas la atraccion Gratis
	@Override
	public Atracciones[] getAtracciones() {
		Atracciones [] atrIncluidas = new Atracciones[3];
		for(int i = 0; i < super.atracciones.length + 1; i++) {
			if(i == super.atracciones.length) {
				atrIncluidas[i] = this.atrGratis;
			}
			else {
				atrIncluidas[i] = super.atracciones[i];
			}
		}
		return atrIncluidas;
	}
}
