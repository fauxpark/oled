package net.fauxpark.oled.impl;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.spi.SpiChannel;

import net.fauxpark.oled.SSD1306;

/**
 * A mock SSD1306 driver, for use when testing on platforms other than the Raspberry Pi.
 *
 * @author fauxpark
 */
public class SSD1306MockImpl extends SSD1306 {
	/**
	 * SSD1306MockImpl constructor.
	 *
	 * @param width The width of the display in pixels.
	 * @param height The height of the display in pixels.
	 * @param channel Ignored.
	 * @param rstPin Ignored.
	 * @param dcPin Ignored.
	 */
	public SSD1306MockImpl(int width, int height, SpiChannel channel, Pin rstPin, Pin dcPin) {
		super(width, height);
	}

	@Override
	public void startup(boolean externalVcc) {
		reset();
		setInverted(false);
		setDisplayState(true);
		clear();
		display();
	}

	@Override
	public void shutdown() {
		clear();
		display();
		setDisplayState(false);
		reset();
	}

	@Override
	public void reset() {}

	@Override
	public synchronized void display() {}

	@Override
	public void scrollHorizontally(boolean direction, int start, int end, int step) {}

	@Override
	public void scrollDiagonally(boolean direction, int start, int end, int step) {}

	@Override
	public void stopScroll() {}

	@Override
	public void command(int command, int... params) {}

	@Override
	public void data(byte[] data) {}
}
