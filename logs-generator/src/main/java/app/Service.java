package app;

import java.util.Random;

import org.apache.commons.text.WordUtils;

public enum Service {
	INVOICE, PAYROLL, USER, ACCOUNTING, PURCHASING;

	private static final Service[] VALUES = values();
	private static final int SIZE = VALUES.length;
	private static final Random RANDOM = new Random();

	@Override
	public String toString() {
		return WordUtils.capitalizeFully(super.toString());
	}

	public static Service getRandom() {
		return VALUES[RANDOM.nextInt(SIZE)];
	}
}
