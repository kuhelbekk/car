package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Puzzle12 extends PuzzleScene {

	public Puzzle12(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/puzzle12.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("1"),
				1, 133, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("2"),
				2, 263, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("3"),
				3, 596, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("4"),
				4, 351, 800 - 173));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("5"),
				5, 720, 800 - 174));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("6"),
				6, 848, 800 - 463));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("7"),
				7, 375, 800 - 560));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("8"),
				8, 133, 800 - 274));

	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzle2.12");
		game.setScreen(new Puzzle13(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 268;
		case 1:
			return 375;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 498;
		case 1:
			return 592;
		default:
			return -300;
		}
	}

}
