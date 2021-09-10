package TurismoenlaTierraMedia;

import java.util.ArrayList;
import java.util.List;

public class PromoPorcentaje extends Producto{
	
	protected ArrayList<Atracciones> atracciones;
	private double porcentajeDescuento;

	public PromoPorcentaje(ArrayList<Atracciones> atracciones, double Porcent, String nombre, TipoAtraccion tipoAtraccion) {
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
	
	for (int i = 0; i < this.atracciones.size(); i++) {
		
		this.atracciones.get(i).descontarCupoAtraccion();
		
		}

}

	// obtener nombre atracciones
	@Override
	public ArrayList<String> getNombreAtracciones() {
		ArrayList<String> nombres = new ArrayList<>();
		for (int i = 0; i < this.atracciones.size(); i++) {
			nombres.add(this.atracciones.get(i).getNombreAtraccion());
		}
		return nombres;
	}
	
}
