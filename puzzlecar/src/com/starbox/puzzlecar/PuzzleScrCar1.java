package com.starbox.puzzlecar;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PuzzleScrCar1 extends PuzzleScene {

	public PuzzleScrCar1(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/car1.atlas");
		super.createScene();
		elementList
				.add(new PuzzleElement(this,
						textureAtlas.findRegion("migalka"), 2, 495 + 128,
						800 - 194 - 20, "flasher"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("kapot"), 5, 135 + 128, 800 - 395 - 20, "kapot"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("door"), 3, 466 + 128, 800 - 307 - 20,
				"door"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("backdoor"), 1, 670 + 128, 800 - 267 - 20, "door"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("fary"), 8, 104 + 128, 800 - 462 - 20,
				"fary"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("lobovuha"), 6, 301 + 128, 800 - 288 - 20,
				"windscreen"));
		PuzzleElement w1 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_f"), 7, 277 + 128,
				800 - 571 - 20, "weel");
		PuzzleElement w2 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_b"), 4, 740 + 128,
				800 - 433 - 20, "weel");
		w1.setSameElement(w2);
		elementList.add(w1);
		elementList.add(w2);
	}

	protected void endScene() {

		Gdx.app.log("EndScene", "EndPuzzleCar1");
		if (!game.isPremium()) {
			game.setScreen(game.menu2d);
			game.menu2d.showPayFrame();

		} else {
			game.setScreen(new PuzzleScrCar8(game));
		}

		super.endScene();

	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 247;
		case 1:
			return 367;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 523;
		case 1:
			return 615;
		default:
			return -300;
		}
	}

}
