package rpg;

import java.util.Random;

public class Dice {
	private static int getRandomNumberInRange(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	public static int d4() {
		return getRandomNumberInRange(1, 4);
	}
	
	public static int d6() {
		return getRandomNumberInRange(1, 6);
	}
	
	public static int d8() {
		return getRandomNumberInRange(1, 8);
	}
	
	public static int d10() {
		return getRandomNumberInRange(1, 10);
	}
	
	public static int d12() {
		return getRandomNumberInRange(1, 12);
	}
	
	public static int d20() {
		return getRandomNumberInRange(1, 20);
	}
	
	public static int d20adv() {
		return Math.max(d20(), d20());
	}
}
