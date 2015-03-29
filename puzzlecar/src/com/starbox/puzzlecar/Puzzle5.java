package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Puzzle5 extends PuzzleScene {

	public Puzzle5(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/puzzle5.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("1"),
				1, 133, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("2"),
				2, 630, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("3"),
				3, 458, 800 - 291));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("4"),
				4, 133, 800 - 588));
	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzle2.5");
		game.setScreen(new Puzzle7(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 318;
		case 1:
			return 539;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 462;
		case 1:
			return 581;
		default:
			return -300;
		}
	}
}
