package be.taffein.pong.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import be.taffein.pong.Pong;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Pong";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new Pong(), config);
	}
}
