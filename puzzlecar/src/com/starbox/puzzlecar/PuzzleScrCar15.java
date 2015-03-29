package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PuzzleScrCar15 extends PuzzleScene {

	public PuzzleScrCar15(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/car15.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("seats"), 1, 561 + 127, 800 - 257 - 19, "seat"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("kapot"), 7, 88 + 127, 800 - 383 - 19, "kapot"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("door"), 3, 471 + 127, 800 - 399 - 19,
				"door"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("fary"), 5, 61 + 127, 800 - 418 - 19,
				"fary"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("lobovuha"), 4, 228 + 127, 800 - 277 - 19,
				"windscreen"));
		PuzzleElement w1 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_b"), 6, 767 + 127,
				800 - 420 - 19, "weel");// 389
		PuzzleElement w2 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_f"), 2, 287 + 127,
				800 - 557 - 19, "weel");// 529
		w1.setSameElement(w2);
		elementList.add(w1);
		elementList.add(w2);
	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzleCar15");
		game.setScreen(new PuzzleScrCar16(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 4;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 236;
		case 1:
			return 369;
		case 2:
			return 202;
		case 3:
			return 308;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 469;
		case 1:
			return 578;
		case 2:
			return 579;
		case 3:
			return 652;
		default:
			return -300;
		}
	}

}
