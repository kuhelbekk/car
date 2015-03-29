package com.starbox.puzzlecar;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;

public class AnimationDrawable extends BaseDrawable {
	public final Animation anim;
	private float stateTime = 0;
	public boolean playing = false;
	public int animPos = 0;
	private boolean endAnim = false;

	public boolean isEndAnim() {
		return endAnim;
	}

	public AnimationDrawable(Animation anim) {
		this.anim = anim;
		setMinWidth(anim.getKeyFrame(0).getRegionWidth());
		setMinHeight(anim.getKeyFrame(0).getRegionHeight());
	}

	public void act(float delta) {
		if (playing) {
			// Gdx.app.log("Anim","playing anim");
			stateTime += delta;
		}
	}

	public void reset() {
		stateTime = 0;
	}

	@Override
	public void draw(Batch batch, float x, float y, float width,float height) {
		animPos = anim.getKeyFrameIndex(stateTime);
		if (playing & anim.isAnimationFinished(stateTime)) {			
			endAnim = true;
			playing = false;
		}
		batch.draw(anim.getKeyFrame(stateTime), x, y, width, height);
	}

	public void play() {		
		if (!(playing || endAnim)) {
			endAnim = false;
			playing = true;
			stateTime = 0;
		}
	}
}