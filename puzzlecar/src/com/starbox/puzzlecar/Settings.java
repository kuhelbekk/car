package com.starbox.puzzlecar;

import java.util.Locale;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Settings {

	private boolean sound = true;
	private boolean music = true;
	private boolean voice = true;
	private boolean help = true;
	private boolean langRu = true;
	private String premium = "";

	private static final String key = "C5M4#@KDE90FM*%";

	public boolean isSound() {
		return sound;
	}

	public void setSound(boolean sound) {
		this.sound = sound;
	}

	public boolean isVoice() {
		return voice;
	}

	public void setVoice(boolean voice) {
		this.voice = voice;
	}

	public boolean isHelp() {
		return help;
	}

	public void setHelp(boolean help) {
		this.help = help;
	}

	public boolean isMusic() {
		return music;
	}

	public void setMusic(boolean music) {
		this.music = music;
	}

	public boolean isLangRu() {
		return langRu;
	}

	public void setLangRu(boolean langRu) {
		this.langRu = langRu;
	}

	public void saveSettings() {
		Preferences prefs = Gdx.app.getPreferences("PuzzlePrefs");
		prefs.putBoolean("isVoice", isVoice());
		prefs.putBoolean("isMusic", isMusic());
		prefs.putBoolean("isLangRu", isLangRu());
		prefs.putBoolean("isSound", isSound());
		prefs.putString("isLang", premium);
		prefs.flush();
	}

	public void loadSettings() {

		Preferences prefs = Gdx.app.getPreferences("PuzzlePrefs");
		setVoice(prefs.getBoolean("isVoice", true));

		Gdx.app.log("Lang", Locale.getDefault().getDisplayLanguage());

		setLangRu(prefs.getBoolean("isLangRu", Locale.getDefault()
				.getDisplayLanguage().equals("русский")));
		setMusic(prefs.getBoolean("isMusic", true));
		setSound(prefs.getBoolean("isSound", true));
		premium = prefs.getString("isLang", "");
	}

	public boolean isPremium(String id) {
		boolean r = false;

		if (id.length() > 5) {
			if (premium.length() > 5) {
				r = premium.equals(encode(id, key));
			}
		}
		return r;
	}

	public void setPremium(String id) {

		if (id.length() > 5) {
			premium = encode(id, key);
			saveSettings();
		}
	}

	public static String encode(String pText, String pKey) {
		byte[] txt = pText.getBytes();
		byte[] key = pKey.getBytes();
		byte[] res = new byte[pText.length()];
		for (int i = 0; i < txt.length; i++) {
			res[i] = (byte) (txt[i] ^ key[i % key.length]);
		}
		return new String(res);
	}

}
