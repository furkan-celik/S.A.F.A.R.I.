package com.titak.bothan;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by gamew on 24.12.2016.
 */

public class AssetLoader {
    public static Texture bor,rocket,uplink,caution,researchUi,dieMenuBg,selection;
    public static Texture[] meteors,meteorsGravit,enemys,lasers,pUps,coin,borBar,powerUpUi,btn,planets,player,background,buy,controls,planetsBW;
    public static Music menu,game;

    AssetLoader(){
        background = new Texture[10];
        background[0] = new Texture("background/bg1.png");
        background[1] = new Texture("background/bg2.png");
        background[2] = new Texture("background/bg3.png");
        background[3] = new Texture("background/bg4.png");
        background[4] = new Texture("background/bg5.png");
        background[5] = new Texture("background/bg6.png");
        background[6] = new Texture("background/bg7.png");
        background[7] = new Texture("background/bg8.png");
        background[8] = new Texture("background/bg9.png");
        background[9] = new Texture("background/bg10.png");
        player = new Texture[6];
        player[0] = new Texture("player/playerShip1_blue.png");
        player[1] = new Texture("player/playerShip1_red.png");
        player[2] = new Texture("player/playerShip2_blue.png");
        player[3] = new Texture("player/playerShip2_red.png");
        player[4] = new Texture("player/playerShip3_blue.png");
        player[5] = new Texture("player/playerShip3_red.png");
        buy = new Texture[5];
        buy[0] = new Texture("buy/b100.png");
        buy[1] = new Texture("buy/b200.png");
        buy[2] = new Texture("buy/b400.png");
        buy[3] = new Texture("buy/b800.png");
        buy[4] = new Texture("buy/b1000.png");
        bor = new Texture("fuel.png");
        coin = new Texture[4];
        coin[0] = new Texture("coin.png");
        coin[1] = new Texture("coins1.png");
        coin[2] = new Texture("coins2.png");
        coin[3] = new Texture("coins3.png");
        rocket = new Texture("lasers/rocket.png");
        uplink = new Texture("lasers/uc3.png");
        meteors = new Texture[4];
        meteors[0] = new Texture("meteors/meteorGrey_big3.png");
        meteors[1] = new Texture("meteors/meteorGrey_med2.png");
        meteors[2] = new Texture("meteors/meteorGrey_small1.png");
        meteors[3] = new Texture("meteors/meteorGrey_tiny1.png");
        meteorsGravit = new Texture[4];
        meteorsGravit[0] = new Texture("meteors/meteorBrown_big1.png");
        meteorsGravit[1] = new Texture("meteors/meteorBrown_med3.png");
        meteorsGravit[2] = new Texture("meteors/meteorBrown_small2.png");
        meteorsGravit[3] = new Texture("meteors/meteorBrown_tiny1.png");
        enemys = new Texture[4];
        enemys[0] = new Texture("enemy/enemyBlack1.png");
        enemys[1] = new Texture("enemy/enemyBlack2.png");
        enemys[2] = new Texture("enemy/enemyBlack3.png");
        enemys[3] = new Texture("enemy/enemyBlack4.png");
        lasers = new Texture[2];
        lasers[0] = new Texture("lasers/laserGreen12.png");
        lasers[1] = new Texture("lasers/laserRed06.png");
        pUps = new Texture[3];
        pUps[1] = new Texture("pUps/boost.png");
        pUps[0] = new Texture("pUps/fire.png");
        pUps[2] = new Texture("pUps/test.png");
        caution = new Texture("ui/caution.png");
        borBar = new Texture[2];
        borBar[0] = new Texture("ui/borTemp.png");
        borBar[1] = new Texture("ui/borBar.png");
        powerUpUi = new Texture[3];
        powerUpUi[0] = new Texture("ui/pupsUiEmpty.png");
        powerUpUi[1] = new Texture("ui/boost.png");
        powerUpUi[2] = new Texture("ui/fire.png");
        researchUi = new Texture("ui/exclamation.png");
        btn = new Texture[5];
        btn[0] = new Texture("ui/button.png");
        btn[1] = new Texture("ui/button_play.png");
        btn[2] = new Texture("ui/button_leaderbord_big.png");
        btn[3] = new Texture("ui/button_settings.png");
        btn[4] = new Texture("ui/button_mainMenu.png");
        dieMenuBg = new Texture("ui/dieMenuBg.png");
        planets = new Texture[10];
        planets[0] = new Texture("planets/planet1.png");
        planets[1] = new Texture("planets/planet2.png");
        planets[2] = new Texture("planets/planet3.png");
        planets[3] = new Texture("planets/planet4.png");
        planets[4] = new Texture("planets/planet5.png");
        planets[5] = new Texture("planets/planet6.png");
        planets[6] = new Texture("planets/planet7.png");
        planets[7] = new Texture("planets/planet8.png");
        planets[8] = new Texture("planets/planet9.png");
        planets[9] = new Texture("planets/planet10.png");
        planetsBW = new Texture[10];
        planetsBW[0] = new Texture("planets/planet1.png");
        planetsBW[1] = new Texture("planets/planet2bw.png");
        planetsBW[2] = new Texture("planets/planet3bw.png");
        planetsBW[3] = new Texture("planets/planet4bw.png");
        planetsBW[4] = new Texture("planets/planet5bw.png");
        planetsBW[5] = new Texture("planets/planet6bw.png");
        planetsBW[6] = new Texture("planets/planet7bw.png");
        planetsBW[7] = new Texture("planets/planet8bw.png");
        planetsBW[8] = new Texture("planets/planet9bw.png");
        planetsBW[9] = new Texture("planets/planet10bw.png");
        selection = new Texture("ui/selection.png");
        controls = new Texture[3];
        controls[0] = new Texture("ui/oneHandControl.png");
        controls[1] = new Texture("ui/cUp.png");
        controls[2] = new Texture("ui/cDown.png");

        menu = Gdx.audio.newMusic(Gdx.files.internal("music/menu.mp3"));
        game = Gdx.audio.newMusic(Gdx.files.internal("music/menu.mp3"));
    }
}
