package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Puzzle16 extends PuzzleScene {

	public Puzzle16(MainClass game) {
		super(game);
	}

	public void createScene() {
		textureAtlas = new TextureAtlas("data/puzzle16.atlas");
		super.createScene();
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("1"),
				1, 135, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("2"),
				2, 520, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("3"),
				3, 702, 800 - 168));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("4"),
				4, 995, 800 - 519));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("5"),
				5, 616, 800 - 216));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("6"),
				6, 774, 800 - 443));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("7"),
				7, 650, 800 - 623));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("8"),
				8, 369, 800 - 446));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("9"),
				9, 368, 800 - 683));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("10"),
				10, 272, 800 - 292));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("11"),
				11, 286, 800 - 288));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("12"),
				12, 133, 800 - 180));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("13"),
				13, 133, 800 - 471));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("14"),
				14, 133, 800 - 592));
		elementList.add(new PuzzleElement(this, textureAtlas.findRegion("15"),
				15, 865, 800 - 332));

	}

	protected void endScene() {
		Gdx.app.log("EndScene", "EndPuzzle2.16");
		game.setScreen(new Puzzle2(game));
		super.endScene();
	}

	protected int carLightCount() {
		return 2;
	}

	protected float getCarLightX(int index) {
		switch (index) {
		case 0:
			return 398;
		case 1:
			return 505;
		default:
			return -300;
		}
	}

	protected float getCarLightY(int index) {
		switch (index) {
		case 0:
			return 519;
		case 1:
			return 532;
		default:
			return -300;
		}
	}

}
