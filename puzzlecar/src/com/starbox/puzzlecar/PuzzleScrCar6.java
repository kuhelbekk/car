package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PuzzleScrCar6 extends PuzzleScene {

	public PuzzleScrCar6(MainClass game) {
		super(game);

	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/car6.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("kapot"), 1, 104 + 128, 800 - 384 - 20, "kapot"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("door_f"), 3, 456 + 128, 800 - 341 - 20, "door"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("door_b"), 7, 653 + 128, 800 - 320 - 20, "door"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("fary"), 5, 94 + 128, 800 - 477 - 20,
				"fary"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("lobovuha"), 4, 282 + 128, 800 - 299 - 20,
				"windscreen"));
		PuzzleElement w1 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_b"), 6, 751 + 128,
				800 - 427 - 20, "weel");
		PuzzleElement w2 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_f"), 2, 273 + 128,
				800 - 558 - 20, "weel");
		w1.setSameElement(w2);
		elementList.add(w1);
		elementList.add(w2);
	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzleCar6");
		game.setScreen(new PuzzleScrCar11(game));
		// game.setScreen(new PuzzleScrCar4(game));
		super.endScene();

	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 234;
		case 1:
			return 350;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 524;
		case 1:
			return 613;
		default:
			return -300;
		}
	}

}
