package com.starbox.puzzlecar;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Bubble extends Image {

	private final AnimationDrawable drawable;
	private Sound snd;

	public boolean isFinished() {
		if (drawable.isEndAnim() || getY() > 1080)
			return true;
		return false;
	}

	@Override
	public void act(float delta) {
		drawable.act(delta);
	//	drawable.draw(batch, x, y, width, height)
		super.act(delta);

	}

	public Bubble(AnimationDrawable drawable, Sound s) {

		super(drawable);
		setColor((float) (1 - Math.random() * 0.4),
				(float) (1 - Math.random() * 0.4),
				(float) (1 - Math.random() * 0.4), 1f);
		snd = s;
		this.drawable = drawable;
	}

	public void clickBubble() {
		drawable.play();
		if (snd != null)
			snd.play(0.5f);

	}
}
