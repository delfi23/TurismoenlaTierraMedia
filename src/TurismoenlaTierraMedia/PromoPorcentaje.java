package TurismoenlaTierraMedia;

public class PromoPorcentaje extends Promocion {
	private Double porcentajeDescuento;
	private Double costoTotal;

	public PromoPorcentaje(Atracciones atraccion1, Atracciones atraccion2, Atracciones atraccion3,
			Double Porcent) {
			super(atraccion1,atraccion2, atraccion3);
			this.setPorcentajeDescuento(Porcent);
			this.setCostoTotal(atraccion1, atraccion2, atraccion3);

	}

	public PromoPorcentaje(Atracciones atraccion1, Atracciones atraccion2, Double Porcent) {
		super(0.0, atraccion1, atraccion2);
		this.setPorcentajeDescuento(Porcent);

	}

	public PromoPorcentaje(Atracciones atraccion1, Double Porcent) {
		super(0.0, atraccion1);
		this.setPorcentajeDescuento(Porcent);

	}

	public void setPorcentajeDescuento(Double porcentaje) {
		this.porcentajeDescuento = porcentaje;
	}
	
	public void setCostoTotal (Atracciones atr1, Atracciones atr2, Atracciones atr3) {
		this.costoTotal = atr1.getCosto()+atr2.getCosto()+atr3.getCosto();
	}
	
	
	public Double getPrecioTotal (Atracciones atr1, Atracciones atr2, Atracciones atr3) {
		return this.costoTotal;
	}
	public Double getPrecioDescuento (Atracciones atr1, Atracciones atr2, Atracciones atr3) {
		return this.getPrecioTotal(atr1, atr2, atr3)- (this.getPrecioTotal(atr1, atr2, atr3)*this.getPorcentajeDescuento());
	}
	
	public double getPorcentajeDescuento () {
		return this.porcentajeDescuento;
	}

}
