package com.hubclub.survive.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.hubclub.survive.Survive;

public class DesktopLauncher {
	public static void main (String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Survive Game";
		cfg.width = 800;
		cfg.height = 480;
		cfg.useGL30 = false;
		cfg.resizable = false;
		new LwjglApplication(new Survive(), cfg);
	}
}
