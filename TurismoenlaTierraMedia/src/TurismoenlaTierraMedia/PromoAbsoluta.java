package TurismoenlaTierraMedia;

import java.util.ArrayList;

public class PromoAbsoluta extends Producto{
	
	
	
	private Double precioFinal;
	protected ArrayList<Atracciones> atracciones;

	public PromoAbsoluta(ArrayList<Atracciones> atracciones, Double precioFinal, String nombre, TipoAtraccion tipoAtraccion) {
		super(atracciones, nombre, tipoAtraccion);
		this.setDescuentoAbsoluto(precioFinal);
		this.atracciones = atracciones;
	}

	private void setDescuentoAbsoluto(Double precio) {
		this.precioFinal = precio;
	}

	// Obtener precio CON descuento
	@Override
	public double getPrecioDescuento() {
		return this.precioFinal;
	}
	
	@Override
	public void descontarCupoProducto() {
	
	for (int i = 0; i < this.atracciones.size(); i++) {
		
		this.atracciones.get(i).descontarCupoAtraccion();
		
		}

}
	
	
	
	// Obtener el nombre de las atracciones
	@Override
	public ArrayList<String> getNombreAtracciones() {
		ArrayList<String> nombres = new ArrayList<>();
		for (int i = 0; i < this.atracciones.size(); i++) {
			nombres.add(this.atracciones.get(i).getNombreAtraccion());
		}
		return nombres;
	}
	
	@Override
	public ArrayList<Atracciones> getAtracciones() {
		return this.atracciones;
	}
	
}
