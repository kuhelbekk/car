package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Puzzle8 extends PuzzleScene {

	public Puzzle8(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/puzzle8.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("1"),
				1, 133, 800 - 543));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("2"),
				2, 824, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("3"),
				3, 710, 800 - 255));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("4"),
				4, 445, 800 - 393));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("5"),
				5, 224, 800 - 323));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("6"),
				6, 133, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("7"),
				7, 445, 800 - 168));

	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzle2.8");
		game.setScreen(new Puzzle9(game));
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
