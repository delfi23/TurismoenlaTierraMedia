package TurismoenlaTierraMedia;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Producto {

	protected String nombreProducto;
	protected TipoAtraccion tipoAtraccion;
	protected double costoTotal;
	protected double duracionTotal;

	// Constructor para Producto con Promos
	public Producto(ArrayList<Atracciones> atracciones, String nombreProducto, TipoAtraccion tipoAtraccion) {
		this.setCostoTotal(atracciones);
		this.setDuracionTotal(atracciones);
		this.nombreProducto = nombreProducto;
		this.tipoAtraccion = tipoAtraccion;
	}

	// Constructor para Producto con Atracciones
	public Producto(double costo, double duracion, String nombreAtraccion, TipoAtraccion tipoDeAtraccion) {
		this.costoTotal = costo;
		this.duracionTotal = duracion;
		this.nombreProducto = nombreAtraccion;
		this.tipoAtraccion = tipoDeAtraccion;
	}

	// Constructor para Producto con Atracciones
	public Producto(double costo, double duracion, String nombreAtraccion) {
		this.costoTotal = costo;
		this.duracionTotal = duracion;
		this.nombreProducto = nombreAtraccion;
	}

	public Producto() {
	}

	// obtener el nombre de las atracciones, cada subclase lo implementa distinto
	public abstract ArrayList<String> getNombreAtracciones();

	// Set el precio SIN el descuento
	public void setCostoTotal(ArrayList<Atracciones> atrIncluidas) {
		double costo = 0;
		for (int i = 0; i < atrIncluidas.size(); i++) {
			costo += atrIncluidas.get(i).getCostoAtraccion();
		}
		this.costoTotal = costo;
	}

	// Obtener el precio SIN descuento
	public Double getCostoTotal() {
		return this.costoTotal;
	}

	// Obtenga precio con descuento
	public abstract double getPrecioDescuento();

	// Set el tiempo total
	public void setDuracionTotal(ArrayList<Atracciones> atrIncluidas) {
		double tiempo = 0;
		for (int i = 0; i < atrIncluidas.size(); i++) {
			tiempo += atrIncluidas.get(i).getDuracionAtraccion();
		}
		this.duracionTotal = tiempo;
	}

	// descontar cupo
	public abstract void descontarCupoProducto();

	// obtiene las atracciones incluidas en el producto
	public abstract ArrayList<Atracciones> getAtracciones();

	// Obtener duracion total
	public double getDuracionTotal() {
		return this.duracionTotal;
	}

	// obtenertipoAtraccion
	public TipoAtraccion getTipoDeAtraccion() {
		return this.tipoAtraccion;
	}
	
	// ve si no esta en itinerario
	public boolean noEstaEnItinerario(LinkedList<Atracciones> itinerario) {
		boolean noEncontrado = true;

		// guarda en arrayList la atraccion simple o las atracciones incluidas en una
		// promo
		ArrayList<String> nombresAtrIncluidas = this.getNombreAtracciones();

		// if itinerario contains el producto/la atraccion
		for (int j = 0; j < nombresAtrIncluidas.size(); j++) {
			for (int i = 0; i < itinerario.size(); i++) {

				if (itinerario.get(i).getNombreAtraccion().equals(nombresAtrIncluidas.get(j))) {
					noEncontrado = false;
				}

			}
		}
		return noEncontrado;
	}
	
	// chequea si tiene cupo

	public boolean tieneCupo() {
		boolean hayCupo = true;
		
		// obtengo las atracciones contenidas en producto
		ArrayList<Atracciones> atrac = this.getAtracciones();

		for (int i = 0; i < atrac.size(); i++) {
			if (!atrac.get(i).tieneCupo()) {
				return false;
			}
		}
		return hayCupo;
	}
}
