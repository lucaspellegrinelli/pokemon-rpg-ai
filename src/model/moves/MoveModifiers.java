package model.moves;

public class MoveModifiers {
  private final int NUMBER_OF_MODIFIERS = 3;
  
  public static final int DAMAGE_MOD_I = 0;
  public static final int ACCURACY_MOD_I = 1;
  public static final int COOLDOWN_MOD_I = 2;
  
  public static final int ONE_TURN_ONLY = 1;
  
  private int[] modifiers = new int[NUMBER_OF_MODIFIERS];
  private int[] modifiersCount = new int[NUMBER_OF_MODIFIERS];
  
  public MoveModifiers() {
    for(int i = 0; i < NUMBER_OF_MODIFIERS; i++) {
      this.modifiers[i] = 0;
      this.modifiersCount[i] = 0;
    }
  }
  
  public MoveModifiers(int[] modifiers, int[] count) {
    for(int i = 0; i < NUMBER_OF_MODIFIERS; i++) {
      this.modifiers[i] = modifiers[i];
      this.modifiersCount[i] = count[i];
    }
  }
  
  public int getDamageModifier() {
    return modifiers[DAMAGE_MOD_I];
  }
  
  public int getAccuracyModifier() {
    return modifiers[ACCURACY_MOD_I];
  }
  
  public int getCooldownModifier() {
    return modifiers[COOLDOWN_MOD_I];
  }
  
  public void removeAllModifiersCount() {
    for(int i = 0; i < this.modifiersCount.length; i++) {
      if(this.modifiersCount[i] > 0) {
        this.modifiersCount[i]--;
      }
    }
  }

  public void addDamageModifier(int mod, int time) {
    modifiers[DAMAGE_MOD_I] = mod;
    modifiersCount[DAMAGE_MOD_I] = time;
  }
  
  public void addAccuracyModifier(int mod, int time) {
    modifiers[ACCURACY_MOD_I] = mod;
    modifiersCount[ACCURACY_MOD_I] = time;
  }
  
  public void addCooldownModifier(int mod, int time) {
    modifiers[COOLDOWN_MOD_I] = mod;
    modifiersCount[COOLDOWN_MOD_I] = time;
  }
  
  
  /*
   * DEFAULTS
   */
  public static MoveModifiers damageModifier(int mod, int time) {
    MoveModifiers m = new MoveModifiers();
    m.addDamageModifier(mod, time);
    return m;
  }
  
  public static MoveModifiers accuracyyModifier(int mod, int time) {
    MoveModifiers m = new MoveModifiers();
    m.addAccuracyModifier(mod, time);
    return m;
  }
  
  public static MoveModifiers cooldownModifier(int mod, int time) {
    MoveModifiers m = new MoveModifiers();
    m.addCooldownModifier(mod, time);
    return m;
  }
  
  
  public boolean areAllModifiersOver() {
    for(int c : this.modifiersCount) {
      if(c > 0) return false;
    }
    
    return true;
  }
}
