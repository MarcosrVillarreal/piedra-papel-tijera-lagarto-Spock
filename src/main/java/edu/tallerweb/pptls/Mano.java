package edu.tallerweb.pptls;


/**
 * Representa una de las Manos involucradas en el juego
 */
public class Mano {

public final Forma valor;
	
	/**
	 * Toda Mano debe crearse con una forma dada, que será
	 * la que determine su condición en el juego.
	 * @param forma, la Forma que adopta la Mano.
	 */
	public Mano(final Forma forma) {
		
		this.valor = forma;
		
		if(this.valor == null){
			throw new RuntimeException("No implementado aún");
		}
	}
	
	/**
	 * Con esto seteo el array con todos los posibles resultados
	 * que se pueden dar dentro del juego
	 * @param manoJugadorUno, el valor de la mano del jugador uno
	 * @param manoJugadorDos, el valor de la mano del jugador dos
	 * @return un Resultado, de acuerdo al array establecido
	 */
	private Resultado obtenerResultado(final Integer manoJugadorUno, final Integer manoJugadorDos){
		
		Resultado gana = Resultado.GANA;
		Resultado empata = Resultado.EMPATA;
		Resultado pierde = Resultado.PIERDE;
		
		Integer valorManoJugadorUno = manoJugadorUno;
		Integer valorManoJugadorDos = manoJugadorDos;
		
		Resultado[][] resultado = {{empata,pierde,pierde,gana,gana}
									,{gana,empata,pierde,pierde,gana}
									,{gana,gana,empata,pierde,pierde}
									,{pierde,gana,gana,empata,pierde}
									,{pierde,pierde,gana,gana,empata}};
		
		return resultado[valorManoJugadorUno][valorManoJugadorDos];
	
	}

	/**
	 * Evaluará el resultado de la partida según las reglas
	 * del juego.
	 * @param otra, la otra Mano.
	 * @return un Resultado, de acuerdo al estado del juego.
	 */
	
	public Resultado jugarCon(final Mano otra) {
		
		Resultado resultado = null;
		Integer manoJugadorUno = this.valor.getValor();
		Integer manoJugadorDos = otra.valor.getValor();
		
		resultado = obtenerResultado(manoJugadorUno,manoJugadorDos);
		
		return resultado;
		
	}

}
