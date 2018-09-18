package model.field;

import model.pokemon.Pokemon;

public class Battlefield {
  private FieldModifier modifier;
  
  public Battlefield() {
    modifier = null;
  }
  
  public void replaceModifier(FieldModifier mod) {
    this.modifier = mod;
  }
  
  public FieldModifier getModifier() {
    return this.modifier;
  }
  
  public void applyFieldEffects(Pokemon p) {
    modifier.getFieldEffect().applyFieldEffect(p);
    modifier.removeTimeCounter();
  }
  
  public void removeEndedFieldEffects() {
    if(modifier.isEffectOver()) {
      modifier = null;
    }
  }
  
  public boolean hasModifier() {
    return modifier != null;
  }
}
