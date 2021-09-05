package TurismoenlaTierraMedia;


import java.util.Comparator;


public class AtraccionesOrdenadasPrecio implements Comparator<Atracciones>{
	
	
		@Override
		public int compare (Atracciones atr1, Atracciones atr2) {
			return atr1.getCostoAtraccion().compareTo(atr2.getCostoAtraccion());
			
		}

}
