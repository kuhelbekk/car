package com.starbox.puzzlecar;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class FinishStar extends Image {

	private final AnimationDrawable drawable;

	public boolean isFinished() {
		if (drawable.isEndAnim())
			return true;
		return false;
	}

	@Override
	public void act(float delta) {
		drawable.act(delta);
		super.act(delta);

	}

	public FinishStar(AnimationDrawable drawable) {
		super(drawable);
		this.drawable = drawable;
	}

	public void play() {
		drawable.play();
	}
}
