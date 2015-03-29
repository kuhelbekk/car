package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PuzzleScrCar13 extends PuzzleScene {

	public PuzzleScrCar13(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/car13.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("seat"), textureAtlas
						.findRegion("seat_crop"), 1, 548 + 128, 800 - 406 - 16,
				"seat"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("kapot"), 7, 190 + 128, 800 - 367 - 16, "kapot"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("bamper"), 3, 108 + 128, 800 - 412 - 16, "bamper"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("truba"), 5, 615 + 128, 800 - 209 - 16, "rama"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("window"), 4, 409 + 128, 800 - 241 - 16,
				"windscreen"));
		PuzzleElement w1 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"), 6, 306 + 128, 800 - 583 - 16,
				"weel");// 389
		PuzzleElement w2 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"), 2, 731 + 128, 800 - 496 - 16,
				"weel");// 529
		w1.setSameElement(w2);
		elementList.add(w1);
		elementList.add(w2);
	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzleCar13");
		game.setScreen(new PuzzleScrCar10(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 309;
		case 1:
			return 388;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 475;
		case 1:
			return 544;
		default:
			return -300;
		}
	}

}
