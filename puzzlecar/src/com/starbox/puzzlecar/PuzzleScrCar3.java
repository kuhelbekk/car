package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PuzzleScrCar3 extends PuzzleScene {

	public PuzzleScrCar3(MainClass game) {
		super(game);

	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/car3.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("bamper"), 1, 111 + 128, 800 - 568 - 20, "bamper"));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("luk"),
				2, 337 + 128, 800 - 219 - 20, "luk"));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("lob"),
				3, 140 + 128, 800 - 311 - 20, "windscreen"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("door"), 4, 547 + 128, 800 - 275 - 20,
				"door"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("fary"), 5, 107 + 128, 800 - 496 - 20,
				"fary"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("stekla"), 6, 674 + 128, 800 - 194 - 20, "window"));
		PuzzleElement w1 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_forward"), 7, 372 + 128,
				800 - 562 - 20, "weel");
		PuzzleElement w2 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_back"), 8, 740 + 128,
				800 - 371 - 20, "weel");
		w1.setSameElement(w2);
		elementList.add(w1);
		elementList.add(w2);

	}

	protected void endScene() {

		Gdx.app.log("EndScene", "EndPuzzleCar3");
		game.setScreen(new PuzzleScrCar2(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 259;
		case 1:
			return 461;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 558;
		case 1:
			return 623;
		default:
			return -300;
		}
	}
}