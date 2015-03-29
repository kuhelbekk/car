package com.starbox.puzzlecar;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PuzzleScene implements Screen {
	int screenHeight;
	int screenWidth;
	public int realHeight;
	public int realWidth;
	private int dx, dy; // смещение фона

	private Viewport viewport;
	protected SpriteBatch batch;
	protected TextureAtlas textureAtlas;
	protected MainClass game;
	protected PuzzleElement selectedElement;
	protected ArrayList<PuzzleElement> elementList;

	// private FPSLogger fpsLog;

	protected Button btnDn, btnBack;
	protected Stage stage;
	protected Music mFon, mBubble;
	protected Sound sEngine, sBubble;
	protected ArrayList<Bubble> listBubble;

	protected Image finishRaise;
	protected boolean visibleFinishScene;

	int starCount = 8; // / количество звезд в конце

	protected FinishStar[] arrFinishStar;
	protected Image[] carLight;
	protected Button nextLevelButton;

	public PuzzleScene(MainClass game) {
		super();
		this.game = game;
		this.createScene();
		this.btnBack.setZIndex(150);

	}

	protected int carLightCount() {
		return 0;
	}

	protected float getCarLightX(int index) {
		Gdx.app.log("Game", "getCarLightX def");
		return -300;
	}

	protected float getCarLightY(int index) {
		Gdx.app.log("Game", "getCarLightY def");
		return -300;
	}

	public void createScene() {
		Gdx.app.log("Game", "createSceneCar");
		visibleFinishScene = false;
		realWidth = Gdx.graphics.getWidth();
		realHeight = Gdx.graphics.getHeight();
		if ((realHeight > 1200) && (realWidth > 2000)) { // приведение ретин к
															// нормальному виду
			realHeight /= 2;
			realWidth /= 2;
		}
		screenWidth = 1280;
		if ((realHeight <= 800) && (realHeight >= 720)) {
			screenHeight = realHeight;
		} else {
			screenHeight = 800;
		}

		float a = (float) realWidth / screenWidth;
		float b = (float) realHeight / screenHeight;
		if (a < b)
			screenWidth = (screenHeight * realWidth) / realHeight;
		if (screenWidth < 980)
			screenWidth = 980;
		if (screenWidth > 1280)
			screenWidth = 1280;
		dx = (screenWidth - 1280) / 2;
		dy = (screenHeight - 800);
		if (dy < -50)
			dy = -50;
		// Gdx.app.log("start",
		// "realWidth = "+realWidth+" realHeight = "+realHeight);
		// Gdx.app.log("start",
		// "screenWidth="+screenWidth+"; screenHeight="+screenHeight+";     dx="
		// + dx+"; dy="+dy);

		// MouseDown=false;
		batch = new SpriteBatch();
		viewport = new FitViewport(screenWidth, screenHeight);
		stage = new Stage(viewport,batch) {
			@Override
			public boolean keyDown(int keyCode) {				
				if (keyCode == Keys.BACK) {
					BackClick();
				}				
				return super.keyDown(keyCode);
			}
		};

		Image bg = new Image(textureAtlas.findRegion("bg"));
		stage.addActor(bg);
		bg.setPosition(dx, dy);

		elementList = new ArrayList<PuzzleElement>();

		if (game.settings.isMusic() & game.settings.isSound()) {
			long rnd = Math.round((Math.random() * 2));
			mFon = Gdx.audio.newMusic(Gdx.files
					.internal("mfx/s" + rnd + ".mp3"));
			mFon.setVolume(0.4f);
			if (rnd == 2)
				mFon.setVolume(0.3f);
			mFon.setLooping(true);
			mFon.play();

			mBubble = Gdx.audio.newMusic(Gdx.files
					.internal("mfx/fon_bubble.mp3"));
			mBubble.setVolume(1f);
			mBubble.setLooping(true);
		}

		// showBubble();
		if (game.settings.isSound()) {
			sEngine = Gdx.audio.newSound(Gdx.files
					.internal("mfx/engine-start.mp3"));
			sBubble = Gdx.audio.newSound(Gdx.files.internal("mfx/bubble.mp3"));

		}

		// /back
		ButtonStyle bs = new ButtonStyle();
		bs.up = game.commonSkin.getDrawable("btn_back_up");
		bs.down = game.commonSkin.getDrawable("btn_back_dn");
		btnBack = new Button(bs);
		stage.addActor(btnBack);
		btnBack.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				BackClick();

			}
		});
		btnBack.setPosition(0, 0);
		stage.addAction(Actions.sequence(Actions.moveTo(stage.getWidth(), 0),
				Actions.moveTo(0, 0, 0.9f, Interpolation.exp5)));

	}

	@Override
	public void show() {
		Gdx.app.log("Game", "show Scene Car");
		Gdx.input.setInputProcessor(stage);

	}

	@Override
	public void render(float delta) {
		// Gdx.gl.glClearColor(0,0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (listBubble != null) {
			if (!listBubble.isEmpty()) { // убийство лопнутых и улетевших
											// пузырей
				Iterator<Bubble> iterator = listBubble.iterator();
				while (iterator.hasNext()) {
					Bubble b = (Bubble) iterator.next();
					if (b.isFinished()) {
						b.remove();
						iterator.remove();
					}
				}
			}
		}

		if (visibleFinishScene) {// / лучи счастья
			drawFinish();
		}
		stage.act(delta);
		stage.draw();

	}

	@Override
	public void resize(int width, int height) {
		// Gdx.app.log("Game", "resize Scene Car");
	}

	@Override
	public void hide() {
		Gdx.app.log("Game", "hide Scene Car");
	}

	@Override
	public void pause() {
		Gdx.app.log("Game", "pause Scene Car");
	}

	@Override
	public void resume() {
		Gdx.app.log("Game", "resume Scene Car");
	}

	@Override
	public void dispose() {
		Gdx.app.log("Game", "dispose Scene Car");
		if (mFon != null)
			mFon.dispose();
		if (mBubble != null)
			mBubble.dispose();
		if (sEngine != null)
			sEngine.dispose();
		if (sBubble != null)
			sBubble.dispose();
		// if (sError != null)sError.dispose();
		batch.dispose();
		textureAtlas.dispose();
		stage.dispose();
	}

	public void elementMounted(PuzzleElement pe) {
		int i = pe.index;
		pe.index = 0;
		boolean fEndScene = true;
		for (PuzzleElement p : elementList) {
			if (p.index > i) {
				--p.index;
				p.setPosToStartPoint(0);
			}
			if (p.index > 0)
				fEndScene = false;
		}
		if (fEndScene) {
			if (mFon != null)
				if (mFon.isPlaying())
					mFon.stop();
			if (sEngine != null)
				sEngine.play(0.5f);
			showCarLight();
			// showFinishScreen();
		}

	}

	protected void showBubble() {
		listBubble = new ArrayList<Bubble>();
		TextureRegion[] BubbleFrames = game.GetAnimFrames("bubble", 310, 310); // /
																				// создание
																				// массива
																				// кадров
																				// для
																				// анимации
		Animation anim = new Animation(0.04f, BubbleFrames); // задание скорости
																// анимации
		if (game.settings.isMusic() & game.settings.isSound())
			mBubble.play();
		for (int c = 0; c < 10; c++) { // // количество пузырей
			AnimationDrawable drawable = new AnimationDrawable(anim); // /
																		// создание
																		// отрисовщика
			Bubble b = new Bubble(drawable, sBubble); // / компонент пузыря
			listBubble.add(b); // куча пузырей
			b.setPosition((int) (Math.random() * (screenWidth - 300) + 50),
					(int) (-310 - Math.random() * 600)); // начальная позиция
			b.setZIndex(300);
			b.setScale(0.3f + (float) (Math.random() / 2));
			stage.addActor(b);
			b.addListener(new ClickListener() { // попадание по пузырю
				public boolean touchDown(InputEvent event, float x, float y,
						int pointer, int button) {
					((Bubble) (event.getListenerActor())).clickBubble();
					return true;
				}
			});
			b.addAction(Actions.moveTo(
					(int) (b.getX() - 10 + Math.random() * 20),
					(int) (1934 + b.getY() + Math.random() * 900), 15));
		}
	}

	protected void endScene() {
		if (mBubble != null)
			mBubble.stop();
		for (PuzzleElement p : elementList) {
			p.dispose();
		}
		dispose();
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	protected void showCarLight() {
		int count = carLightCount();
		carLight = new Image[count];
		for (int i = 0; i < count; i++) {
			carLight[i] = new Image(game.commonAtlas.findRegion("light"));
			carLight[i].setColor(1, 1, 1, 0);
			carLight[i].setZIndex(250);
			carLight[i].setPosition(getCarLightX(i) + getDx() - 117, 800
					- getCarLightY(i) + getDy() - 117);
			// Gdx.app.log("Game",
			// "getCarLightX "+getCarLightX(i)+"getCarLightY "+getCarLightY(i));
			stage.addActor(carLight[i]);
			carLight[i].addAction(Actions.sequence(
					Actions.alpha(0.001f, 1.8f),
					Actions.alpha(1, 0.1f), // / мырг мырг
					Actions.alpha(0.001f, 0.1f), Actions.alpha(1, 0.09f),
					Actions.alpha(0.001f, 0.1f)));
		}
		visibleFinishScene = true;
	}

	public void showFinishScreen() {
		Gdx.app.log("Game", "showFinishScreen");
		finishRaise = new Image(game.commonAtlas.findRegion("endGameRays"));
		finishRaise.setPosition((screenWidth - finishRaise.getWidth()) / 2,
				(screenHeight - finishRaise.getHeight()) / 2);
		finishRaise.setZIndex(150);
		finishRaise.setColor(1, 1, 1, 0.1f);
		finishRaise.setOrigin(finishRaise.getWidth() / 2,
				finishRaise.getHeight() / 2);
		finishRaise.addAction(Actions.parallel(Actions.alpha(1, 0.5f),
				Actions.forever(Actions.rotateBy(12f, 1))));
		stage.addActor(finishRaise);

		int[] px = { 0, 106, 150, 106, 0, -106, -150, -106 };
		int[] py = { 150, 106, 0, -106, -150, -106, 0, 106 };
		arrFinishStar = new FinishStar[starCount];
		TextureRegion[] starFrames = game.GetAnimFrames("endStar", 120, 120); // /
																				// создание
																				// массива
																				// кадров
																				// для
																				// анимации
		Animation anim = new Animation(0.013f, starFrames); // задание скорости
															// анимации
		for (int i = 0; i < starCount; i++) {
			AnimationDrawable drawable = new AnimationDrawable(anim); // /
																		// создание
																		// отрисовщика
			arrFinishStar[i] = new FinishStar(drawable);
			// arrFinishStar[i].setPosition( (screenWidth/2)+(100*i-100)-60,
			// (screenHeight/2)+(i%2*30)+50);
			arrFinishStar[i].setPosition((screenWidth / 2) + px[i] - 63,
					(screenHeight / 2) + py[i] - 60);
			arrFinishStar[i].setZIndex(152);
			stage.addActor(arrFinishStar[i]);
			arrFinishStar[i].setVisible(false);
		}
		arrFinishStar[0].setVisible(true);
		arrFinishStar[0].play();
		showBubble();
		// endScene();
	}

	private void drawFinish() {
		if (finishRaise == null) { // / фары не отмигали
			if (carLightCount() > 0) {
				if (carLight[0].getActions().size == 0)
					showFinishScreen();
				// Gdx.app.log("Game",
				// "getActions = "+carLight[0].getActions().size);
			} else {
				showFinishScreen();
			}
		} else { // ///// показываем звезды и лучи
			if (!(nextLevelButton == null))
				return;

			if (arrFinishStar[starCount - 1].isFinished()) {
				ButtonStyle bs = new ButtonStyle();
				bs.up = game.commonSkin.getDrawable("btn_next_up");
				bs.down = game.commonSkin.getDrawable("btn_next_dn");
				nextLevelButton = new Button(bs);
				stage.addActor(nextLevelButton);
				nextLevelButton.addListener(new ClickListener() {
					public void clicked(InputEvent event, float x, float y) {
						endScene();
					}
				});
				nextLevelButton.setZIndex(151);
				nextLevelButton.setPosition(
						(screenWidth - nextLevelButton.getWidth()) / 2,
						(screenHeight - nextLevelButton.getHeight()) / 2);
				nextLevelButton.setColor(1, 1, 1, 0);
				nextLevelButton.addAction(Actions.alpha(1, 1));
			} else {
				int i = 0;
				while (arrFinishStar[i].isFinished())
					i++;
				if (i > 0 && i < starCount) {
					if (!(arrFinishStar[i].isVisible())) {
						arrFinishStar[i].setVisible(true);
						arrFinishStar[i].play();
					}
				}

			}

		}
	}

	public void BackClick() {
		Gdx.app.log("BtnClick", "exit SceneCar");
		game.setScreen(game.menu2d);
		dispose();
		
	
	}
	
	
}
