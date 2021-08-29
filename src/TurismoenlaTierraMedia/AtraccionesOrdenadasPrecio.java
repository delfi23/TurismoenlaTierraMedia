package TurismoenlaTierraMedia;


import java.util.Comparator;


public class AtraccionesOrdenadasPrecio implements Comparator<Atraccion>{
	
	
		@Override
		public int compare (Atraccion atr1, Atraccion atr2) {
			return atr1.getCostoAtraccion().compareTo(atr2.getCostoAtraccion());
			
		}

}
