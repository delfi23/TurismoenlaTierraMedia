 package TurismoenlaTierraMedia;

import java.util.LinkedList;

public class Promocion extends Producto{
	private LinkedList <Atracciones> atraccionesIncluidas;

	public Promocion(Atracciones atraccion1, Atracciones atraccion2, Atracciones atraccion3) {
		super (0.0);
		this.atraccionesIncluidas.add(atraccion1);
		this.atraccionesIncluidas.add(atraccion2);
		this.atraccionesIncluidas.add(atraccion3);
	
	}
	
	public Promocion(Atracciones atraccion1, Atracciones atraccion2) {
		super (0.0);
		this.atraccionesIncluidas.add(atraccion1);
		this.atraccionesIncluidas.add(atraccion2);
	
	}
	
	public Promocion(Double costoPromo, Atracciones atraccion1, Atracciones atraccion2, Atracciones atraccion3) {
		super (costoPromo);
		this.atraccionesIncluidas.add(atraccion1);
		this.atraccionesIncluidas.add(atraccion2);
		this.atraccionesIncluidas.add(atraccion3);
	
	}

	
	
	
	
	
	
}
