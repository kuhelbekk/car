package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PuzzleScrCar12 extends PuzzleScene {

	public PuzzleScrCar12(MainClass game) {
		super(game);

	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/car12.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("door"), 1, 476 + 128, 800 - 354 - 16,
				"door"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("kapot"), 7, 141 + 128, 800 - 376 - 16, "kapot"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("bamper"), 3, 112 + 128, 800 - 488 - 16, "bamper"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("fary"), 5, 122 + 128, 800 - 452 - 16,
				"fary"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("window_f"), 8, 313 + 128, 800 - 303 - 16,
				"windscreen"));
		elementList
				.add(new PuzzleElement(this, textureAtlas
						.findRegion("window_b"), 4, 783 + 128, 800 - 318 - 16,
						"window"));
		PuzzleElement w1 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_b"), 6, 742 + 128,
				800 - 467 - 16, "weel");// 389
		PuzzleElement w2 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_f"), 2, 299 + 128,
				800 - 572 - 16, "weel");// 529
		w1.setSameElement(w2);
		elementList.add(w1);
		elementList.add(w2);
	}

	protected void endScene() {

		Gdx.app.log("EndScene", "EndPuzzleCar12");
		game.setScreen(new PuzzleScrCar3(game));
		// game.setScreen(new PuzzleScrCar2(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 268;
		case 1:
			return 375;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 498;
		case 1:
			return 592;
		default:
			return -300;
		}
	}

}
