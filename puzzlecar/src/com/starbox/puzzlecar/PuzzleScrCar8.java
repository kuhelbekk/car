package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PuzzleScrCar8 extends PuzzleScene {

	public PuzzleScrCar8(MainClass game) {
		super(game);

	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/car8.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("door"), 8, 382 + 128, 800 - 328 - 16,
				"door"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("ladder"), 1, 479 + 128, 800 - 175 - 16, "ladder"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("bamper"), 3, 110 + 128, 800 - 586 - 16, "bamper"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("fary"), 5, 127 + 128, 800 - 521 - 16,
				"fary"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("window"), 4, 141 + 128, 800 - 333 - 16,
				"windscreen"));
		elementList.add(new PuzzleElement(this,
				textureAtlas.findRegion("pult"), 7, 566 + 128, 800 - 398 - 16,
				"board"));
		elementList
				.add(new PuzzleElement(this,
						textureAtlas.findRegion("migalki"), 2, 300 + 128,
						800 - 249 - 16, "flasher"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("shlang"), 10, 713 + 128, 800 - 296 - 16, "hose"));
		PuzzleElement w1 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel_b"),
				textureAtlas.findRegion("wheel_b_crop"), 6, 739 + 128,
				800 - 390 - 16, "weel");// 389
		PuzzleElement w2 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel_f"),
				textureAtlas.findRegion("wheel_f_crop"), 9, 371 + 128,
				800 - 552 - 16, "weel");// 529
		w1.setSameElement(w2);
		elementList.add(w1);
		elementList.add(w2);
	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzleCar8");
		game.setScreen(new PuzzleScrCar7(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 270;
		case 1:
			return 444;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 591;
		case 1:
			return 647;
		default:
			return -300;
		}
	}

}
