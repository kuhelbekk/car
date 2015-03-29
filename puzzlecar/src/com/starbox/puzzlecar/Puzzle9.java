package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Puzzle9 extends PuzzleScene {

	public Puzzle9(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/puzzle9.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("1"),
				1, 133, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("2"),
				3, 586, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("3"),
				4, 667, 800 - 352));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("4"),
				5, 223, 800 - 249));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("5"),
				6, 133, 800 - 434));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("6"),
				2, 402, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("7"),
				7, 586, 800 - 447));

	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzle2.9");
		game.setScreen(new Puzzle10(game));
		super.endScene();
	}

}
