package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PuzzleScrCar7 extends PuzzleScene {

	public PuzzleScrCar7(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/car7.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("door"), 5, 548 + 128, 800 - 343 + 5,
				"door"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("kapot"), 7, 187 + 128, 800 - 363 + 5, "kapot"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("bamper"), 3, 160 + 128, 800 - 479 + 5, "bamper"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("rama"), 1, 441 + 128, 800 - 155 + 5,
				"rama"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("window"), 4, 293 + 128, 800 - 285 + 5,
				"windscreen"));
		PuzzleElement w1 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_b"), 6, 651 + 128,
				800 - 381 + 5, "weel");// 389
		PuzzleElement w2 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_f"), 2, 421 + 128,
				800 - 521 + 5, "weel");// 529
		w1.setSameElement(w2);
		elementList.add(w1);
		elementList.add(w2);
	}

	protected void endScene() {
		super.endScene();
		Gdx.app.log("EndScene", "EndPuzzleCar7");
		game.setScreen(new PuzzleScrCar9(game));

		// game.setScreen(game.menu2d);
	}

	protected int carLightCount() {
		return 4;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 323;
		case 1:
			return 532;
		case 2:
			return 607;
		case 3:
			return 714;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 476;
		case 1:
			return 586;
		case 2:
			return 197;
		case 3:
			return 244;
		default:
			return -300;
		}
	}

}
