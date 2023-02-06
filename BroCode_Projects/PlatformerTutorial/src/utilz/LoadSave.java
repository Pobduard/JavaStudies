package utilz;
import java.awt.Color;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import Main.Game;

public class LoadSave {

	public static final String PLAYER_ATLAS = "resources/player_sprites.png";
	public static final String LEVEL_ATLAS = "resources/outside_sprites.png";
	// public static final String LEVEL_ONE_DATA = "resources/level_one_data.png";
	public static final String LEVEL_ONE_DATA = "resources/level_one_data_long.png";
	public static final String MENU_BUTTONS = "resources/button_atlas.png";
	public static final String MENU_BACKGROUND = "resources/menu_background.png";
	public static final String PAUSE_BACKGROUND = "resources/pause_menu.png";
	public static final String SOUND_BUTTONS = "resources/sound_button.png";
	public static final String URM_BUTTONS = "resources/urm_buttons.png";
	public static final String VOLUME_BUTTONS = "resources/volume_buttons.png";
	public static final String MENU_BACKGROUND_IMG = "resources/background_menu.png";

	public static BufferedImage GetSpriteAtlas(String fileName) {
		BufferedImage img = null;
		InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
		try {
			img = ImageIO.read(is);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img;
	}

	public static int[][] GetLevelData() {
	/* 
	 &	Estamos Usando la forma "Magica" de crear niveles, que es como que cada tile puede ser representado por un "Pixel", y ese pixel puede ser representado por 1 valor del RGB
	 &		Podemos crear los niveles en un archivo png enano, donde cada pixel de X color es uno de los Tiles en el Sprite, tons si leemos el RGB de cada pixel (Solo necesitamos 1 de los valores
	 &		Solo el Red, solo el Green, o solo el Blue) podemos dibujar cada Sprite de forma correspondiente, la cuesion de eso es tener cuiado de como se dibujan los Sprites, que no collisionen entre si
	 &		Pero eso deberia ser lo mas sencillo
	 &		Por eso el "level_one_data.png" es "raro", si le acemos mucho zoom, veremos el nivel ahi representado, pero en pixels
	 */
		BufferedImage img = GetSpriteAtlas(LEVEL_ONE_DATA);
		int[][] lvlData = new int[img.getHeight()][img.getWidth()];

		for (int j = 0; j < img.getHeight(); j++) {
			for (int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getRed();
				if(value >= 48){
					value = 0;		//& Solo posemos 48 Sprites totales, asi no nos salimos de Bounds, no nos podemos salir de los limites
				}
				lvlData[j][i] = value;
			}
		}
		return lvlData;
	}
	
}
