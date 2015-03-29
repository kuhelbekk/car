package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Puzzle13 extends PuzzleScene {

	public Puzzle13(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/puzzle13.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("1"),
				1, 133, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("2"),
				2, 372, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("3"),
				3, 691, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("4"),
				4, 795, 800 - 172));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("5"),
				5, 971, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("6"),
				6, 371, 800 - 273));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("7"),
				7, 796, 800 - 476));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("8"),
				8, 507, 800 - 476));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("9"),
				9, 133, 800 - 572));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("10"),
				10, 277, 800 - 400));
	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzle2.13");
		game.setScreen(new Puzzle14(game));
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
