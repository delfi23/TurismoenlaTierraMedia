package TurismoenlaTierraMedia;

import java.util.ArrayList;

public class PromoAxB extends Producto {

	private Atracciones atrGratis;
	protected ArrayList<Atracciones> atracciones;

	public PromoAxB(ArrayList<Atracciones> atracciones, Atracciones atrGratis, String nombre,
			TipoAtraccion tipoAtraccion) {
		super(atracciones, nombre, tipoAtraccion);
		this.atrGratis = atrGratis;
		this.atracciones = atracciones;
	}

	// Obtener precio CON descuento
	@Override
	public double getPrecioDescuento() {
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
	public double getDuracionTotal() {
		return super.duracionTotal + atrGratis.getDuracionAtraccion();
	}

	// Para que guarde en atracciones incluidas la atraccion Gratis
	@Override
	public ArrayList<Atracciones> getAtracciones() {
		this.atracciones.add(atrGratis);
		return this.atracciones;
	}

	@Override
	public void descontarCupoProducto() {

		for (int i = 0; i < this.atracciones.size(); i++) {

			this.atracciones.get(i).descontarCupoAtraccion();

		}

	}

	// obtener nombre atracciones
	@Override
	public ArrayList<String> getNombreAtracciones() {
		ArrayList<String> nombres = new ArrayList<>();
		ArrayList<Atracciones> atrac = this.getAtracciones();
		for (int i = 0; i < atrac.size(); i++) {
			nombres.add(atrac.get(i).getNombreAtraccion());
		}
		return nombres;
	}
}