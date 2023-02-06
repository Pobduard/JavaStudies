package utilz;

import Main.Game;

import java.awt.geom.Rectangle2D;

public class HelpMethods {
	/* 
	 &	Meodos Utiles que pueden ser usados por MAS que solo el jugador
	 */

	public static boolean CanMoveHere(float x, float y, float width, float height, int[][] lvlData){
//& Chequeamos 1ro la esquina Arriba-Izquierda, y 2do la esquina Abajo-Derecha, para saber mejor a que direccion Vamos, luego ya las otras 2 esquinas
//& Si Todos los de arriba son flasos (Chequeos), nos podremos mover ahi
		if(! IsSolid(x ,y ,lvlData)){							//+ Esquina superior izquierda, si no es esta, seguimos
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

	public static float GetEntityXPosNextToWall(Rectangle2D.Float hitbox, float xSpeed){
		//Da igual si la velociadad es 0, si oo es, no es necesario alguna colision
		int currentTile = (int)(hitbox.x / Game.TILES_SIZE);	//Encontrar en que tile estamos

		if(xSpeed > 0){		//Si es verdadero, vamos a la derecha, vamos en +
			int tileXPos = currentTile * Game.TILES_SIZE;		//Asi encontramos que pixel especifico del Tile actual
			int xOffSet = (int)(Game.TILES_SIZE - hitbox.width);	//Cuanta diferencia hay entre el tile y el jugador
			return tileXPos + xOffSet - 1;		//Regresar la posicion en la cual esta la colision, -1 porque si no nos pasaremos al siguiente Tile

		}	else {			//Izquierda
			return currentTile * Game.TILES_SIZE;		//Izquierda, el inicio, tons ya esta por default
		}
	}

	public static float GetEntityYPosUnderRoofOrAboveFloor(Rectangle2D.Float hitbox, float airSpeed) {
		//mismo del de X, pero para Y

		int currentTile = (int)(hitbox.y / Game.TILES_SIZE);	//Encontrar en que tile estamos
		if(airSpeed > 0){
			// Falling - Touching Floor
			int tileYPos = currentTile * Game.TILES_SIZE;
			int yOffSet = (int)(Game.TILES_SIZE - hitbox.height);

			return  tileYPos + yOffSet - 1;

		}else {
			// Jumping
			return currentTile * Game.TILES_SIZE;
		}
	}

	public static boolean IsEntityOnFloor(Rectangle2D.Float hitbox, int[][] lvlData) {
		// Verificar si los pixeles, abajo-izquierda, y abajo-derecha son solidos, si no, estamos fuera de la plataforma
		if (!IsSolid(hitbox.x, hitbox.y + hitbox.height + 1, lvlData))						//abajo-izquierda + 1, pal piso
			if (!IsSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, lvlData))	//abajo-derecha + 1, pal piso
				return false;

		return true;

	}

}
