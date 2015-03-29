package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Puzzle10 extends PuzzleScene {

	public Puzzle10(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/puzzle10.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("1"),
				1, 133, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("2"),
				2, 641, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("3"),
				5, 803, 800 - 199));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("4"),
				6, 187, 800 - 239));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("5"),
				7, 634, 800 - 304));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("6"),
				8, 412, 800 - 347));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("7"),
				9, 133, 800 - 364));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("8"),
				3, 856, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("9"),
				4, 352, 800 - 168));
	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzle2.10");

		game.setScreen(new Puzzle11(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 307;
		case 1:
			return 479;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 485;
		case 1:
			return 595;
		default:
			return -300;
		}
	}

}
