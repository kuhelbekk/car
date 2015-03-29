package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PuzzleScrCar14 extends PuzzleScene {

	public PuzzleScrCar14(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/car14.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("kuzov"), textureAtlas.findRegion("kuzov_crop"), 1,
				283 + 127, 800 - 188 + 19, "kuzov"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("door"), 3, 241 + 127, 800 - 388 + 19,
				"door"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("benzobak"), 5, 466 + 127, 800 - 500 + 19, "benz"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("lobovuha"), 7, 117 + 127, 800 - 351 + 19,
				"windscreen"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("fary"), 4, 89 + 127, 800 - 512 + 19,
				"fary"));
		PuzzleElement w1 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel_b"),
				textureAtlas.findRegion("wheel_b_crop"), 6, 607 + 127,
				800 - 474 + 19, "weels");// 389
		PuzzleElement w2 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_f"), 2, 282 + 127,
				800 - 573 + 19, "weel");// 529
		w1.setSameElement(w2);
		elementList.add(w1);
		elementList.add(w2);
	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzleCar14");
		game.setScreen(new PuzzleScrCar15(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 228;
		case 1:
			return 316;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 520;
		case 1:
			return 588;
		default:
			return -300;
		}
	}

}
