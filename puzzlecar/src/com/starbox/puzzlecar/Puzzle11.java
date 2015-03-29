package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Puzzle11 extends PuzzleScene {

	public Puzzle11(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/puzzle11.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("1"),
				2, 133, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("2"),
				1, 176, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("3"),
				3, 366, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("4"),
				4, 789, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("5"),
				5, 626, 800 - 410));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("6"),
				6, 188, 800 - 473));
	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzle2.11");

		game.setScreen(new Puzzle12(game));
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
