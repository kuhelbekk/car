package com.starbox.puzzlecar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SettingsScene implements Screen {
	private MainClass game;
	private int screenHeight;
	private int screenWidth;
	private int realHeight;
	private int realWidth;
	
	private Viewport viewport;
	private SpriteBatch batch;
	private Stage stage;
	private Table table;
	protected Sound sButton;
	protected Button btnLangRu, btnLangEn, btnSpeech, btnMusic, btnRateRu,
			btnRateEn;

	public SettingsScene(MainClass game) {
		super();
		this.game = game;
		this.createScene();
	}

	@Override
	public void render(float delta) {
		// Gdx.gl.glClearColor((19/255)f, 0, 0,0);
		Gdx.gl.glClearColor((19f / 255f), (124f / 255f), (204f / 255f), 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// Table.drawDebug(stage);
		stage.act(delta);
		stage.draw();

	}

	@Override
	public void resize(int width, int height) {
	}

	public void createScene() {
		Gdx.app.log("Game", "create Settings");

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

		batch = new SpriteBatch();

		// batch.setColor(19/255, 124/255, 204/255, 1);
		
		viewport = new FitViewport(screenWidth, screenHeight);
		stage = new Stage(viewport,batch){
			@Override
			public boolean keyDown(int keyCode) {
				if (keyCode == Keys.BACK) {
					BackClick();
				}
				return super.keyDown(keyCode);
			}
		};
		Gdx.input.setInputProcessor(stage);

		Button btn;
		table = new Table();
		table.setBounds(30, 200, screenWidth - 60, screenHeight - 300);
		// / back
		btn = addBtn("btn_back_up", "btn_back_up", "", "");
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				BackClick();

			}

		});

		btn.setX(0);
		btn.setY(0);

		Gdx.app.log("Settings", "Sound:" + game.settings.isSound());
		Gdx.app.log("Settings", "isLangRu:" + game.settings.isLangRu());
		Gdx.app.log("Settings", "isMusic:" + game.settings.isMusic());
		Gdx.app.log("Settings", "isVoice:" + game.settings.isVoice());

		// // звук
		btn = addBtn("snd_on", "snd_dn", "snd_na", "snd_off");
		btn.setChecked(!game.settings.isSound());
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				sButton.play();
				boolean c = ((Button) event.getListenerActor()).isChecked();
				Gdx.app.log("Settings", "Sound:" + !c);
				game.settings.setSound(!c);
				btnSpeech.setDisabled(c);
				btnMusic.setDisabled(c);
				btnLangRu.setDisabled(c | !game.settings.isVoice());
				btnLangEn.setDisabled(c | !game.settings.isVoice());
				btnLangRu.setChecked(game.settings.isLangRu());
				btnLangEn.setChecked(!game.settings.isLangRu());

			}

		});
		table.add(btn).expand();

		// // музыка
		btnMusic = addBtn("music_on", "music_dn", "music_na", "music_off");
		btnMusic.setChecked(!game.settings.isMusic());
		btnMusic.setDisabled(!game.settings.isSound());
		btnMusic.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (!((Button) event.getListenerActor()).isDisabled()) {
					sButton.play();
					boolean c = ((Button) event.getListenerActor()).isChecked();
					game.settings.setMusic(!c);
					Gdx.app.log("Settings", "Music:" + !c);
				}
			}

		});
		table.add(btnMusic).expand();

		// // голос
		btnSpeech = addBtn("speech_on", "speech_dn", "speech_na", "speech_off");
		btnSpeech.setChecked(!game.settings.isVoice());
		btnSpeech.setDisabled(!game.settings.isSound());
		btnSpeech.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (!((Button) event.getListenerActor()).isDisabled()) {
					sButton.play();
					boolean c = ((Button) event.getListenerActor()).isChecked();
					game.settings.setVoice(!c);
					btnLangRu.setDisabled(c);
					btnLangEn.setDisabled(c);
					btnLangRu.setChecked(game.settings.isLangRu());
					btnLangEn.setChecked(!game.settings.isLangRu());
					Gdx.app.log("Settings", "Speech:" + !c);
				}
			}

		});
		table.add(btnSpeech).expand();

		table.row();
		// // язык
		btnLangRu = addBtn("btn_ru_up", "btn_ru_up", "btn_ru_na", "btn_ru_act");
		btnLangRu.setDisabled((!game.settings.isVoice())
				|| (!game.settings.isSound()));
		btnLangRu.setChecked(game.settings.isLangRu());
		btnLangRu.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (!((Button) event.getListenerActor()).isDisabled()) {
					if (!game.settings.isLangRu()) {
						sButton.play();
						Gdx.app.log("Settings", "Lang Ru");
						game.settings.setLangRu(true);
						btnLangRu.setChecked(true);
						btnLangEn.setChecked(false);
					} else {
						btnLangRu.setChecked(true);
						btnLangEn.setChecked(false);
					}
					btnRateEn.setVisible(false);
					btnRateRu.setVisible(true);
				}
			}
		});
		table.add(btnLangRu).expand();
		btnLangEn = addBtn("btn_en_up", "btn_en_up", "btn_en_na", "btn_en_act");
		btnLangEn.setDisabled((!game.settings.isVoice())
				|| (!game.settings.isSound()));
		btnLangEn.setChecked(!game.settings.isLangRu());
		btnLangEn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (!((Button) event.getListenerActor()).isDisabled()) {
					if (game.settings.isLangRu()) {
						sButton.play();
						Gdx.app.log("Settings", "Lang En");
						game.settings.setLangRu(false);
						btnLangRu.setChecked(false);
						btnLangEn.setChecked(true);
					} else {
						btnLangRu.setChecked(false);
						btnLangEn.setChecked(true);

					}
					btnRateEn.setVisible(true);
					btnRateRu.setVisible(false);
				}
			}
		});
		table.add(btnLangEn).expand();

		btnRateRu = addBtn("range", "range", "range", "range");
		btnRateRu.setPosition(screenWidth / 2 - btnRateRu.getWidth() / 2, 80);
		btnRateRu.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				game.payFrame.rateClick();
			}
		});

		btnRateEn = addBtn("rate_copy", "rate_copy", "rate_copy", "rate_copy");
		btnRateEn.setPosition(screenWidth / 2 - btnRateRu.getWidth() / 2, 80);
		btnRateEn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				game.payFrame.rateClick();
			}
		});

		if (game.settings.isLangRu()) {
			btnRateEn.setVisible(false);
		} else {
			btnRateRu.setVisible(false);
		}

		stage.addActor(table);
		sButton = Gdx.audio.newSound(Gdx.files.internal("mfx/button.mp3"));
	}

	protected void BackClick() {
		Gdx.app.log("BtnClick", "exit Settings");
		game.setScreen(game.menu2d);
		game.settings.saveSettings();
		dispose();

	}

	@Override
	public void hide() {
		Gdx.app.log("Game", "Hide Settings");
	}

	@Override
	public void pause() {
		Gdx.app.log("Game", "pause Settings");

	}

	@Override
	public void resume() {
		Gdx.app.log("Game", "resume Settings");
	}

	@Override
	public void dispose() {
		Gdx.app.log("Game", "dispose Settings");
		batch.dispose();
		stage.dispose();
		sButton.dispose();
	}

	@Override
	public void show() {
		Gdx.app.log("Game", "Show Settings");
	}

	private Button addBtn(String sUp, String sDn, String sDs, String sCheck) {
		ButtonStyle bs = new ButtonStyle();
		bs.up = game.commonSkin.getDrawable(sUp);
		bs.down = game.commonSkin.getDrawable(sDn);
		if (!sDs.equals(""))
			bs.disabled = game.commonSkin.getDrawable(sDs);
		if (!sCheck.equals(""))
			bs.checked = game.commonSkin.getDrawable(sCheck);
		Button btn = new Button(bs);
		stage.addActor(btn);
		return btn;
	}

}
