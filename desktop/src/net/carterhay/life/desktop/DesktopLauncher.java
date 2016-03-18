package net.carterhay.life.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.carterhay.life.Life;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    config.title = "Conway's Game of Life";
    config.width = 800;
    config.height = 800;
		new LwjglApplication(new Life(), config);
	}
}
