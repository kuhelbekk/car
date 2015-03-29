package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Puzzle6 extends PuzzleScene {

	public Puzzle6(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/puzzle6.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("1"),
				1, 133, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("2"),
				2, 320, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("3"),
				3, 881, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("4"),
				4, 739, 800 - 374));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("5"),
				5, 140, 800 - 552));

	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzle2.6");
		game.setScreen(new Puzzle15(game));
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
