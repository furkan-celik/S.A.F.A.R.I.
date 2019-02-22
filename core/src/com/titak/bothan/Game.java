package com.titak.bothan;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.ArrayList;

import static com.badlogic.gdx.Gdx.input;

public class Game extends ApplicationAdapter {
	SpriteBatch batch,batchUi;
	Texture img;
	OrthographicCamera camera;
	static ArrayList<obje> objeler;
	static ArrayList<powerUp> powerups;
	int sayac,sayacb,sayacc,sayacr,sayacu,sayacmg,sayacw,sayace,sayacbo,sayacbo2,sayacbm,sayacCS,selectionShip;
	int enlvl=-1,puan,coin,state = 0,level,lvltype;
	static boolean boostMode = false,invisibility = false;
	float engelX = 1000;
	public static player oyuncu;
	BitmapFont font;
	boolean died = false,levelSelected = false,finish = false;
	Preferences prefs;
	int highScore,coins,savedLvl,contType;
	boolean[] ships;
	float controlSize;

	AdHandler handler;

	public Game(AdHandler handler){
		this.handler = handler;
	}
	
	@Override
	public void create () {
		new AssetLoader();
		batch = new SpriteBatch();
		batchUi = new SpriteBatch();
		camera = new OrthographicCamera(1920,1080);
		camera.setToOrtho(false,1920,1080);
		objeler = new ArrayList<obje>();
		powerups = new ArrayList<powerUp>();
		font = new BitmapFont(Gdx.files.internal("font/font.fnt"),Gdx.files.internal("font/font.png"),false);
		enlvl=1;boostMode = false;invisibility = false; died = false;
		prefs = Gdx.app.getPreferences("tirtakprojectB");
		highScore = prefs.getInteger("highScore", 0);
		coins = prefs.getInteger("coin", 0);
		savedLvl = prefs.getInteger("savedLvl", 0);
		savedLvl = prefs.getInteger("savedLvl",0);
		contType = prefs.getInteger("contType", 0);
		ships = new boolean[6];
		ships[0] = prefs.getBoolean("s1", true);
		ships[1] = prefs.getBoolean("s2", false);
		ships[2] = prefs.getBoolean("s3", false);
		ships[3] = prefs.getBoolean("s4", false);
		ships[4] = prefs.getBoolean("s5", false);
		ships[5] = prefs.getBoolean("s6", false);
		controlSize = prefs.getFloat("contSize", 1);

		AssetLoader.menu.play();
		AssetLoader.menu.setLooping(true);
		AssetLoader.menu.setVolume(0.5f);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.enableBlending();
		batch.setProjectionMatrix(camera.combined);


		switch (state){
			case 0: //açılış menüsü
				handler.showAds(true);
				batch.begin();

				batch.draw(AssetLoader.btn[1],(1920 - 720) / 2, (1080 + 150) / 2,720,128);
				//batch.draw(AssetLoader.btn[2],(1920 - 720) / 2, (1080 - 128) / 2,720,128);
				//batch.draw(AssetLoader.btn[3],(1920 - 720) / 2, (1080 - 400) / 2,720,128);
				batch.draw(AssetLoader.btn[3],(1920 - 720) / 2, (1080 - 128) / 2,720,128);
				batch.draw(AssetLoader.coin[0],50,1000);
				font.draw(batch,Integer.toString(coins), 110, 1040);

				if(input.isTouched()){
					if((input.getY() > 225 && input.getY() < 310 && input.getX() > 400 && input.getX() < 880 && Gdx.graphics.getHeight() == 720 && Gdx.graphics.getWidth() == 1280) || (input.getY() > 340 && input.getY() < 470 && input.getX() > 590 && input.getX() < 1310 && Gdx.graphics.getWidth() == 1920 && Gdx.graphics.getHeight() == 1080)){
						state = 1;
					}
				}

				batch.end();
				break;
			case 1: //bölüm seçimi
				handler.showAds(false);
				batch.begin();

				for(int i = 9; i > savedLvl; i--){
					switch (i) {
						case 0:
							batch.draw(AssetLoader.planetsBW[0], 30, 750, 164, 164);
							break;
						case 1:
							font.draw(batch, "?", 270, 850);
							batch.draw(AssetLoader.planetsBW[1], 220, 750, 164, 164);
							break;
						case 2:
							font.draw(batch, "?", 460, 850);
							batch.draw(AssetLoader.planetsBW[2], 410, 750, 164, 164);
							break;
						case 3:
							font.draw(batch, "?", 650, 850);
							batch.draw(AssetLoader.planetsBW[3], 600, 750, 164, 164);
							break;
						case 4:
							font.draw(batch, "?", 840, 850);
							batch.draw(AssetLoader.planetsBW[4], 790, 750, 164, 164);
							break;
						case 5:
							font.draw(batch, "?", 1030, 850);
							batch.draw(AssetLoader.planetsBW[5], 980, 750, 164, 164);
							break;
						case 6:
							font.draw(batch, "?", 1220, 850);
							batch.draw(AssetLoader.planetsBW[6], 1170, 750, 164, 164);
							break;
						case 7:
							font.draw(batch, "?", 1410, 850);
							batch.draw(AssetLoader.planetsBW[7], 1360, 750, 164, 164);
							break;
						case 8:
							font.draw(batch, "?", 1600, 850);
							batch.draw(AssetLoader.planetsBW[8], 1550, 750, 164, 164);
							break;
						case 9:
							font.draw(batch, "?", 1790, 850);
							batch.draw(AssetLoader.planetsBW[9], 1740, 750, 164, 164);
							break;
					}
				}

				for(int i = savedLvl; i >= 0; i--) {
					switch (i) {
						case 0:
							batch.draw(AssetLoader.planets[0], 30, 750, 164, 164);
							break;
						case 1:
							batch.draw(AssetLoader.planets[1], 220, 750, 164, 164);
							break;
						case 2:
							batch.draw(AssetLoader.planets[2], 410, 750, 164, 164);
							break;
						case 3:
							batch.draw(AssetLoader.planets[3], 600, 750, 164, 164);
							break;
						case 4:
							batch.draw(AssetLoader.planets[4], 790, 750, 164, 164);
							break;
						case 5:
							batch.draw(AssetLoader.planets[5], 980, 750, 164, 164);
							break;
						case 6:
							batch.draw(AssetLoader.planets[6], 1170, 750, 164, 164);
							break;
						case 7:
							batch.draw(AssetLoader.planets[7], 1360, 750, 164, 164);
							break;
						case 8:
							batch.draw(AssetLoader.planets[8], 1550, 750, 164, 164);
							break;
						case 9:
							batch.draw(AssetLoader.planets[9], 1740, 750, 164, 164);
							break;
					}
				}
				batch.draw(AssetLoader.coin[0],50,1000);
				font.draw(batch,Integer.toString(coins), 110, 1040);

				if(input.isTouched()){
					if((input.getY() < 215 && input.getY() > 115 && input.getX() < 1280 && input.getX() > 30 && Gdx.graphics.getHeight() == 720 && Gdx.graphics.getWidth() == 1280) || (input.getY() < 330 && input.getY() > 165 && input.getX() < 1890 && input.getX() > 40 && Gdx.graphics.getHeight() == 1080 && Gdx.graphics.getWidth() == 1920)){
						if(Gdx.graphics.getHeight() == 720 && Gdx.graphics.getWidth() == 1280) {
							if (input.getX() > 30 && input.getX() <= 155 && savedLvl >= 0) {
								level = 0;
								levelSelected = true;
							} else if (input.getX() > 155 && input.getX() <= 280 && savedLvl >= 1) {
								level = 1;
								levelSelected = true;
							} else if (input.getX() > 280 && input.getX() <= 405 && savedLvl >= 2) {
								level = 2;
								levelSelected = true;
							} else if (input.getX() > 405 && input.getX() <= 530 && savedLvl >= 3) {
								level = 3;
								levelSelected = true;
							} else if (input.getX() > 530 && input.getX() <= 655 && savedLvl >= 4) {
								level = 4;
								levelSelected = true;
							} else if (input.getX() > 655 && input.getX() <= 780 && savedLvl >= 5) {
								level = 5;
								levelSelected = true;
							} else if (input.getX() > 780 && input.getX() <= 905 && savedLvl >= 6) {
								level = 6;
								levelSelected = true;
							} else if (input.getX() > 905 && input.getX() <= 1030 && savedLvl >= 7) {
								level = 7;
								levelSelected = true;
							} else if (input.getX() > 1030 && input.getX() <= 1155 && savedLvl >= 8) {
								level = 8;
								levelSelected = true;
							} else if (input.getX() > 1155 && input.getX() <= 1280 && savedLvl >= 9) {
								level = 9;
								levelSelected = true;
							}
							if (input.getX() > 155 && input.getX() <= 280 && savedLvl < 1) {
								unknownPlanet();
							} else if (input.getX() > 280 && input.getX() <= 405 && savedLvl < 2) {
								unknownPlanet();
							} else if (input.getX() > 405 && input.getX() <= 530 && savedLvl < 3) {
								unknownPlanet();
							} else if (input.getX() > 530 && input.getX() <= 655 && savedLvl < 4) {
								unknownPlanet();
							} else if (input.getX() > 655 && input.getX() <= 780 && savedLvl < 5) {
								unknownPlanet();
							} else if (input.getX() > 780 && input.getX() <= 905 && savedLvl < 6) {
								unknownPlanet();
							} else if (input.getX() > 905 && input.getX() <= 1030 && savedLvl < 7) {
								unknownPlanet();
							} else if (input.getX() > 1030 && input.getX() <= 1155 && savedLvl < 8) {
								unknownPlanet();
							} else if (input.getX() > 1155 && input.getX() <= 1280 && savedLvl < 9) {
								unknownPlanet();
							}
						}else if(Gdx.graphics.getHeight() == 1080 && Gdx.graphics.getWidth() == 1920){
							if (input.getX() > 40 && input.getX() <= 225 && savedLvl >= 0) {
								level = 0;
								levelSelected = true;
							} else if (input.getX() > 225 && input.getX() <= 410 && savedLvl >= 1) {
								level = 1;
								levelSelected = true;
							} else if (input.getX() > 410 && input.getX() <= 595 && savedLvl >= 2) {
								level = 2;
								levelSelected = true;
							} else if (input.getX() > 595 && input.getX() <= 780 && savedLvl >= 3) {
								level = 3;
								levelSelected = true;
							} else if (input.getX() > 780 && input.getX() <= 965 && savedLvl >= 4) {
								level = 4;
								levelSelected = true;
							} else if (input.getX() > 965 && input.getX() <= 1150 && savedLvl >= 5) {
								level = 5;
								levelSelected = true;
							} else if (input.getX() > 1150 && input.getX() <= 1335 && savedLvl >= 6) {
								level = 6;
								levelSelected = true;
							} else if (input.getX() > 1335 && input.getX() <= 1520 && savedLvl >= 7) {
								level = 7;
								levelSelected = true;
							} else if (input.getX() > 1520 && input.getX() <= 1705 && savedLvl >= 8) {
								level = 8;
								levelSelected = true;
							} else if (input.getX() > 1705 && input.getX() <= 1890 && savedLvl >= 9) {
								level = 9;
								levelSelected = true;
							}
							if (input.getX() > 225 && input.getX() <= 410 && savedLvl < 1) {
								unknownPlanet();
							} else if (input.getX() > 410 && input.getX() <= 595 && savedLvl < 2) {
								unknownPlanet();
							} else if (input.getX() > 595 && input.getX() <= 780 && savedLvl < 3) {
								unknownPlanet();
							} else if (input.getX() > 780 && input.getX() <= 965 && savedLvl < 4) {
								unknownPlanet();
							} else if (input.getX() > 965 && input.getX() <= 1150 && savedLvl < 5) {
								unknownPlanet();
							} else if (input.getX() > 1150 && input.getX() <= 1335 && savedLvl < 6) {
								unknownPlanet();
							} else if (input.getX() > 1335 && input.getX() <= 1520 && savedLvl < 7) {
								unknownPlanet();
							} else if (input.getX() > 1520 && input.getX() <= 1705 && savedLvl < 8) {
								unknownPlanet();
							} else if (input.getX() > 1705 && input.getX() <= 1890 && savedLvl < 9) {
								unknownPlanet();
							}
						}
					}
				}

				if(levelSelected){
					if(level == savedLvl) {
						batch.draw(AssetLoader.btn[0], 535, 500,400,70);
						font.draw(batch,"INFINITIVE", 543, 560);
						batch.draw(AssetLoader.btn[0], 985, 500, 400, 70);
						font.draw(batch, "STORY", 1068, 560);
					}else {
						batch.draw(AssetLoader.btn[0], 760, 500,400,70);
						font.draw(batch,"INFINITIVE", 768, 560);
					}

					if(input.isTouched()){
						if((input.getY() > 345 && input.getY() < 385 && Gdx.graphics.getWidth() == 1280 && Gdx.graphics.getHeight() == 720) || (input.getY() > 500 && input.getY() < 570 && Gdx.graphics.getHeight() == 1080 && Gdx.graphics.getWidth() == 1920)){
							if((input.getX() > 355 && input.getX() < 620 && Gdx.graphics.getWidth() == 1280 && Gdx.graphics.getHeight() == 720) || (input.getX() > 530 && input.getX() < 930 && Gdx.graphics.getWidth() == 1920 && Gdx.graphics.getHeight() == 1080) && level == savedLvl){
								state = 2;
								oyuncu = new player(50,50,contType,selectionShip);
								objeler.add(oyuncu);
								oyuncu.speed = (oyuncu.speed * (10 - level) * 10) / 100;
								System.out.println(oyuncu.speed);
								lvltype = 0;
								AssetLoader.menu.stop();
								levelSelected = false;

								AssetLoader.game.play();
								AssetLoader.game.setLooping(true);
							}else if((input.getX() > 655 && input.getX() < 925 && Gdx.graphics.getWidth() == 1280 && Gdx.graphics.getHeight() == 720) || (input.getX() > 980 && input.getX() < 1385 && Gdx.graphics.getWidth() == 1920 && Gdx.graphics.getHeight() == 1080) && level == savedLvl){
								state = 2;
								oyuncu = new player(50,50,contType,selectionShip);
								objeler.add(oyuncu);
								oyuncu.speed = (oyuncu.speed * (10 - level) * 10) / 100;
								System.out.println(oyuncu.speed);
								lvltype = 1;
								AssetLoader.menu.stop();
								levelSelected = false;

								AssetLoader.game.play();
								AssetLoader.game.setLooping(true);
							}else if((input.getX() > 755 && input.getX() < 1155 && Gdx.graphics.getWidth() == 1920 && Gdx.graphics.getHeight() == 1080) && level != savedLvl){
								state = 2;
								oyuncu = new player(50,50,contType,selectionShip);
								objeler.add(oyuncu);
								oyuncu.speed = (oyuncu.speed * (10 - level) * 10) / 100;
								System.out.println(oyuncu.speed);
								lvltype = 0;
								AssetLoader.menu.stop();
								levelSelected = false;

								AssetLoader.game.play();
								AssetLoader.game.setLooping(true);
							}
						}
					}
				}

				batch.draw(AssetLoader.player[0], 50,50);
				batch.draw(AssetLoader.player[1], 200,50);
				batch.draw(AssetLoader.player[2], 350,50);
				batch.draw(AssetLoader.player[3], 500,50);
				batch.draw(AssetLoader.player[4], 650,50);
				batch.draw(AssetLoader.player[5], 800,50);

				if(!ships[1]){
					batch.draw(AssetLoader.buy[0], 200, 50,100,132);
				}
				if(!ships[2]){
					batch.draw(AssetLoader.buy[1], 350, 50,100,132);
				}
				if(!ships[3]){
					batch.draw(AssetLoader.buy[2], 500, 50,100,132);
				}
				if(!ships[4]){
					batch.draw(AssetLoader.buy[3], 650, 50,100,132);
				}
				if(!ships[5]){
					batch.draw(AssetLoader.buy[4], 800, 50,100,132);
				}

				if(input.isTouched()){
					if((input.getY() < 695 && input.getY() > 605 && Gdx.graphics.getHeight() == 720 && Gdx.graphics.getWidth() == 1280) || (input.getY() <1035 && input.getY() > 910 && Gdx.graphics.getHeight() == 1920 && Gdx.graphics.getWidth() == 1080)){
						if((input.getX() > 25 && input.getX() <= 120 && Gdx.graphics.getWidth() == 1280 && Gdx.graphics.getHeight() == 720) || (input.getX() > 45 && input.getX() < 185 && Gdx.graphics.getWidth() == 1920 && Gdx.graphics.getHeight() == 1080) && ships[0]){
							selectionShip = 0;
						}else if((input.getX() > 120 && input.getX() <= 215 && Gdx.graphics.getWidth() == 1280 && Gdx.graphics.getHeight() == 720) || (input.getX() > 185 && input.getX() < 325 && Gdx.graphics.getWidth() == 1920 && Gdx.graphics.getHeight() == 1080) && ships[1]){
							selectionShip = 1;
						}else if((input.getX() > 215 && input.getX() <= 310 && Gdx.graphics.getWidth() == 1280 && Gdx.graphics.getHeight() == 720) || (input.getX() > 325 && input.getX() < 465 && Gdx.graphics.getWidth() == 1920 && Gdx.graphics.getHeight() == 1080) && ships[2]){
							selectionShip = 2;
						}else if((input.getX() > 310 && input.getX() <= 405 && Gdx.graphics.getWidth() == 1280 && Gdx.graphics.getHeight() == 720) || (input.getX() > 465 && input.getX() < 605 && Gdx.graphics.getWidth() == 1920 && Gdx.graphics.getHeight() == 1080) && ships[3]){
							selectionShip = 3;
						}else if((input.getX() > 405 && input.getX() <= 500 && Gdx.graphics.getWidth() == 1280 && Gdx.graphics.getHeight() == 720) || (input.getX() > 605 && input.getX() < 745 && Gdx.graphics.getWidth() == 1920 && Gdx.graphics.getHeight() == 1080) && ships[4]){
							selectionShip = 4;
						}else if((input.getX() > 500 && input.getX() <= 595 && Gdx.graphics.getWidth() == 1280 && Gdx.graphics.getHeight() == 720) || (input.getX() > 745 && input.getX() < 885 && Gdx.graphics.getWidth() == 1920 && Gdx.graphics.getHeight() == 1080) && ships[5]){
							selectionShip = 5;
						}
						if(!ships[1] && coins > 100 && (input.getX() > 120 && input.getX() <= 215 && Gdx.graphics.getWidth() == 1280 && Gdx.graphics.getHeight() == 720) || (input.getX() > 185 && input.getX() < 325 && Gdx.graphics.getWidth() == 1920 && Gdx.graphics.getHeight() == 1080)){
							selectionShip = 1;
							prefs.putInteger("coin", coins - 100);
							prefs.putBoolean("s2", true);
							prefs.flush();
							coins = prefs.getInteger("coin");
							ships[1] = prefs.getBoolean("s2");
						}else if(!ships[2] && coins > 200 && (input.getX() > 215 && input.getX() <= 310 && Gdx.graphics.getWidth() == 1280 && Gdx.graphics.getHeight() == 720) || (input.getX() > 325 && input.getX() < 465 && Gdx.graphics.getWidth() == 1920 && Gdx.graphics.getHeight() == 1080)){
							selectionShip = 2;
							prefs.putInteger("coin", coins - 200);
							prefs.putBoolean("s3", true);
							prefs.flush();
							coins = prefs.getInteger("coin");
							ships[1] = prefs.getBoolean("s3");
						}else if(!ships[3] && coins > 400 && (input.getX() > 310 && input.getX() <= 405 && Gdx.graphics.getWidth() == 1280 && Gdx.graphics.getHeight() == 720) || (input.getX() > 465 && input.getX() < 605 && Gdx.graphics.getWidth() == 1920 && Gdx.graphics.getHeight() == 1080)){
							selectionShip = 3;
							prefs.putInteger("coin", coins - 400);
							prefs.putBoolean("s4", true);
							prefs.flush();
							coins = prefs.getInteger("coin");
							ships[1] = prefs.getBoolean("s4");
						}else if(!ships[4] && coins > 800 && (input.getX() > 405 && input.getX() <= 500 && Gdx.graphics.getWidth() == 1280 && Gdx.graphics.getHeight() == 720) || (input.getX() > 605 && input.getX() < 745 && Gdx.graphics.getWidth() == 1920 && Gdx.graphics.getHeight() == 1080)){
							selectionShip = 4;
							prefs.putInteger("coin", coins - 800);
							prefs.putBoolean("s5", true);
							prefs.flush();
							coins = prefs.getInteger("coin");
							ships[1] = prefs.getBoolean("s5");
						}else if(!ships[5] && coins > 1000 && (input.getX() > 500 && input.getX() <= 595 && Gdx.graphics.getWidth() == 1280 && Gdx.graphics.getHeight() == 720) || (input.getX() > 745 && input.getX() < 885 && Gdx.graphics.getWidth() == 1920 && Gdx.graphics.getHeight() == 1080)){
							selectionShip = 5;
							prefs.putInteger("coin", coins - 1000);
							prefs.putBoolean("s6", true);
							prefs.flush();
							coins = prefs.getInteger("coin");
							ships[1] = prefs.getBoolean("s6");
						}
					}
				}

				switch (selectionShip){
					case 0:
						batch.draw(AssetLoader.selection,40,30);
						break;
					case 1:
						batch.draw(AssetLoader.selection,190,30);
						break;
					case 2:
						batch.draw(AssetLoader.selection,340,30);
						break;
					case 3:
						batch.draw(AssetLoader.selection,480,30);
						break;
					case 4:
						batch.draw(AssetLoader.selection,640,30);
						break;
					case 5:
						batch.draw(AssetLoader.selection,790,30);
						break;
				}

				batch.end();
				break;
			case 2: //oyun
				sayac++; //meteor yarattım
				if(sayac > 20){
					int rand = (int) (Math.random()*100+0);
					do {
						if(rand > 75){
							new meteor((float) oyuncu.x + 1950, (float) Math.random() * 1080,1);
						}else if(rand <= 75){
							new meteor((float) oyuncu.x + 1950, (float) Math.random() * 1080,0);
						}

						rand-= 75;
					}while (rand >= 0);
					sayac = 0;
				}

				sayacb++; //bor yarattım
				if(sayacb > 950){
					new bor((float) oyuncu.x + 1950, (float) Math.random() * 1080);
					sayacb = 0;
				}

				sayacc++; //coin yarattım
				if(sayacc > 70){
					new coin((float) oyuncu.x + 1950, (float) Math.random() * 1080);
					sayacc = 0;
				}

				sayacr++; //roket yarattım
				if(sayacr > 2000){
					new roket((float) oyuncu.x + 1950, (float) oyuncu.y);
					sayacr = 0;
				}

				sayacu++; //uplink yarattım
				if(sayacu > 10000){
					new uplinkCanon((float) oyuncu.x + 1920, (float) oyuncu.y);
					sayacu = 0;
					System.out.println("öl");
				}

				sayacmg++; //büyük meteor yarattım
				if(sayacmg > 3000){
					int rand = (int) (Math.random()*2+0);
					new meteorGravit((float) oyuncu.x + 1950, (float) Math.random() * 1080,0);
					System.out.println("çekim");
					sayacmg = 0;
				}

				sayacw++; //silah power up'ı
				if(sayacw > 4000){
					new fire((float) oyuncu.x + 1950, (float) Math.random() * 1080,0);
					sayacw = 0;
				}
				if (oyuncu.weapon == 1){
					sayace++;
					if(sayace > 50){
						new enemy((float) oyuncu.x + 1950, (float) Math.random() * 1080,enlvl);
						sayace = 0;
					}
					if(sayacw == 499){
					}
				}

				//boost power up'ını yarattım
				sayacbo++;
				if(sayacbo > 1700){
					new boost(oyuncu.x + 1950, (float) Math.random() * 1080);
					sayacbo = 0;
				}
				if(boostMode || invisibility){
					sayacbo2++;
					if(sayacbo2 > 125){
						invisibility = false;
						sayacbo2 = 0;
					}else if(sayacbo2 > 100){
						boostMode = false;
						oyuncu.speed = 10;
					}
				}

				//bomba'yı yaratıyorum
				sayacbm++;
				if(sayacbm > 5000){
					new bomb(oyuncu.x + 1950, (float) Math.random() * 1080);
					sayacbm = 0;
				}


				for(int d = 0; d < objeler.size(); d++){
					if(objeler.get(d).x < (oyuncu.x - 1000)){
						objeler.remove(d);
						System.out.println("Obje silindi");
					}
				}

				for(int d = 0; d < powerups.size(); d++){
					if(powerups.get(d).x < (oyuncu.x - 1000)){
						powerups.remove(d);
						System.out.println("Obje silindi");
					}
				}

				batch.begin();
				camera.position.set(oyuncu.x + 930, 540,0);
				camera.update();

				/*for(int y=0; y < 5; y++){
					for(int x=0; x < 8; x++){
						batch.draw(AssetLoader.background[level],256*x + oyuncu.x - 100,256*y);
					}
				}*/

				/*for (int y=0; y < Math.round(1500 / AssetLoader.background[level].getHeight()); y++){
					for(int x=0; x < Math.round(3000 / AssetLoader.background[level].getWidth()); x++){
						batch.draw(AssetLoader.background[level],AssetLoader.background[level].getWidth() * x + oyuncu.x - 50,AssetLoader.background[level].getHeight() * y);
					}
				}*/

				for(int x = 0; (AssetLoader.background[level].getWidth() * x) < 1920; x++){
					for(int y = 0; (AssetLoader.background[level].getHeight() * y) < 1080; y++){
						batch.draw(AssetLoader.background[level],AssetLoader.background[level].getWidth() * x + oyuncu.x - 50,AssetLoader.background[level].getHeight() * y);
					}
				}

				if(sayacr > 1800){
					batch.draw(AssetLoader.caution,(float) oyuncu.x + 1800, (float) oyuncu.y);
				}

				for(int i=0; i < powerups.size(); i++){
					powerups.get(i).render(batch);
					powerups.get(i).update();
				}

				for(int i=0;i<objeler.size();i++) {
					objeler.get(i).render(batch);
					objeler.get(i).update();
					//System.out.println(oyuncu.bor);
					//System.out.println(oyuncu.x);
				}

				for(int i=0;i<objeler.size();i++) {
					if(objeler.get(i) instanceof player) {
						for (int j = 0; j < objeler.size(); j++) {
							if(objeler.get(j) instanceof meteor){
								if(((meteor) objeler.get(j)).circ.overlaps(((player) objeler.get(i)).circ) && !invisibility){
									//System.out.println(oyuncu.lvl -  3);
									puan = oyuncu.puan;
									coin = oyuncu.coin;
									objeler.remove(i);
									died = true;
									break;
								}
							}else if(objeler.get(j) instanceof roket){
								if(((roket) objeler.get(j)).circ.overlaps(((player) objeler.get(i)).circ) && !invisibility){
									objeler.remove(i);
									break;
								}
							}else if(objeler.get(j) instanceof meteorGravit){
								if(((meteorGravit) objeler.get(j)).circ.overlaps(((player) objeler.get(i)).circ) && !invisibility){
									objeler.remove(i);
									break;
								}else if(((meteorGravit) objeler.get(j)).circ2.overlaps(((player) objeler.get(i)).circ) && !invisibility){
									objeler.get(i).y -= Math.sin(Math.toRadians((float) Math.toDegrees(Math.atan2(objeler.get(i).y - objeler.get(j).y, objeler.get(i).x - objeler.get(j).x))))*7;
									break;
								}
							}else if(objeler.get(j) instanceof enemy){
								if(((enemy) objeler.get(j)).circ.overlaps(((player) objeler.get(i)).circ) && !invisibility){
									objeler.remove(i);
									objeler.remove(oyuncu);
									break;
								}
							}

						}
					}
				}

				for(int i = 0; i<objeler.size();i++){
					if(objeler.get(i) instanceof uplinkCanon){
						for(int j = 0; j < objeler.size(); j++){
							if(((objeler.get(i).y + objeler.get(i).img.getHeight()) > objeler.get(j).y) && (objeler.get(i).y < objeler.get(j).y) && objeler.get(i).x < objeler.get(j).x  && !invisibility){
								objeler.remove(j);
								System.out.println("Uplink powaaaaaa");
							}
						}
					}
				}

				for(int i = 0; i < objeler.size(); i++){
					if(objeler.get(i) instanceof lazer){
						for(int j = 0; j < objeler.size(); j++){
							if(objeler.get(j) instanceof enemy){
								if(objeler.get(j).circ.overlaps(objeler.get(i).circ) && !invisibility){
									if(objeler.get(j) instanceof enemy){
										oyuncu.puan += 10;
									}
									System.out.println(oyuncu.puan);
									lazer la = (lazer) objeler.get(i);
									objeler.remove(j);
									objeler.remove(la);
									break;
								}
							}else if(objeler.get(j) instanceof meteor){
								if(((lazer) objeler.get(i)).circ.overlaps(((meteor) objeler.get(j)).circ) && !invisibility){
									if(objeler.get(j) instanceof meteor){
										oyuncu.puan += 5;
									}
									System.out.println(oyuncu.puan);
									lazer la = (lazer) objeler.get(i);
									objeler.remove(j);
									objeler.remove(la);
									break;
								}
							}else if(objeler.get(j) instanceof player){
								if(((lazer) objeler.get(i)).circ.overlaps(((player) objeler.get(j)).circ) && !invisibility){
									objeler.remove(j);
									objeler.remove(oyuncu);
								}
							}
						}
					}
				}

				for(int i=0;i<objeler.size();i++) {
					if(objeler.get(i) instanceof meteor) {
						for (int j = 0; j < objeler.size(); j++) {
							if(objeler.get(j) instanceof meteor){
								if(((meteor) objeler.get(j)).circ.overlaps(((meteor) objeler.get(i)).circ)){

									break;
								}
							}
						}
					}
				}

				for(int i=0;i<objeler.size();i++) {
					if(objeler.get(i) instanceof player) {
						for (int j = 0; j < powerups.size(); j++) {
							if(((player) objeler.get(i)).circ.overlaps(powerups.get(j).circ)){
								powerups.get(j).run();
								if(powerups.get(j) instanceof bor)
									System.out.println("Bor yüklendi abi görüşürüz");
								if(powerups.get(j) instanceof fire)
									enlvl++;
								powerups.remove(j);
								break;
							}
						}
					}
				}


				batch.end();

				batchUi.enableBlending();
				batchUi.setProjectionMatrix(camera.projection);

				batchUi.begin();

				if(oyuncu.y < 900){
					batchUi.draw(AssetLoader.borBar[1],-939,(float) 490.5,(float) (AssetLoader.borBar[1].getWidth() * oyuncu.bor) / 2000, AssetLoader.borBar[1].getHeight());
					batchUi.draw(AssetLoader.borBar[0],-940,490);

					if(boostMode){
						batchUi.draw(AssetLoader.powerUpUi[0],-50 - (AssetLoader.powerUpUi[0].getWidth()),-450,((float) AssetLoader.powerUpUi[0].getWidth()) * 4,AssetLoader.powerUpUi[0].getHeight() * 2);
						batchUi.draw(AssetLoader.powerUpUi[1],-50 - (AssetLoader.powerUpUi[1].getWidth()),-450,((float) (AssetLoader.powerUpUi[1].getWidth() * (100 - sayacbo2)) / 100) * 4,AssetLoader.powerUpUi[1].getHeight() * 2);
					}

					batchUi.draw(AssetLoader.coin[0],-620,485);
					font.draw(batchUi,Integer.toString(oyuncu.coin), -560, 525);

					batchUi.draw(AssetLoader.researchUi, -430, 485);
					if(lvltype == 1){
						font.draw(batchUi,Integer.toString((int) (oyuncu.x / 200)) + "/" + Integer.toString((level + 1) * 200), -370, 525);
					}else {
						font.draw(batchUi,Integer.toString((int) (oyuncu.x / 200)), -370, 525);
					}
				}else {
					batchUi.draw(AssetLoader.borBar[1],-819,(float) 490.5,(float) (AssetLoader.borBar[1].getWidth() * oyuncu.bor) / 2000, AssetLoader.borBar[1].getHeight());
					batchUi.draw(AssetLoader.borBar[0],-820,490);

					if(boostMode){
						batchUi.draw(AssetLoader.powerUpUi[0],-50 - (AssetLoader.powerUpUi[0].getWidth()),-450,((float) AssetLoader.powerUpUi[0].getWidth()) * 4,AssetLoader.powerUpUi[0].getHeight() * 2);
						batchUi.draw(AssetLoader.powerUpUi[1],-50 - (AssetLoader.powerUpUi[1].getWidth()),-450,((float) (AssetLoader.powerUpUi[1].getWidth() * (100 - sayacbo2)) / 100) * 4,AssetLoader.powerUpUi[1].getHeight() * 2);
					}

					batchUi.draw(AssetLoader.coin[0],-500,485);
					font.draw(batchUi,Integer.toString(oyuncu.coin), -440, 525);

					batchUi.draw(AssetLoader.researchUi, -310, 485);
					if(lvltype == 1){
						font.draw(batchUi,Integer.toString((int) (oyuncu.x / 200)) + "/" + Integer.toString((level + 1) * 200), -270, 525);
					}else {
						font.draw(batchUi,Integer.toString((int) (oyuncu.x / 200)), -270, 525);
					}
				}

				System.out.println(Gdx.input.getY()); //715 1015 1745 1865    735 1240		860 790		790 715
				switch (contType){
					case 0:
						batchUi.draw(AssetLoader.controls[0], (float) 960 - 48 - ((float) 122 * controlSize), -481, (float) 122 * controlSize, (float) 304 * controlSize);
						if(input.isTouched()){
							if((input.getX() > 1165 && input.getX() < 1250 && Gdx.graphics.getHeight() == 720 && Gdx.graphics.getWidth() == 1280) || (input.getX() > 1745 && input.getX() < 1860 && Gdx.graphics.getHeight() == 1080 && Gdx.graphics.getWidth() == 1920)){
								if(oyuncu.y < (1080 - oyuncu.img.getHeight()) && (input.getY() > 475 && input.getY() < 580 && Gdx.graphics.getHeight() == 720 && Gdx.graphics.getWidth() == 1280) || (input.getY() > 715 && input.getY() < 860 && Gdx.graphics.getHeight() == 1080 && Gdx.graphics.getWidth() == 1920)){
									oyuncu.y+=oyuncu.speed;
								}
								if(oyuncu.y > 0 && (input.getY() >= 580 && input.getY() < 685 && Gdx.graphics.getHeight() == 720 && Gdx.graphics.getWidth() == 1280) || (input.getY() >= 860 && input.getY() < 1010 && Gdx.graphics.getHeight() == 1080 && Gdx.graphics.getWidth() == 1920)){
									oyuncu.y-=oyuncu.speed;
								}
							}
						}
						break;
				}
				//System.out.printf("x: %d y: %d \n", input.getX(), input.getY());
				//System.out.println(Gdx.input.getX());
				if(died){
					batchUi.draw(AssetLoader.dieMenuBg, -263,-342,590,556);
					font.draw(batchUi,"YOUR SCORE",-200,141);
					font.draw(batchUi,Integer.toString((int) (oyuncu.x / 200)), -50, 83);
					font.draw(batchUi,"COINS",-90,23);
					while(sayacCS == 0) {
						prefs.putInteger("coin", coins + oyuncu.coin);
						prefs.flush();
						sayacCS = 1;
					}
					coins = prefs.getInteger("coin", 0);
					font.draw(batchUi,Integer.toString(oyuncu.coin), -50, -33);
					font.draw(batchUi,"HIGH SCORE",-200,-83);
					if(highScore < (int) (oyuncu.x / 200)) {
						prefs.putInteger("highScore", (int) oyuncu.x);
						prefs.flush();
					}
					highScore = prefs.getInteger("highScore", 0);
					font.draw(batchUi,Integer.toString(highScore),-50,-133);

			/*batchUi.draw(AssetLoader.btn[0],(float) -220,-278,220,64);
			font.draw(batchUi,"PLAY",-210,-230);
			batchUi.draw(AssetLoader.btn[0],(float) 48,-278,250,64);
			font.draw(batchUi,"MENU", 60, -230);*/

					batchUi.draw(AssetLoader.btn[1],(float) -220,-250,500,64);
					batchUi.draw(AssetLoader.btn[4],(float) -220,-320,500,64);

					System.out.printf("x: %d y: %d \n", input.getX(), input.getY()); // 1230 720 730 855
					if(input.isTouched()){
						if((524 > input.getY() && input.getY() > 483 && 495 < input.getX() && input.getX() < 825 && Gdx.graphics.getHeight() == 720 && Gdx.graphics.getWidth() == 1280) || (795 > input.getY() && 730 < input.getY() && 730 < input.getX() && input.getX() < 1230 && Gdx.graphics.getHeight() == 1080 && Gdx.graphics.getWidth() == 1920)){
							replayGame();
						}else if(((570 > input.getY() && input.getY() > 530) && (490 < input.getX() && input.getX() < 830) && Gdx.graphics.getHeight() == 720 && Gdx.graphics.getWidth() == 1280) || ((860 > input.getY() && 795 < input.getY()) && (735 < input.getX() && input.getX() < 1240) && Gdx.graphics.getHeight() == 1080 && Gdx.graphics.getWidth() == 1920)){
							backToMenu();
						}
					}
				}

				if((oyuncu.x / 200) >= (level + 1) * 200 && lvltype == 1){
					batchUi.draw(AssetLoader.dieMenuBg, -263,-342,590,556);
					font.draw(batchUi,"SUCCESS",-200,141);
					font.draw(batchUi,"COINS",-90,23);
					while(sayacCS == 0) {
						prefs.putInteger("coin", coins + oyuncu.coin);
						prefs.flush();
						sayacCS = 1;
					}
					coins = prefs.getInteger("coin", 0);
					font.draw(batchUi,Integer.toString(oyuncu.coin), -50, -33);
					prefs.putInteger("savedLvl",level + 1);
					prefs.flush();
					savedLvl = prefs.getInteger("savedLvl", level);
					for(int i = 0; i < objeler.size(); i++){
						objeler.get(i).speed = 0;
					}
				}

				batchUi.end();
				break;
			case 3: //settings

				break;
			case 4: //leaderboards

				break;
		}

	}

	private void replayGame(){
		enlvl=1;boostMode = false;invisibility = false; died = false;
		sayac=0;sayacb=0;sayacc=0;sayacr=0;sayacu=0;sayacmg=0;sayacw=0;sayace=0;sayacbo=0;sayacbo2=0;sayacbm=0;enlvl=-1;puan=0;coin=0;
		objeler.clear();
		powerups.clear();
		oyuncu.coin = 0;
		oyuncu.bor = 2000;
		oyuncu = null;
		oyuncu = new player(50,50,contType,selectionShip);
		objeler.add(oyuncu);
		sayac=0;sayacb=0;sayacc=0;sayacr=0;sayacu=0;sayacmg=0;sayacw=0;sayace=0;sayacbo=0;sayacbo2=0;sayacbm=0;enlvl=-1;puan=0;coin=0;
	}

	private void backToMenu(){
		enlvl=1;boostMode = false;invisibility = false; died = false;
		sayac=0;sayacb=0;sayacc=0;sayacr=0;sayacu=0;sayacmg=0;sayacw=0;sayace=0;sayacbo=0;sayacbo2=0;sayacbm=0;enlvl=-1;puan=0;coin=0;
		objeler.clear();
		powerups.clear();
		oyuncu.coin = 0;
		oyuncu.bor = 2000;
		oyuncu = null;
		oyuncu = new player(50,50,contType,selectionShip);
		sayac=0;sayacb=0;sayacc=0;sayacr=0;sayacu=0;sayacmg=0;sayacw=0;sayace=0;sayacbo=0;sayacbo2=0;sayacbm=0;enlvl=-1;puan=0;coin=0;
		state = 0;
		camera.position.set(960,540,0);
		camera.update();
	}

	private void unknownPlanet(){
		int sayacup = 0;
		sayacup++;
		if(sayacup < 20){
			font.draw(batch,"You haven't discovered this planet yet.", 150, 700);
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		batchUi.dispose();
		img.dispose();
		AssetLoader.menu.dispose();
		AssetLoader.game.dispose();
	}



}
