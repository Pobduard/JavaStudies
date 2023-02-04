package utilz;

import Main.Game;

public class HelpMethods {
	/* 
	 &	Meodos Utiles que pueden ser usados por MAS que solo el jugador
	 */

	public static boolean CanMoveHere(float x, float y, float width, float height, int[][] lvlData){
//& Chequeamos 1ro la esquina Arriba-Izquierda, y 2do la esquina Abajo-Derecha, para saber mejor a que direccion Vamos, luego ya las otras 2 esquinas
//& Si Todos los de arriba son flasos (Chequeos), nos podremos mover ahi
		if(! IsSolid(x,y,lvlData)){							//+ Esquina superior izquierda, si no es esta, seguimos
			if(! IsSolid(x + width, y + height, lvlData)){		//+ Esquina inferior derecha
				if(! IsSolid(x+width, y, lvlData)){			//+ Esquina inferior izquierda
					if(! IsSolid(x, y + height, lvlData)){		//+ Esquina superior derecha
						return true;	//& Si Todos los cheuqeos de arriba fallan
					}	else {return false;}
				}	else {return false;}
			}	else {return false;}
		} 	else {return false;}
	}

	private static boolean IsSolid(float x, float y, int[][] lvlData){//! Si es un Tile, pero tambien dentro del la ventana del juego
		if(x < 0 || x >= Game.GAME_WIDTH){
			return true;}
		if(y < 0 || y >= Game.GAME_HEIGHT){
			return true;}

		//& Si ninguno falla, buscarems en donde nos encontramos en el nivel
		float xIndex = x / Game.TILES_SIZE;
		float yIndex = y / Game.TILES_SIZE;

		int value = lvlData[(int)yIndex][(int)xIndex];	//El "Tile" donde nos encontramos	

		if(value >= 48 || value < 0 || value != 11){// Chequeando que no pasemos dentro de alguno de los tiles (48 posbiles, y mayor a 0), el 11 es porque la posicion 11 es el tile que es "Vacio"
			return true;
		}	else {return false;}	//& Esto es el else, curioso como es el "IF Corto" (supogo), en java
	}
}
