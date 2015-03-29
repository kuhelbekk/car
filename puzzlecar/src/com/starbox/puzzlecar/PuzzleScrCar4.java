package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PuzzleScrCar4 extends PuzzleScene {

	public PuzzleScrCar4(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/car4.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("kabina"), 1, 300 + 128, 800 - 297 - 16, "kabina"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("bamper"), 5, 225 + 128, 800 - 516 - 16, "bamper"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("fary"), 2, 244 + 128, 800 - 489 - 16,
				"fary"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("kuzov_full"), textureAtlas
				.findRegion("kuzov_crop"), 4, 420 + 128, 800 - 173 - 16,
				"kuzov"));

		PuzzleElement w1 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),/*
												 * textureAtlas.findRegion("wheel"
												 * ),
												 */6, 423 + 128,
				800 - 539 - 16, "weel");
		PuzzleElement w2 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),/*
												 * textureAtlas.findRegion(
												 * "wheel_for"),
												 */3, 619 + 128,
				800 - 452 - 16, "weel");
		w1.setSameElement(w2);
		elementList.add(w1);
		elementList.add(w2);
	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzleCar4");
		game.setScreen(new PuzzleScrCar13(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 390;
		case 1:
			return 491;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 534;
		case 1:
			return 593;
		default:
			return -300;
		}
	}

	// 261õ512 è 365õ572
}
