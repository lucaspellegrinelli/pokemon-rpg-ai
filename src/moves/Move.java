package moves;

import java.util.Vector;
import java.util.function.Predicate;

import types.*;

public class Move {
  public static final int PHYSICAL_ATTACK = 0;
  public static final int SPECIAL_ATTACK = 1;
  
  private String name;
  
  private int baseDamage;
  private int currentDamage;
  
  private int baseCooldown;
  private int currentCooldown;
  
  private int baseAccuracy;
  private int currentAccuracy;
  
  private int contact_type;
  private Type type;
  private boolean priority;
  
  private AcquireRestriction acqRestriction;
  
  private Vector<Effect> effects = new Vector<>(); // Special effects like paralizing etc
  
  private Vector<MoveModifiers> modifiers = new Vector<>(); // +1s -1s ...
  
  public Move(String name, int dmg, int cd, int acc, int ctyp, Type type, boolean priority, AcquireRestriction acqRestriction) {
    this.name = name.toLowerCase();
    
    this.baseDamage = dmg;
    this.currentDamage = dmg;
    this.baseCooldown = cd;
    this.currentCooldown = cd;
    this.baseAccuracy = acc;
    this.currentAccuracy = acc;
    
    this.contact_type = ctyp;
    this.type = type;
    this.priority = priority;
    
    this.acqRestriction = acqRestriction;
  }
  
  public Move addEffect(Effect effect) {
    this.effects.add(effect);
    return this;
  }
  
  public void addModifier(MoveModifiers m) {
    this.modifiers.add(m);
  }
  
  public Type getType() {
    return this.type;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void applyModifiers() {
    for(int i = 0; i < this.modifiers.size(); i++) {
      if(this.modifiers.get(i).areAllModifiersOver()) continue;
       
      this.currentDamage -= this.modifiers.get(i).getDamageModifier();
      this.currentAccuracy -= this.modifiers.get(i).getAccuracyModifier();
      this.currentCooldown -= this.modifiers.get(i).getCooldownModifier();
    }
    
    removeAllFinishedModifiers();
  }
  
  private void removeAllFinishedModifiers() {
    this.modifiers.removeIf(new Predicate<MoveModifiers>() {
      public boolean test(MoveModifiers m) {
        return m.areAllModifiersOver();
      }
    });
  }
  
  public void removeAllStatsModifiers() {
    this.currentDamage = this.baseDamage;
    this.currentCooldown = this.baseCooldown;
    this.currentAccuracy = this.baseAccuracy;
  }
}
