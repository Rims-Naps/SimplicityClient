package com.simplicity.client.widget;

import com.simplicity.client.RSInterface;
import com.simplicity.client.TextDrawingArea;

import java.util.Random;

/**
 * A class that handles the collection log interface.
 * 
 * @author Blake
 *
 */
public class TobPlayerOrbsWidget extends RSInterface {

	/**
	 * The interface id.
	 */
	public static final int INTERFACE_ID = 80_000;

	public static final int HEALTH_ORB = 1413;
	public static final int AWAITING_ENTER_ORB = 1414;
	public static final int EMPTY_ORB = 1415;
	public static final int BASE_ORB = 1412;

	public static final int HEALTH_ORB_HEIGHT = 37;

	public static boolean isClosed = false;
	public static boolean isClosing = false;

	public static int closeButtonX;
	public static int closeButtonY;

	/**
	 * Unpacks the interface.
	 */
	public static void unpack(TextDrawingArea[] tda) {
		int id = INTERFACE_ID;

		RSInterface rsi = addInterface(id++);

		rsi.totalChildren(5);

		int child = 0;
		int y = 15;

		addOrb(id);
		rsi.child(child++, id++, 10, y);
		y += 48;

		addOrb(id);
		rsi.child(child++, id++, 10, y);
		y += 48;

		addOrb(id);
		rsi.child(child++, id++, 10, y);
		y += 48;

		addOrb(id);
		rsi.child(child++, id++, 10, y);
		y += 48;

		addOrb(id);
		rsi.child(child, id, 10, y);

	}


	private static RSInterface addOrb(int id) {
		Random random = new Random();

		RSInterface rsi = addInterface(id);
		rsi.type = 50;
		rsi.message = "Arthur:true:" + random.nextInt(100);

		return rsi;
	}

}
