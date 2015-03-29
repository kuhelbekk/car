package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Puzzle3 extends PuzzleScene {

	public Puzzle3(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/puzzle3.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("1"),
				1, 133, 800 - 169));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("2"),
				2, 404, 800 - 236));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("3"),
				3, 635, 800 - 169));
	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzle2.3");
		game.setScreen(new Puzzle6(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 259;
		case 1:
			return 461;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 558;
		case 1:
			return 623;
		default:
			return -300;
		}
	}

}
