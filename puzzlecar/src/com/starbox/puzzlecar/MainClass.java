package com.starbox.puzzlecar;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MainClass extends Game {

	public Menu2d menu2d;
	public TextureAtlas commonAtlas;
	public Settings settings;
	public Skin commonSkin;
	private static boolean premium = false;
	private static boolean StartErrorinQueryInventory = false;
	public int accuracy = 0;

	public Pay payFrame;

	@Override
	public void create() {
		settings = new Settings();
		settings.loadSettings();
		commonAtlas = new TextureAtlas("data/common.atlas");
		commonSkin = new Skin(commonAtlas);
		menu2d = new Menu2d(this);
		setScreen(menu2d);
		Gdx.input.setCatchBackKey(true);
		accuracy = payFrame.getAccuracy();
		if (premium) {
			settings.setPremium(payFrame.getAId());
		} else {
			if (StartErrorinQueryInventory)
				ErrorinQueryInventory();
		}

	}

	// /// common functions
	public TextureRegion[] GetAnimFrames(String RegionName, int width,
			int height) {
		TextureRegion tr = commonAtlas.findRegion(RegionName);
		int w = tr.getRegionWidth() / width;
		int h = tr.getRegionHeight() / height;
		TextureRegion[] Frames = new TextureRegion[w * h];
		int k = 0;
		for (int j = 0; j < (h); j++)
			for (int i = 0; i < (w); i++) {
				Frames[k] = new TextureRegion(tr.getTexture(), tr.getRegionX()
						+ i * width, tr.getRegionY() + j * height, width,
						height);
				++k;
			}
		return Frames;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean pr) {
		premium = pr;
		if (menu2d != null)
			menu2d.setPrenium();
		Gdx.app.log("PuzzleCar", "aId=" + payFrame.getAId());
		if ((settings != null) & (pr))
			if (!settings.isPremium(payFrame.getAId()))
				settings.setPremium(payFrame.getAId());
	}

	public void ErrorinQueryInventory() {
		if (settings == null) {
			StartErrorinQueryInventory = true;
			return;
		}
		if (settings.isPremium(payFrame.getAId())) {
			Gdx.app.log("PuzzleCar", "Premium be lasted");
			setPremium(true);
		}
	}

	public String getExitText() {
		if(settings.isLangRu()) {
			return "Для выхода, нажмите дважды";
		}else{
			return "To exit, press twice.";
		}		
	}

}
