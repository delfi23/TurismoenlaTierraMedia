package TurismoenlaTierraMedia;

public class Producto {
	private Double costo;
	
	public Producto (Double costo) {
		this.setCosto(costo);
	}
	
	public void setCosto (Double costo) {
		this.costo = costo;
	}
	public Double getCosto () {
		return this.costo;
	}
}
