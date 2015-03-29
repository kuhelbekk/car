package com.starbox.puzzlecar;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Menu2d implements Screen {
	MainClass game;
	private int screenHeight;
	private int screenWidth;
	private int realHeight;
	private int realWidth;
	private int dx; // смещение фона
	private SpriteBatch batch;
	private TextureAtlas textureAtlas;
	public ArrayList<Image> lockList;

	private Image bgPay, PayForm, lablePay;
	private Image btnPay;
	private Button btnClosePay;
	public boolean blockButton = false;

	private FitViewport viewport;
	private Stage stage;
	private Skin skin;
	private Image gameName;
	private Table table1;
	private Table table11;
	private Table table12;
	private Table tableLock;
	private Button btnSettings, btnBack;
	protected Sound sButton;
	protected TrafficInMenu trafficInMenu;
	public ArrayList<Button> btnList;
	private Image ToyButton;

	private long timeToExit;
	
	public Menu2d(MainClass game) {
		super();
		this.game = game;
		this.createScene();
	}

	public void createScene() {

		Gdx.app.log("Game", "createSceneMenu");
		timeToExit = TimeUtils.millis()-1000;
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
		Gdx.app.log("start", "realWidth = " + realWidth + " realHeight = "
				+ realHeight);
		Gdx.app.log("start", "screenWidth = " + screenWidth
				+ " screenHeight = " + screenHeight);
		
		/*
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
*/
		
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
		
		
		
		textureAtlas = new TextureAtlas("data/menu.atlas");
		skin = new Skin(textureAtlas);
		
		
		btnList = new ArrayList<Button>();
		Image bg = new Image(textureAtlas.findRegion("bg"));
		bg.setPosition(dx, 0);
		stage.addActor(bg);
		Button btn;
		// // menu level 1
		ToyButton = new Image(textureAtlas.findRegion("icontoy"));
		stage.addActor(ToyButton);
		ToyButton.setPosition(screenWidth-105, screenHeight-105);
		ToyButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				game.payFrame.playToy();
			}
		});
		
		
		table1 = new Table();
		
		table1.setBounds(100, 100, screenWidth - 200, screenHeight - 450);

		gameName = new Image(textureAtlas.findRegion("gameName"));
		gameName.setPosition(screenWidth / 2 - gameName.getWidth() / 2,
				screenHeight - 50 - gameName.getHeight());
		stage.addActor(gameName);

		btn = addBtnOnMenu("btn_1_up", "btn_1_dn");
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (game.settings.isSound())
					sButton.play();
				Gdx.app.log("BtnClick", "car");
				table1.setVisible(false);
				ToyButton.setVisible(false);
				gameName.setVisible(false);
				table11.setVisible(true);
				tableLock.setVisible(!game.isPremium());
				table11.addAction(Actions.sequence(Actions.alpha(0f, 0),
						Actions.alpha(1f, 0.5f)));
			}
		});
		table1.add(btn).expand();
		btn = addBtnOnMenu("btn_2_up", "btn_2_dn");
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (game.settings.isSound())
					sButton.play();
				Gdx.app.log("BtnClick", "car");
				table1.setVisible(false);
				ToyButton.setVisible(false);
				gameName.setVisible(false);
				table12.setVisible(true);
				tableLock.setVisible(!game.isPremium());
				table12.addAction(Actions.sequence(Actions.alpha(0f, 0),
						Actions.alpha(1f, 0.5f)));
				// btnBack.setVisible(true);
			}
		});
		table1.add(btn).expand();
		table1.addAction(Actions.sequence(Actions.alpha(0f, 0),
				Actions.alpha(1f, 0.5f)));

		// // menu level 11
		table11 = new Table();
		table12 = new Table();
		table11.setBounds(30, 100, screenWidth - 60, screenHeight - 100);
		table12.setBounds(30, 100, screenWidth - 60, screenHeight - 100);

		btn = addBtnOnMenu("1_up", "1_dn"); // ///1:1
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				newGame(new PuzzleScrCar4(game), event);
			}
		});
		table11.add(btn).expand();

		btn = addBtnOnMenu("2_up", "2_dn");// //// 1:2
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				newGame(new PuzzleScrCar13(game), event);
			}
		});
		table11.add(btn).expand();

		btn = addBtnOnMenu("3_up", "3_dn");// //// 1:3
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				newGame(new PuzzleScrCar10(game), event);
			}
		});
		table11.add(btn).expand();

		btn = addBtnOnMenu("4_up", "4_dn");// /////////// 1:4
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				newGame(new PuzzleScrCar1(game), event);
			}
		});
		table11.add(btn).expand();
		// /////////////////////// вторая строка
		table11.row();
		btn = addBtnOnMenu("5_up", "5_dn");// ////////////2:1
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new PuzzleScrCar8(game), event);

			}
		});

		table11.add(btn).expand();
		btn = addBtnOnMenu("6_up", "6_dn");// ////////////2:2
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new PuzzleScrCar7(game), event);
			}
		});

		table11.add(btn).expand();

		btn = addBtnOnMenu("7_up", "7_dn");// ////////////2:3
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new PuzzleScrCar9(game), event);
			}
		});
		table11.add(btn).expand();

		btn = addBtnOnMenu("8_up", "8_dn");// ////////////2:4
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new PuzzleScrCar5(game), event);
			}
		});
		// table11.add(addLock());
		table11.add(btn).expand();
		// /////////////////////// третья строка
		table11.row();

		btn = addBtnOnMenu("9_up", "9_dn");// ////////////3:1
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new PuzzleScrCar12(game), event);
			}
		});
		table11.add(btn).expand();

		btn = addBtnOnMenu("10_up", "10_dn");// ////////////3:2
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new PuzzleScrCar3(game), event);
			}
		});
		table11.add(btn).expand();
		btn = addBtnOnMenu("11_up", "11_dn");// ////////////3:3
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new PuzzleScrCar2(game), event);
			}
		});
		table11.add(btn).expand();
		btn = addBtnOnMenu("12_up", "12_dn");// ////////////3:4
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new PuzzleScrCar6(game), event);
			}
		});
		table11.add(btn).expand();
		table11.row();
		btn = addBtnOnMenu("13_up", "13_dn");// ////////////4:1
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new PuzzleScrCar11(game), event);

			}
		});
		table11.add(btn).expand();
		btn = addBtnOnMenu("14_up", "14_dn");// ////////////4:2
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new PuzzleScrCar14(game), event);
			}
		});
		table11.add(btn).expand();
		btn = addBtnOnMenu("15_up", "15_dn");// ////////////4:2
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new PuzzleScrCar15(game), event);

			}
		});
		table11.add(btn).expand();

		btn = addBtnOnMenu("16_up", "16_dn");// ////////////4:2
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new PuzzleScrCar16(game), event);

			}
		});
		table11.add(btn).expand();
		table11.setVisible(false);
		// // menu level 12

		btn = addBtnOnMenu("P2_up", "P2_dn");// //// 1:1
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				newGame(new Puzzle2(game), event);
			}
		});
		table12.add(btn).expand();

		btn = addBtnOnMenu("P3_up", "P3_dn");// //// 1:2
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				newGame(new Puzzle3(game), event);
			}
		});
		table12.add(btn).expand();

		btn = addBtnOnMenu("P6_up", "P6_dn");// ////////////1:3
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				newGame(new Puzzle6(game), event);
			}
		});

		table12.add(btn).expand();

		btn = addBtnOnMenu("P15_up", "P15_dn");// ////////////1:4
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				newGame(new Puzzle15(game), event);
			}
		});
		table12.add(btn).expand();

		// /////////////////////// вторая строка

		table12.row();

		btn = addBtnOnMenu("P1_up", "P1_dn"); // ///2:1
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new Puzzle1(game), event);

			}
		});
		table12.add(btn).expand();

		btn = addBtnOnMenu("P5_up", "P5_dn");// ////////////2:2
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new Puzzle5(game), event);
			}

		});
		table12.add(btn).expand();

		btn = addBtnOnMenu("P7_up", "P7_dn");// ////////////2:3
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new Puzzle7(game), event);
			}
		});

		table12.add(btn).expand();

		btn = addBtnOnMenu("P8_up", "P8_dn");// ////////////2:4
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new Puzzle8(game), event);

			}
		});
		table12.add(btn).expand();
		// /////////////////////// третья строка
		table12.row();

		btn = addBtnOnMenu("P9_up", "P9_dn");// ////////////3:1
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new Puzzle9(game), event);

			}
		});
		table12.add(btn).expand();

		btn = addBtnOnMenu("P10_up", "P10_dn");// ////////////3:2
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new Puzzle10(game), event);

			}
		});
		table12.add(btn).expand();
		btn = addBtnOnMenu("P11_up", "P11_dn");// ////////////3:3
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new Puzzle11(game), event);

			}
		});
		table12.add(btn).expand();
		btn = addBtnOnMenu("P12_up", "P12_dn");// ////////////3:4
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new Puzzle12(game), event);

			}
		});
		table12.add(btn).expand();
		table12.row();
		btn = addBtnOnMenu("P13_up", "P13_dn");// ////////////4:1
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new Puzzle13(game), event);
			}
		});
		table12.add(btn).expand();

		btn = addBtnOnMenu("P14_up", "P14_dn");// ////////////4:2
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new Puzzle14(game), event);
			}
		});

		table12.add(btn).expand();

		btn = addBtnOnMenu("P4_up", "P4_dn");// /////////// 1:4
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new Puzzle4(game), event);
			}
		});
		table12.add(btn).expand();

		btn = addBtnOnMenu("P16_up", "P16_dn");// ////////////4:2
		btn.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (blockButton)
					return;
				if (game.isPremium())
					newGame(new Puzzle16(game), event);
			}
		});
		table12.add(btn).expand();
		table12.setVisible(false);

		stage.addActor(table1);
		stage.addActor(table11);
		stage.addActor(table12);
		sButton = Gdx.audio.newSound(Gdx.files.internal("mfx/button.mp3"));

		// / servis button

		ButtonStyle bs = new ButtonStyle();
		// //// settings
		bs.up = game.commonSkin.getDrawable("btn_settings_up");
		bs.down = game.commonSkin.getDrawable("btn_settings_dn");
		btnSettings = new Button(bs);
		btnSettings.setX(screenWidth - 113);
		btnSettings.setY(0);
		stage.addActor(btnSettings);
		btnList.add(btnSettings);
		btnSettings.setZIndex(5);
		btnSettings.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (game.settings.isSound())
					sButton.play();
				Gdx.app.log("BtnClick", "Settings");
				game.setScreen(new SettingsScene(game));
			}

		});
		// //// back
		bs = new ButtonStyle();
		bs.up = game.commonSkin.getDrawable("btn_back_up");
		bs.down = game.commonSkin.getDrawable("btn_back_dn");
		btnBack = new Button(bs);
		btnBack.setX(0);
		btnBack.setY(0);
		btnList.add(btnBack);
		stage.addActor(btnBack);
		btnBack.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				BackClick();
			}
		});

		addLocks();
		trafficInMenu = new TrafficInMenu(stage, textureAtlas);
		createPayFrame();
		btnBack.setZIndex(115);
		for (Button bn : btnList) {
			bn.addListener(new ClickListener() {
				public boolean touchDown(InputEvent event, float x, float y,
						int pointer, int button) {
					btnsTochDisable(Touchable.disabled,
							(Button) event.getListenerActor());
					return true;
				}

				public void touchUp(InputEvent event, float x, float y,
						int pointer, int button) {
					btnsTochDisable(Touchable.enabled,
							(Button) event.getListenerActor());
				}
			});
		}

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
		trafficInMenu.draw();
		// table1.drawDebug(stage);
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height,true);
	}

	@Override
	public void show() {
		Gdx.app.log("Game", "Show SceneMenu");
		Gdx.input.setInputProcessor(stage);

		blockButton = false;
	}

	@Override
	public void hide() {
		Gdx.app.log("Game", "Hide SceneMenu");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		Gdx.app.log("Game", "Pause SceneMenu");
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		Gdx.app.log("Game", "resume SceneMenu");
	}

	@Override
	public void dispose() {
		Gdx.app.log("Game", "dispose SceneMenu");
		textureAtlas.dispose();
		skin.dispose();
		stage.dispose();
	}

	private void addLocks() {
		lockList = new ArrayList<Image>();
		tableLock = new Table();
		tableLock.setBounds(30, 100, screenWidth - 60, screenHeight - 100
				- (screenHeight - 100) / 4);
		Image im;
		for (int i = 0; i < 12; i++) {
			im = new Image(textureAtlas.findRegion("lock"));
			im.addListener(new ClickListener() {
				public void clicked(InputEvent event, float x, float y) {
					showPayFrame();
				}

			});
			im.setZIndex(100);
			lockList.add(im);
			stage.addActor(im);
			tableLock.add(im).expand();
			if ((i + 1) % 4 == 0)
				tableLock.row();
		}
		stage.addActor(tableLock);
		tableLock.setVisible(false);
	}

	private Button addBtnOnMenu(String sUp, String sDn) {
		return addBtnOnMenu(sUp, sDn, 0, 0, true);
	}

	private Button addBtnOnMenu(String sUp, String sDn, float px, float py,
			boolean visible) {
		ButtonStyle bs = new ButtonStyle();
		bs.up = skin.getDrawable(sUp);
		bs.down = skin.getDrawable(sDn);
		Button btn = new Button(bs);
		btn.setVisible(visible);
		btn.setPosition(px, py);
		btnList.add(btn);
		stage.addActor(btn);
		return btn;
	}

	private void createPayFrame() {
		bgPay = new Image(textureAtlas.findRegion("bgPay"));
		bgPay.setZIndex(109);
		stage.addActor(bgPay);

		PayForm = new Image(textureAtlas.findRegion("by_form_bg"));
		PayForm.setPosition(screenWidth / 2 - PayForm.getWidth() / 2,
				screenHeight / 2 - PayForm.getHeight() / 2);
		PayForm.setZIndex(110);
		stage.addActor(PayForm);

		btnPay = new Image(textureAtlas.findRegion("btn_byup"));
		btnPay.setPosition(
				PayForm.getX() + PayForm.getWidth() / 2 - btnPay.getWidth() / 2,
				PayForm.getY() + 30);

		btnPay.setOrigin(btnPay.getWidth() / 2, btnPay.getHeight() / 2);
		btnPay.addAction(Actions.forever(Actions.sequence(
				Actions.scaleTo(1.05f, 1.05f, 0.60f, Interpolation.fade),
				Actions.scaleTo(0.98f, 0.99f, 0.40f))));
		btnPay.setZIndex(120);
		btnPay.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				if (game.payFrame != null) {
					game.payFrame.payClick();
				}
				hidePayFrame();
			}
		});
		stage.addActor(btnPay);

		btnClosePay = addBtnOnMenu("btn_close_by_up", "btn_close_by_dn");
		btnClosePay.setPosition(PayForm.getWidth() + PayForm.getX()
				- btnClosePay.getWidth() / 2,
				PayForm.getY() + PayForm.getHeight() - btnClosePay.getHeight()
						/ 2);
		btnClosePay.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				hidePayFrame();
			}
		});

		if (game.settings.isLangRu()) {
			lablePay = new Image(textureAtlas.findRegion("txt_by_RU"));
		} else {
			lablePay = new Image(textureAtlas.findRegion("txt_by_EN"));
		}
		lablePay.setPosition(
				PayForm.getX() + PayForm.getWidth() / 2 - lablePay.getWidth()
						/ 2, PayForm.getY() + PayForm.getHeight() - 50
						- lablePay.getHeight());
		lablePay.setZIndex(130);
		stage.addActor(lablePay);

		hidePayFrame();
	}

	public void showPayFrame() {
		if (game.isPremium())
			return;
		bgPay.setVisible(true);
		PayForm.setVisible(true);
		btnPay.setVisible(true);
		btnClosePay.setVisible(true);
		lablePay.setVisible(true);
	}

	public void hidePayFrame() {
		bgPay.setVisible(false);
		PayForm.setVisible(false);
		btnPay.setVisible(false);
		btnClosePay.setVisible(false);
		lablePay.setVisible(false);
	}

	public void setPrenium() {
		if (tableLock != null & tableLock.isVisible())
			tableLock.setVisible(!game.isPremium());
	}

	public void BackClick() {
		Gdx.app.log("MainMenu", "Back Click");
		if (game.settings.isSound())
			sButton.play();

		if (table1.isVisible()) {
			Gdx.app.log("MainMenu", "Exit game");
			if ((timeToExit+1000)>TimeUtils.millis()){
				Gdx.app.exit();				
			}else{
				timeToExit = TimeUtils.millis();
				game.payFrame.showToast(game.getExitText());
			}
		} else {
			if (bgPay.isVisible()) {
				hidePayFrame();
			} else {
				table11.setVisible(false);
				table12.setVisible(false);
				tableLock.setVisible(false);
				table1.setVisible(true);
				ToyButton.setVisible(true);
				ToyButton.addAction(Actions.sequence(Actions.alpha(0f, 0), Actions.alpha(1f, 0.7f)));
				gameName.setVisible(true);
				table1.addAction(Actions.sequence(Actions.alpha(0f, 0),
						Actions.alpha(1f, 0.5f)));
			}
		}
	}

	private void newGame(Screen screen, InputEvent event) {
		if (event.getButton() > 0)
			return;
		if (game.settings.isSound())
			sButton.play();
		Gdx.app.log("BtnClick", screen.getClass().getName());
		game.setScreen(screen);
		blockButton = true;
	}

	private void btnsTochDisable(Touchable tch, Button parent) {

		for (Button btn : btnList)
			if (parent != btn)
				btn.setTouchable(tch);
	}
}
