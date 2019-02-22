package com.titak.bothan.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.titak.bothan.AdHandler;
import com.titak.bothan.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		AdHandler blank = new AdHandler() {
			@Override
			public void showAds(boolean show) {

			}
		};
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.width=1280;
		cfg.height=720;
		new LwjglApplication(new Game(blank), cfg);
	}
}
