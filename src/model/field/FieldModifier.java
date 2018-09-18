package model.field;

import model.pokemon.Pokemon;
import model.types.Type;
import modelpokemon.status.StatusCondition;
import modelpokemon.status.StatusEffect;

public class FieldModifier {
  private int effectTime;
  private int currentEffectTime;
  
  private FieldEffect effect;
  
  public static final int INFINITE_TIME = Integer.MAX_VALUE;
  
  public static FieldModifier SUNNY = new FieldModifier(INFINITE_TIME, new FieldEffect() {
    public void applyFieldEffect(Pokemon p) {
      p.addStatusCondition(StatusCondition.SUNNY_CLIMATE);
    }
  });
  
  public static FieldModifier RAINY = new FieldModifier(INFINITE_TIME, new FieldEffect() {
    public void applyFieldEffect(Pokemon p) {
      p.addStatusCondition(StatusCondition.RAINY_CLIMATE);
    }
  });
  
  public static FieldModifier SANDSTORM = new FieldModifier(INFINITE_TIME, new FieldEffect() {
    public void applyFieldEffect(Pokemon p) {
      p.addStatusCondition(StatusCondition.SANDSTORM_CLIMATE);
    }
  });
  
  public FieldModifier(int effectTime, FieldEffect effect) {
    this.effectTime = effectTime;
    this.currentEffectTime = effectTime;
    this.effect = effect;
  }
  
  public FieldEffect getFieldEffect() {
    return this.effect;
  }
  
  public boolean isEffectOver() {
    return this.currentEffectTime <= 0;
  }
  
  public int getInitialEffectTime() {
    return this.effectTime;
  }
  
  public void removeTimeCounter() {
    this.currentEffectTime--;
  }
}
