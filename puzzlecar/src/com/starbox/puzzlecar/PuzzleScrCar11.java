package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PuzzleScrCar11 extends PuzzleScene {

	public PuzzleScrCar11(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/car11.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("door"), 1, 399 + 127, 800 - 326 - 19,
				"door"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("kapot"), 7, 95 + 127, 800 - 377 - 19, "kapot"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("kuzov"), 5, 565 + 127, 800 - 264 - 18, "kuzov"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("lobovuha"), 4, 194 + 127, 800 - 264 - 19,
				"windscreen"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("fary"), 3, 85 + 127, 800 - 446 - 19,
				"fary"));
		PuzzleElement w1 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_f"), 6, 293 + 127,
				800 - 571 - 19, "weel");// 389
		PuzzleElement w2 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_b"), 2, 760 + 127,
				800 - 459 - 19, "weel");// 529
		w1.setSameElement(w2);
		elementList.add(w1);
		elementList.add(w2);
	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzleCar11");
		game.setScreen(new PuzzleScrCar14(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 226;
		case 1:
			return 361;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 515;
		case 1:
			return 611;
		default:
			return -300;
		}
	}

}
