package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PuzzleScrCar10 extends PuzzleScene {

	public PuzzleScrCar10(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/car10.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("door"), 1, 558 + 128, 800 - 318 - 20,
				"door"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("kapot"), 7, 169 + 128, 800 - 370 - 20, "kapot"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("bamper"), 3, 114 + 128, 800 - 503 - 20, "bamper"));
		elementList
				.add(new PuzzleElement(this,
						textureAtlas.findRegion("spoiler"), 4, 705 + 128,
						800 - 163 - 20, "spoiler"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("lobovuha"), 5, 354 + 128, 800 - 288 - 20,
				"windscreen"));
		PuzzleElement w1 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_f"), 6, 367 + 128,
				800 - 527 - 20, "weel");// 389
		PuzzleElement w2 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_b"), 2, 735 + 128,
				800 - 372 - 20, "weel");// 529
		w1.setSameElement(w2);
		elementList.add(w1);
		elementList.add(w2);
	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzleCar10");
		game.setScreen(new PuzzleScrCar1(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 307;
		case 1:
			return 479;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 485;
		case 1:
			return 595;
		default:
			return -300;
		}
	}

}
