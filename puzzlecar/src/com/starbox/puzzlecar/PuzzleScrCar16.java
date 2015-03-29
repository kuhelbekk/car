package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PuzzleScrCar16 extends PuzzleScene {

	public PuzzleScrCar16(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/car16.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("seat_full"), textureAtlas.findRegion("seat_crop"),	5, 607 + 127, 800 - 287 - 19, "seat"));
		elementList.add(new PuzzleElement(this,	textureAtlas.findRegion("fary"), 7, 255 + 127, 800 - 351 - 19,	"fary"));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("rul"),		2, 551 + 127, 800 - 217 - 19, "rul"));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("engine"), textureAtlas.findRegion("engine_crop"),	3, 390 + 127, 800 - 361 - 19, "engine"));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("truba"), 1, 331 + 127, 800 - 207 - 19, "truba"));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("wheels_f"), 6, 146 + 127, 800 - 472 - 19, "weels"));// 389
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("wheel_b"), 4, 641 + 127, 800 - 314 - 19, "weel"));// 529

	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzleCar16");
		game.setScreen(new PuzzleScrCar4(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 398;
		case 1:
			return 505;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 519;
		case 1:
			return 532;
		default:
			return -300;
		}
	}

}
