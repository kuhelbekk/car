package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PuzzleScrCar9 extends PuzzleScene {

	public PuzzleScrCar9(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/car9.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("excov"), 1, 145 + 128, 800 - 398 - 19, "blade")); // 138
																				// 410
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("kovsh_full"), textureAtlas
				.findRegion("kovsh_crop"), 3, 409 + 128, 800 - 153 - 19,
				"dipper"));
		elementList.add(new PuzzleElement(this, textureAtlas
				.findRegion("kabin_full"), textureAtlas
				.findRegion("kabin_crop"), 4, 528 + 128, 800 - 233 - 19,
				"kabina"));
		PuzzleElement w1 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"), 5, 463 + 128, 800 - 518 - 19,
				"weel");
		PuzzleElement w2 = new PuzzleElement(this,
				textureAtlas.findRegion("wheel"),
				textureAtlas.findRegion("wheel_back"), 2, 663 + 128,
				800 - 476 - 19, "weel");// 529
		w1.setSameElement(w2);
		elementList.add(w1);
		elementList.add(w2);
	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzleCar9");
		game.setScreen(new PuzzleScrCar5(game));
		super.endScene();
	}
}
