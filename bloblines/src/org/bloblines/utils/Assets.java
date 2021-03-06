package org.bloblines.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class Assets extends AssetManager {

	private BitmapFont fontSmall = null;
	private BitmapFont fontBig = null;

	public enum Textures {
		// @formatter:off
		SPLASH_SCREEN("img/hourglass.png"), 
		BATTLE_SCREEN("img/battle.jpg"), 
		
		SPRITE_LOCATION_DONE("characters/spot_done.png"), 
		SPRITE_PATH("characters/path.png"), 
		SPRITE_PATH_SELECTED("characters/path_selected.png"), 
		
		ICON_BOOK("icons/book.png"), 
		ICON_LOCATION("icons/map.png"), 
		ICON_PARAMS("icons/cog.png"), 
		ICON_BLOB("icons/drop.png"), 
		ICON_HEART("icons/heart.png"),
		ICON_SPEECH("icons/speech-bubble.png"),
		
		ICON_STATUS("icons/icons8/48/Food/protein-48.png"),
		ICON_QUEST_LOG("icons/icons8/48/Business/rules-48.png"),
		ICON_TRAVEL("icons/icons8/48/Maps/treasury_map-48.png"),
		ICON_CURRENT_ACTION("icons/icons8/48/Maps/map_marker-48.png"),
		ICON_SWORD("icons/icons8/48/Gaming/minecraft_sword-48.png"), 
		ICON_SHOP("icons/icons8/48/Business/shop-48.png"),
		ICON_BACK("icons/icons8/48/Arrows/undo-48.png"),
		
		ICON_0("icons/icons8/48/Alphabet/0-48.png"),
		ICON_1("icons/icons8/48/Alphabet/1-48.png"),
		ICON_2("icons/icons8/48/Alphabet/2-48.png"),
		ICON_3("icons/icons8/48/Alphabet/3-48.png"),
		ICON_4("icons/icons8/48/Alphabet/4-48.png"),
		ICON_5("icons/icons8/48/Alphabet/5-48.png"), 
		ICON_6("icons/icons8/48/Alphabet/6-48.png"), 
		ICON_7("icons/icons8/48/Alphabet/7-48.png"), 
		ICON_8("icons/icons8/48/Alphabet/8-48.png"), 
		ICON_9("icons/icons8/48/Alphabet/9-48.png"),

		TILE_FOG("world/hexagon/tileFogBig.png"), 
		TILE_WATER("world/hexagon/tileWaterBig.png"), 
		TILE_BEACH("world/hexagon/tileSandBig.png"), 
		TILE_GRASS("world/hexagon/tileGrassBig.png"), 
		TILE_HILL("world/hexagon/tileDirt_fullBig.png"), 
		TILE_MOUNTAIN("world/hexagon/tileSnowBig.png"),

		TILE_ELT_REACHABLE_LOCATION_GRASS("world/hexagon/tileGrass_tileBig.png"), 
		TILE_ELT_REACHABLE_LOCATION_SAND("world/hexagon/tileSand_tileBig.png"), 
		TILE_ELT_REACHABLE_LOCATION_SNOW("world/hexagon/tileSnow_tileBig.png"),
		TILE_ELT_REACHABLE_LOCATION_HILL("world/hexagon/tileDirt_tileBig.png"), 
		TILE_ELT_REACHABLE_LOCATION_SELECTED("world/hexagon/tileMagic_tileBig.png"), 
		
		TILE_ELT_SAND_CACTUS1("world/hexagon/treeCactus_1Big.png"),
		TILE_ELT_SAND_CACTUS2("world/hexagon/treeCactus_2Big.png"),
		TILE_ELT_SAND_CACTUS3("world/hexagon/treeCactus_3Big.png"),
		TILE_ELT_SAND_HILL("world/hexagon/hillSandBig.png"),
		TILE_ELT_WAVE("world/hexagon/waveWaterBig.png"); 
		// @formatter:on

		Textures(String path) {
			this.path = path;
		}

		private final String path;

		public String getPath() {
			return path;
		}
	}

	public Assets() {
		// Use LibGDX's default Arial font.
		loadFont();

		for (Textures t : Textures.values()) {
			load(t.path, Texture.class);
		}

		load("skins/uiskin.json", Skin.class);

	}

	public void postLoad() {
		getSkin().get(LabelStyle.class).font = fontSmall;
		getSkin().get(TextButtonStyle.class).font = fontSmall;
	}

	private void loadFont() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/arial.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 18;
		fontSmall = generator.generateFont(parameter); // font size 12 pixels
		parameter.size = 48;
		fontBig = generator.generateFont(parameter); // font size 36 pixels
		generator.dispose(); // don't forget to dispose to avoid memory leaks!
	}

	public BitmapFont getFontSmall() {
		return fontSmall;
	}

	public BitmapFont getFontBig() {
		return fontBig;
	}

	public Skin getSkin() {
		return get("skins/uiskin.json", Skin.class);
	}

	public Texture getTexture(Textures t) {
		return get(t.getPath(), Texture.class);
	}

	@Override
	public synchronized void dispose() {
		fontSmall.dispose();
		fontBig.dispose();
		super.dispose();
	}

}
