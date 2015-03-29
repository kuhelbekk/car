package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PuzzleScrCar2 extends PuzzleScene {

	public PuzzleScrCar2(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/car2.atlas");
		super.createScene();
		elementList
				.add(new PuzzleElement(this,
						textureAtlas.findRegion("migalka"), 1, 369 + 128,
						800 - 198 - 16, "flasher"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("window"), 7, 173 + 128, 800 - 329 - 17,
				"windscreen"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("door"), 3, 406 + 128, 800 - 355 - 16,
				"door"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("fary"), 4, 125 + 128, 800 - 521 - 16,
				"fary"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("emblem"), 6, 700 + 128, 800 - 258 - 16, "emblem"));
		PuzzleElement w1 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("f_wheel"), 5, 435 + 128,
				800 - 574 - 16, "weel");
		PuzzleElement w2 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("b_wheel"), 2, 784 + 128,
				800 - 411 - 16, "weel");
		w1.setSameElement(w2);
		elementList.add(w1);
		elementList.add(w2);
	}

	protected void endScene() {

		Gdx.app.log("EndScene", "EndPuzzleCar2");
		game.setScreen(new PuzzleScrCar6(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 272;
		case 1:
			return 469;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 562;
		case 1:
			return 632;
		default:
			return -300;
		}
	}
}
