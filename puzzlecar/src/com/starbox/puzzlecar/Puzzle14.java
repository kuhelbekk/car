package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Puzzle14 extends PuzzleScene {

	public Puzzle14(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/puzzle14.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("1"),
				1, 7 + 127, 800 - 153 - 18));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("2"),
				2, 215 + 127, 800 - 153 - 18));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("3"),
				5, 554 + 127, 800 - 284 - 18));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("4"),
				3, 411, 800 - 519));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("5"),
				4, 7 + 127, 800 - 345 - 18));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("6"),
				6, 671 + 127, 800 - 153 - 18));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("7"),
				7, 845, 800 - 463));
	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzle14");
		game.setScreen(new Puzzle4(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 228;
		case 1:
			return 316;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 520;
		case 1:
			return 588;
		default:
			return -300;
		}
	}

}
