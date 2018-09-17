package moves;

public class Modifiers {
	private final int NUMBER_OF_MODIFIERS = 7;
	
	public static final int DAMAGE_MOD_I = 0;
	public static final int ACCURACY_MOD_I = 1;
	public static final int ATTACK_MOD_I = 2;
	public static final int DEFENSE_MOD_I = 3;
	public static final int SP_ATTACK_MOD_I = 4;
	public static final int SP_DEFENSE_MOD_I = 5;
	public static final int SPEED_MOD_I = 6;
	
	public static final int ONE_TURN_ONLY = 1;
	
	private int[] modifiers = new int[NUMBER_OF_MODIFIERS];
	private int[] modifiersCount = new int[NUMBER_OF_MODIFIERS];
	
	public Modifiers() {
		for(int i = 0; i < NUMBER_OF_MODIFIERS; i++) {
			this.modifiers[i] = 0;
			this.modifiersCount[i] = 0;
		}
	}
	
	public Modifiers(int[] modifiers, int[] count) {
		for(int i = 0; i < NUMBER_OF_MODIFIERS; i++) {
			this.modifiers[i] = modifiers[i];
			this.modifiersCount[i] = count[i];
		}
	}
	
	public void addAttackModifier(int mod, int time) {
		modifiers[ATTACK_MOD_I] = mod;
		modifiersCount[ATTACK_MOD_I] = time;
	}
	
	public void addDamageModifier(int mod, int time) {
		modifiers[DAMAGE_MOD_I] = mod;
		modifiersCount[DAMAGE_MOD_I] = time;
	}
	
	
	/*
	 * DEFAULTS
	 */
	public static Modifiers attackModifier(int mod, int time) {
		Modifiers m = new Modifiers();
		m.addAttackModifier(mod, time);
		return m;
	}
	
	public static Modifiers damageModifier(int mod, int time) {
		Modifiers m = new Modifiers();
		m.addDamageModifier(mod, time);
		return m;
	}
}
