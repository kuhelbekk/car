package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PuzzleScrCar5 extends PuzzleScene {

	public PuzzleScrCar5(MainClass game) {
		super(game);

	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/car5.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("door"), 1, 545 + 128, 800 - 288 - 16,
				"door"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("radiator"), 3, 178 + 128, 800 - 533 - 16,
				"radiator"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("fary"), 5, 176 + 128, 800 - 395 - 16,
				"fary"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("window"), 4, 341 + 128, 800 - 249 - 16,
				"windscreen"));
		PuzzleElement w1 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel_b_full"),
				textureAtlas.findRegion("wheel_b"), 6, 662 + 128,
				800 - 377 - 16, "weel");
		PuzzleElement w2 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel_f_full"),
				textureAtlas.findRegion("wheel_f"), 2, 414 + 128,
				800 - 512 - 16, "weel");
		w1.setSameElement(w2);
		elementList.add(w1);
		elementList.add(w2);
	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzleCar5");
		game.setScreen(new PuzzleScrCar12(game));
		super.endScene();

	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 318;
		case 1:
			return 539;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 462;
		case 1:
			return 581;
		default:
			return -300;
		}
	}

}
