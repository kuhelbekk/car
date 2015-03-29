package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Puzzle7 extends PuzzleScene {

	public Puzzle7(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/puzzle7.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("1"),
				6, 133, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("2"),
				2, 878, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("3"),
				3, 210, 800 - 231));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("4"),
				4, 697, 800 - 341));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("5"),
				5, 133, 800 - 348));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("6"),
				1, 373, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("7"),
				7, 559, 800 - 518));

	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzle2.7");
		game.setScreen(new Puzzle8(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 4;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 323;
		case 1:
			return 532;
		case 2:
			return 607;
		case 3:
			return 714;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 476;
		case 1:
			return 586;
		case 2:
			return 197;
		case 3:
			return 244;
		default:
			return -300;
		}
	}

}
