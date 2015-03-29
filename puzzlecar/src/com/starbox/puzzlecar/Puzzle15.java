package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Puzzle15 extends PuzzleScene {

	public Puzzle15(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/puzzle15.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("1"),
				1, 133, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("2"),
				2, 245, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("3"),
				3, 722, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("4"),
				4, 1006, 800 - 247));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("5"),
				5, 787, 800 - 385));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("6"),
				6, 594, 800 - 547));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("7"),
				7, 257, 800 - 363));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("8"),
				8, 133, 800 - 425));

	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzle2.15");

		if (!game.isPremium()) {
			game.setScreen(game.menu2d);
			game.menu2d.showPayFrame();

		} else {
			game.setScreen(new Puzzle1(game));
		}
		super.endScene();
	}

	protected int carLightCount() {
		return 4;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 236;
		case 1:
			return 369;
		case 2:
			return 202;
		case 3:
			return 308;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 469;
		case 1:
			return 578;
		case 2:
			return 579;
		case 3:
			return 652;
		default:
			return -300;
		}
	}

}
