package com.simplicity.client.content;

import com.simplicity.client.SpriteLoader;

/**
 * Creates a flashing sprite
 * 
 * @author 2012 <https://www.rune-server.ee/members/dexter+morgan/>
 *
 */
public class FlashingSprite {
	
	/**
	 * The default flashing rate
	 */
	private static final int DEFAULT_FLASH_RATE = 4;

	/**
	 * The opacity
	 */
	private int opacity;

	/**
	 * The interpolate state
	 */
	private boolean decrease;
	
	/**
	 * Creates a new flashing sprite
	 */
	public FlashingSprite() {
		opacity = 250;
	}
	
	/**
	 * Draws the sprite
	 * @param sprite the sprite
	 * @param x the x
	 * @param y the y
	 * @param rate the rate
	 */
	public void drawFlashingSprite(int sprite, int x, int y, int rate) {
		if (opacity >= 250) {
			decrease = true;
		}
		if (opacity <= 128) {
			decrease = false;
		}
		if (decrease) {
			opacity -= rate;
		} else {
			opacity += rate;
		}
		SpriteLoader.sprites[sprite].drawSprite3(x, y, opacity);
	}
	
	/**
	 * Drawing a flashing sprite
	 * @param sprite the sprite
	 * @param x the x
	 * @param y the y
	 */
	public void drawFlashingSprite(int sprite, int x, int y) {
		drawFlashingSprite(sprite, x, y, DEFAULT_FLASH_RATE);
	}

}
