package TurismoenlaTierraMedia;

public class Promocion {

	private String nombrePromo;
	private TipoAtraccion tipoPromo;
	private int precioPromo;
	private double totalHoras;
	
	public Promocion() {
	
	}

	private Atraccion [] atracciones;
	private int cantidadAtracciones;
	
	public Promocion (int cantidadAtracciones) {
		this.atracciones = new Atraccion[cantidadAtracciones];
	}
	
	public void agregarPromo(Atraccion atraccion) {
		
		if (cantidadAtracciones > atracciones.length - 1) {
			throw new Error("Promo Llena");
		}
		atracciones[cantidadAtracciones] = atraccion;
		this.cantidadAtracciones++;
	}
	
	
	
	
	
}
