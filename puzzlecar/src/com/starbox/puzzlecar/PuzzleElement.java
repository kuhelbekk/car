package com.starbox.puzzlecar;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

public class PuzzleElement {

	public Image image;
	public Rectangle tagert;
	public Vector2 endPoint;
	public int index;
	public boolean isAttach = false;
	public TextureRegion startRegion;
	public TextureRegion endRegion;
	private PuzzleElement sameElement = null;
	public PuzzleScene parent;
	public int currentAction;
	private Stars stars;
	protected Sound sSuccess;
	private String sSuccessName;

	public PuzzleElement(PuzzleScene parent, TextureRegion startRegion, int i,
			int endX, int endY) {
		sSuccessName = "success.mp3";
		PuzzleElementA(parent, startRegion, startRegion, i, endX, endY);
	}

	public PuzzleElement(PuzzleScene parent, TextureRegion startRegion,
			TextureRegion endRegion, int i, int endX, int endY) {
		sSuccessName = "success.mp3";
		PuzzleElementA(parent, startRegion, endRegion, i, endX, endY);
	}

	public PuzzleElement(PuzzleScene parent, TextureRegion startRegion, int i,
			int endX, int endY, String sName) {

		if (parent.game.settings.isVoice()) {
			if (parent.game.settings.isLangRu()) {
				setSound(sName + "_ru.mp3");
			} else {
				setSound(sName + "_en.mp3");
			}
		} else {
			sSuccessName = "success.mp3";
		}
		PuzzleElementA(parent, startRegion, startRegion, i, endX, endY);
	}

	public PuzzleElement(PuzzleScene parent, TextureRegion startRegion,
			TextureRegion endRegion, int i, int endX, int endY, String sName) {

		if (parent.game.settings.isVoice()) {
			if (parent.game.settings.isLangRu()) {
				setSound(sName + "_ru.mp3");
			} else {
				setSound(sName + "_en.mp3");
			}
		} else {
			sSuccessName = "success.mp3";
		}
		PuzzleElementA(parent, startRegion, endRegion, i, endX, endY);
	}

	public void PuzzleElementA(final PuzzleScene parent,
			TextureRegion strtRegion, TextureRegion eRegion, int i, int endX,
			int endY) {
		this.parent = parent;
		index = i;
		startRegion = strtRegion;
		endRegion = eRegion;
		image = new Image(startRegion);
		endPoint = new Vector2(endX + parent.getDx(), endY
				- startRegion.getRegionHeight() + parent.getDy());
		parent.stage.addActor(image);
		setPosToStartPoint(2);

		image.addListener(new ClickListener() {
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				if ((button != 0) || (pointer != 0))
					return false;
				// Gdx.app.log("touchDown","index=" +index+"  y=" +y );
				if (isAttach)
					return false;
				image.setZIndex(60);

				image.setScale(image.getHeight()
						/ startRegion.getRegionHeight());
				image.setPosition(
						image.getX()
								- (startRegion.getRegionWidth() - image
										.getWidth()) / 2,
						image.getY()
								- (startRegion.getRegionHeight() - image
										.getHeight()) / 2);
				image.setSize(startRegion.getRegionWidth(),
						startRegion.getRegionHeight());
				image.setOrigin(image.getWidth() / 2, image.getHeight() / 2);
				currentAction = 0;
				Array<Action> aa = image.getActions();
				Iterator<Action> ia = aa.iterator();
				while (ia.hasNext()) {
					ia.next();
					ia.remove();
				}
				image.addAction(Actions.parallel(
						Actions.scaleTo(1, 1, 0.15f),
						Actions.moveTo(event.getStageX()
								- (image.getWidth() / 2), event.getStageY()
								- (image.getHeight() / 2), 0.2f),
						Actions.rotateTo(0, 0.2f)));
				return true;
			}

			public void touchDragged(InputEvent event, float x, float y,
					int pointer) {
				if (pointer != 0)
					return;
				if (isAttach)
					return;
				image.addAction(Actions.moveTo(
						event.getStageX() - (image.getWidth() / 2),
						event.getStageY() - (image.getHeight() / 2), 0.05f));
				// image.setPosition(event.getStageX()-(image.getWidth()/2),
				// event.getStageY()-(image.getHeight()/2)) ;
				if (hit(x, y) != null) {
					image.setColor(1f, 1f, 0.1f, 1);
					setAction(3);
				} else {
					image.setColor(1, 1, 1, 1);
					setAction(0);
				}
			}

			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				if ((button != 0) || (pointer != 0))
					return;
				PuzzleElement pe = hit(x, y);
				if (pe != null) {
					pe.stars.setPosition(event.getStageX()
							- (stars.getWidth() / 2), event.getStageY()
							- (stars.getHeight() / 2));
					if (pe.image != image) {
						int i = index;
						index = pe.index;
						pe.index = i;
						image.setColor(1, 1, 1, 1);
						setPosToStartPoint(2);
					}
					if (pe.sameElement != null) {
						pe.sameElement.sameElement = null;
						pe.sameElement = null;
					}
					pe.fixing();

				} else {
					setPosToStartPoint(1);
				}
			}
		});
		TextureRegion[] StarsFrames = parent.game.GetAnimFrames("stars", 397,
				348);
		Animation anim = new Animation(0.05f, StarsFrames);
		AnimationDrawable drawable = new AnimationDrawable(anim);
		stars = new Stars(drawable);
		parent.stage.addActor(stars);
		if (parent.game.settings.isSound()) {
			sSuccess = Gdx.audio.newSound(Gdx.files.internal("mfx/"
					+ sSuccessName));
		}
	}

	public void setSound(String name) {
		sSuccessName = name;
	}

	private PuzzleElement hit(float x, float y) {
		int accuracy = 40 + parent.game.accuracy;
		if ((Math.abs(endPoint.x - image.getX()) < accuracy)
				& (Math.abs(endPoint.y - image.getY()) < accuracy)) {
			return this;
		} else {
			if (sameElement != null) {
				if ((Math.abs(sameElement.endPoint.x - image.getX()) < accuracy)
						& (Math.abs(sameElement.endPoint.y - image.getY()) < accuracy)) {
					return sameElement;
				}
			}
		}
		return null;
	}

	public void fixing() {
		image.remove();
		image = new Image(endRegion);
		image.setZIndex(10);
		image.setPosition(endPoint.x, endPoint.y);
		image.setColor(1, 1, 1, 1);
		image.setPosition(endPoint.x + image.getWidth() / 2,
				endPoint.y + image.getHeight() / 2);
		image.setScale(0.01f, 0.01f);
		image.addAction(Actions.moveTo(endPoint.x, endPoint.y, 0.3f));
		image.addAction(Actions.scaleTo(1, 1, 0.3f));
		parent.stage.addActor(image);
		isAttach = true;
		stars.play();
		parent.btnBack.setZIndex(151);
		stars.setZIndex(100);
		if (sSuccess != null) {
			sSuccess.play(0.9f);
		}
		parent.elementMounted(this);
	}

	public void setPosToStartPoint(int type) {
		image.setZIndex(50);
		if (image.getWidth() > image.getHeight()) {
			if (image.getWidth() > 200) {
				image.setSize(200, image.getHeight() / (image.getWidth() / 200));
			}
		} else {
			if (image.getHeight() > 155)
				image.setSize(image.getWidth() / (image.getHeight() / 160), 160);
		}
		setAction(1);
		image.setColor(1, 1, 1, 1);
		image.setOrigin(image.getWidth() / 2, image.getHeight() / 2);
		switch (type) {
		case 0: // / сдвиг после попадания
			image.addAction(Actions.moveTo((index) * 200
					- (image.getWidth() / 2) + parent.getDx() + 40,
					638 + parent.getDy(), 0.2f));

			break;
		case 1:// // возврат на место детали
			float scale = startRegion.getRegionHeight() / image.getHeight();
			image.setPosition(
					image.getX()
							+ (startRegion.getRegionWidth() - image.getWidth())
							/ 2,
					image.getY()
							+ (startRegion.getRegionHeight() - image
									.getHeight()) / 2);
			image.setScale(scale);
			image.addAction(Actions.parallel(
					Actions.moveTo((index) * 200 - (image.getWidth() / 2)
							+ parent.getDx() + 40, 638 + parent.getDy(), 0.2f),
					Actions.scaleTo(1, 1, 0.2f)));

			break;
		case 2:// / поставить на место без анимации
			image.setPosition(
					(index) * 200 - (image.getWidth() / 2) + parent.getDx()
							+ 40, 638 + parent.getDy());
			break;
		}

		image.setVisible(index < 6);

	}

	public void setSameElement(PuzzleElement sameElement) {
		this.sameElement = sameElement;
		sameElement.sameElement = this;
	}

	public void setAction(int i) {

		if (currentAction == i)
			return; // в начальное положение
		currentAction = i;
		Array<Action> aa = image.getActions();
		Iterator<Action> ia = aa.iterator();
		while (ia.hasNext()) {
			ia.next();
			ia.remove();
		}
		image.setRotation(0);
		switch (i) {
		case 0:
			break;
		case 1:

			image.addAction(Actions.sequence(Actions.rotateBy(-15, 0.5f),
					Actions.forever(Actions.sequence(
							Actions.rotateBy(30, 1, Interpolation.sine),
							Actions.rotateBy(-30, 1, Interpolation.sine)))));
			break;
		case 3:
			image.addAction(Actions.forever(Actions.sequence(
					Actions.scaleTo(1.01f, 1.01f, 0.15f, Interpolation.sine),
					Actions.scaleTo(0.98f, 0.99f, 0.06f))));
			break;

		}
	}

	public void dispose() {
		if (sSuccess != null) {

			sSuccess.dispose();
		}
	}

}
