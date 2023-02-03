package paquete;


public class Album {
	
	private static String selecciones[] = {"Qatar", "Ecuador", "Senegal", "Paises Bajos", "Inglaterra", "Ir疣", "EEUU", "Gales", "Argentina", "Arabia Saudita", "M騙ico", "Polonia", "Francia", "Australia", "Dinamarca", "Tunez", "Espa", "Costa Rica", "Alemania", "Jap", "B駘gica", "Canad�", "Marruecos", "Croacia", "Brasil", "Serbia", "Suiza", "Camer佖", "Portugal", "Ghana", "Uruguay", "Corea del Sur"};
	
	private static Figurita figuritasDisponibles[] = new Figurita[704];
	private Figurita figuritasActuales[];
	
	public Album() {
		this.figuritasActuales=new Figurita[704];
		/*
		 * El constructor debe generar las condiciones necesaias para garantizar el correcto funcionamiento de la app
		 */
	}
	
	
	
	public Figurita[] getFiguritasActuales() {
		return figuritasActuales;
	}



	public void setFiguritasActuales(Figurita[] figuritasActuales) {
		this.figuritasActuales = figuritasActuales;
	}



	public static void inicializarCodigosDeFiguritas() {
		int s=0;
		for(int i=0; i<selecciones.length;i++) {
			
			for(int j=1;j<23;j++){
				String codigo=selecciones[i].substring(0, 3).toUpperCase()+j;
				figuritasDisponibles[s]=new Figurita(codigo);
				s++;
			}
		}
		/*
		 * Por cada pa﨎 debe generar 22 cigos de manera autom疸ica por ejemplo QAT1, URU12, COS10
		 */

	}
	
	public static void actualizarDatosFigurita(String codigo, char grupo, String nombreJugador, double valor) {
		for(int i=0;i<figuritasDisponibles.length;i++){
			if(figuritasDisponibles[i].getCodigo().equals(codigo)) {
				figuritasDisponibles[i].setGrupo(grupo);
				figuritasDisponibles[i].setNombreJugador(nombreJugador);
				figuritasDisponibles[i].setValor(valor);
			}
		}
		/*
		 * En funci del cigo de figurita, se deben actualizar los datos de la misma en figuritasDisponibles 
		 */
	}
	
	public Figurita getFigurita(String codigo) {
		
		for(int i=0;i<figuritasDisponibles.length;i++){
			if(figuritasDisponibles[i].getCodigo().equals(codigo)) {
				return figuritasDisponibles[i];
			}
		}
		/*
		 * En funci del cigo de figurita, devuelve la figurita de figuritasDisponibles
		 */
		return null;
	}
	
	public Figurita[] comprarSobre() {
		/*
		 * Se debe calcular y devolver 5 cigos de figurita de manera aleatoria.
		 */
		Figurita sobre[] = new Figurita[5];
		
		for(int i=0;i<sobre.length;i++) {
			sobre[i]=figuritasDisponibles[(int) (Math.random()*(704-0+1)+0)];
		}
		return sobre;
	}
	
	public void agregarFigurita(Figurita nueva) {
		if(repetida(nueva)==false) {
			
			for(int i=0;i<figuritasActuales.length;i++) {
				if(figuritasActuales[i]==null) {
			    	figuritasActuales[i]=nueva;
			    	break;
			    }
			}
		}
		
		/*
		 * Agrega una nueva figurita al array figuritasActuales
		 */
	}
	
	public boolean repetida(Figurita nueva) {
     
	for(int i=0;i<figuritasActuales.length;i++) {
			if(figuritasActuales[i]!=null && figuritasActuales[i]==nueva) {
			return true;	
			}
		} return false;
	}
	
	public void ordenarFiguritasActuales() {
		Figurita aux;
		for(int i=0;i<figuritasActuales.length;i++) {
			for(int j=0;j<figuritasActuales.length-1;j++) {
				if(figuritasActuales[j]!=null && figuritasActuales[j+1]!=null && figuritasActuales[j].getCodigo().compareTo(figuritasActuales[j+1].getCodigo())<0) {
					aux=figuritasActuales[j];
					figuritasActuales[j]=figuritasActuales[j+1];
					figuritasActuales[j+1]=aux;
					
				}
			}
		}
		/*
		 * Debe ordenar el array figuritasActuales
		 */
	}
	
	public boolean elAlbumEstaCompleto() {
		
		/* 
		 * UNA FORMA ALTERNATIVA, PERO NO VERIFICA UNO A UNO
		 * 
		 * int figus=0;
		for(int i=0;i<figuritasActuales.length;i++) {
			if(figuritasActuales[i]!=null) {
				figus++;
			}
		}
		if(figus==704) {
			return true;
		} 
		
		return false;
	*
	*
	*/
		
		int figusTotales=0;
		
		for(int i=0;i<figuritasDisponibles.length;i++) {
			for(int j=0;j<figuritasActuales.length;j++) {
				if(figuritasDisponibles[i]==figuritasActuales[j]) {
					figusTotales++;
					break;
				}
			}
		}
		
		if(figusTotales==704) {
			return true;
		}
		return false;
		
		/*
		 * Debe verificar que todas las figuritas disponibles est駭 presentes al menos una vez en las figuritas actuales 
		 */		
		
	}
	
	public double calcularPorcentajeCompletado() {
		int figus=0;
		for(int i=0;i<figuritasActuales.length;i++) {
			if(figuritasActuales[i]!=null) {
				figus++;
			}
		}
		
		double porcentaje=(figus*100)/704;
		
		/*
		 * Debe calcular el porcentaje de figuritas del album que est� completo. Para esto se debe basar en la informaci de las figuritasDisponibles en relaci a las figuritasActuales que se tiene en el album.
		 */
		return Math.round(porcentaje*100.0)/100.0;
	}

	
	
	
	
	
	
	
	
	
	
}
