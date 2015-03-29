package com.starbox.puzzlecar;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Stars extends Image {
	private final AnimationDrawable drawable;

	@Override
	public void act(float delta) {
		drawable.act(delta);
		super.act(delta);
	}

	public Stars(AnimationDrawable drawable) {
		super(drawable);
		this.drawable = drawable;
		setVisible(false);
	}

	public void play() {
		setVisible(true);
		drawable.play();

	}

}