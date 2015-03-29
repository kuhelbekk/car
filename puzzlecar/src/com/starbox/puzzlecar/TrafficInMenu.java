package com.starbox.puzzlecar;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class TrafficInMenu {

	private Stage stage;
	// private TextureAtlas textureAtlas;
	private ArrayList<TextureRegion> carTextureL, carTextureR;
	private ArrayList<Image> carsL, carsR;
	private long timeRspL, timeRspR;

	public TrafficInMenu(Stage stage, TextureAtlas textureAtlas) {
		this.stage = stage;
		// this.textureAtlas=textureAtlas;

		carTextureL = new ArrayList<TextureRegion>();
		carTextureR = new ArrayList<TextureRegion>();
		carsL = new ArrayList<Image>();
		carsR = new ArrayList<Image>();

		carTextureL.add(textureAtlas.findRegion("mini_car_1l"));
		carTextureL.add(textureAtlas.findRegion("mini_car_2l"));
		carTextureL.add(textureAtlas.findRegion("mini_car_2l"));
		carTextureL.add(textureAtlas.findRegion("mini_car_3l"));
		carTextureL.add(textureAtlas.findRegion("mini_car_4l"));
		carTextureL.add(textureAtlas.findRegion("mini_car_5l"));
		carTextureL.add(textureAtlas.findRegion("mini_car_6l"));

		carTextureR.add(textureAtlas.findRegion("mini_car_1r"));
		carTextureR.add(textureAtlas.findRegion("mini_car_2r"));
		carTextureR.add(textureAtlas.findRegion("mini_car_3r"));
		carTextureR.add(textureAtlas.findRegion("mini_car_4r"));
		carTextureR.add(textureAtlas.findRegion("mini_car_5r"));
		carTextureR.add(textureAtlas.findRegion("mini_car_6r"));

		Image im;
		im = new Image(carTextureL.get((int) (Math.random() * carTextureL
				.size())));
		im.setPosition((int) (Math.random() * 500), 26);
		im.addAction(Actions.moveTo(-120, 26, im.getX() / 128));
		stage.addActor(im);
		im.setZIndex(1);
		carsL.add(im);

		im = new Image(carTextureL.get((int) (Math.random() * carTextureL
				.size())));
		im.setPosition((int) (Math.random() * 500 + 600), 26);
		im.addAction(Actions.moveTo(-120, 26, im.getX() / 128));
		stage.addActor(im);
		im.setZIndex(1);
		carsL.add(im);

		im = new Image(carTextureR.get((int) (Math.random() * carTextureR
				.size())));
		im.setPosition((int) (Math.random() * 500), 13); // 13 26
		im.addAction(Actions.moveTo(1280, 13, (1280 - im.getX()) / 128));
		stage.addActor(im);
		im.setZIndex(3);
		carsR.add(im);

		im = new Image(carTextureR.get((int) (Math.random() * carTextureR
				.size())));
		im.setPosition((int) (Math.random() * 500 + 600), 13); // 13 26
		im.addAction(Actions.moveTo(1280, 13, (1280 - im.getX()) / 128));
		stage.addActor(im);
		im.setZIndex(3);
		carsR.add(im);

		timeRspL = System.currentTimeMillis();
		timeRspR = System.currentTimeMillis();

	}

	public void draw() {
		int i, t;
		Image im;

		for (i = 0; i < carsR.size(); i++) {
			im = carsR.get(i);
			if (im.getZIndex() < 3) {
				Gdx.app.log("TrafficInMenu",
						"carsR im.getZIndex()=" + im.getZIndex());
				im.setZIndex(3);
			}
			if (im.getActions().size == 0) {
				im.remove();
				im = new Image(
						carTextureR.get((int) (Math.random() * carTextureR
								.size()))); // (int)
											// Math.random()*(carTextureR.size()-1)
				im.setPosition(-150, 13); // 13 26

				if (((System.currentTimeMillis() - timeRspR) / 1000) > 3) {
					t = 6;
				} else {
					t = 8;
				}
				im.addAction(Actions.moveTo(1280, 13, t));
				stage.addActor(im);
				carsR.remove(i);
				carsR.add(i, im);
				im.setZIndex(3);
				timeRspR = System.currentTimeMillis();
			}
		}

		for (i = 0; i < carsL.size(); i++) {
			im = carsL.get(i);
			if (im.getZIndex() > 2) {
				Gdx.app.log("TrafficInMenu",
						"carsL im.getZIndex()=" + im.getZIndex());
				im.setZIndex(1);
			}
			if (im.getActions().size == 0) {
				im.remove();
				im = new Image(
						carTextureL.get((int) (Math.random() * carTextureL
								.size())));
				im.setPosition(1280, 26); // 13 26
				if (((System.currentTimeMillis() - timeRspL) / 1000) > 3) {
					t = 6;
				} else {
					t = 8;
				}
				im.addAction(Actions.moveTo(-120, 26, t));
				stage.addActor(im);
				carsL.remove(i);
				carsL.add(i, im);
				im.setZIndex(1);
				timeRspL = System.currentTimeMillis();
			}
		}

	}

}
