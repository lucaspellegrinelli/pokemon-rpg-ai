package pokemon;

import java.util.Vector;
import java.util.function.Predicate;

import pokemon.status.StatusCondition;
import types.Type;

public class Pokemon {
  private int baseHP;
  private int currentHP;
  
  private int baseAttack;
  private int currentAttack;
  
  private int baseDefense;
  private int currentDefense;
  
  private int baseSpAttack;
  private int currentSpAttack;
  
  private int baseSpDefense;
  private int currentSpDefense;
  
  private int baseSpeed;
  private int currentSpeed;
  
  private boolean ableToAttack;
  private boolean ableToDefend;
  
  private Type type;
  private MoveSet moveSet;
  private Vector<StatusCondition> statusConditions = new Vector<>();
  
  public Pokemon(int hp, int atk, int def, int spa, int sde, int spd, Type type) {
    this.baseHP = hp;
    this.currentHP = hp;
    
    this.baseAttack = atk;
    this.currentAttack = atk;
    
    this.baseDefense = def;
    this.currentDefense = def;
    
    this.baseSpAttack = spa;
    this.currentSpAttack = spa;
    
    this.baseSpDefense = sde;
    this.currentDefense = sde;
    
    this.baseSpeed = spd;
    this.currentSpeed = spd;
    
    this.type = type;
    
    this.ableToAttack = true;
    this.ableToDefend = true;
  }
  
  public void applyStatusConditions() {
    for(int i = 0; i < this.statusConditions.size(); i++) {
      if(this.statusConditions.get(i).isOver()) continue;
      this.statusConditions.get(i).getEffect().applyStatus(this);
      this.statusConditions.get(i).removeTurnsLeft();
    }
    
    removeAllFinishedStatusConditions();
  }
  
  private void removeAllFinishedStatusConditions() {
    this.statusConditions.removeIf(new Predicate<StatusCondition>() {
      public boolean test(StatusCondition sc) {
        return sc.isOver();
      }
    });
  }
  
  public void removeSpecificStatusCondition(String name) {
    this.statusConditions.removeIf(new Predicate<StatusCondition>() {
      public boolean test(StatusCondition sc) {
        return sc.getName().equals(name);
      }
    });
  }
  
  public void removeAllStatsModifiers() {
    this.currentAttack = this.baseAttack;
    this.currentDefense = this.baseDefense;
    this.currentSpAttack = this.baseSpAttack;
    this.currentSpDefense = this.baseSpDefense;
    this.currentSpeed = this.baseSpeed;
    this.ableToAttack = true;
    this.ableToDefend = true;
  }

  public int getBaseHP() {
    return this.baseHP;
  }
  
  public int getBaseAttack() {
    return this.baseAttack;
  }
  
  public int getBaseDefense() {
    return this.baseDefense;
  }
  
  public int getBaseSpAttack() {
    return this.baseSpAttack;
  }
  
  public int getBaseSpDefense() {
    return this.baseSpDefense;
  }
  
  public int getBaseSpeed() {
    return this.baseSpeed;
  }
  
  public void removeHP(int howMuch) {
    this.currentHP -= Math.min(howMuch, this.currentHP);
  }
  
  public int getCurrentHP() {
    return this.currentHP;
  }
  
  public void removeAttack(int howMuch) {
    this.currentAttack -= Math.min(howMuch, this.currentAttack);
  }

  public int getCurrentAttack() {
    return this.currentAttack;
  }
  
  public void removeDefense(int howMuch) {
    this.currentDefense -= Math.min(howMuch, this.currentDefense);
  }
  
  public int getCurrentDefense() {
    return this.currentDefense;
  }
  
  public void removeSpAttack(int howMuch) {
    this.currentSpAttack -= Math.min(howMuch, this.currentSpAttack);
  }
  
  public int getCurrentSpAttack() {
    return this.currentSpAttack;
  }
  
  public void removeSpDefense(int howMuch) {
    this.currentSpDefense -= Math.min(howMuch, this.currentSpDefense);
  }
  
  public int getCurrentSpDefense() {
    return this.currentSpDefense;
  }
  
  public void removeSpeed(int howMuch) {
    this.currentSpeed -= Math.min(howMuch, this.currentSpeed);
  }
  
  public int getCurrentSpeed() {
    return this.currentSpeed;
  }
  
  public void setAbleToAttack(boolean ableToAttack) {
    this.ableToAttack = ableToAttack;
  }
  
  public boolean isAbleToAttack() {
    return this.ableToAttack;
  }
  
  public void setAbleToDefend(boolean ableToDefend) {
    this.ableToDefend = ableToDefend;
  }
  
  public boolean isAbleToDefend() {
    return this.ableToDefend;
  }
  
  public MoveSet getMoveSet() {
    return this.moveSet;
  }
  
  public Type getType() {
    return this.type;
  }
  
  public void addStatusCondition(StatusCondition sc) {
    this.statusConditions.addElement(sc);
  }
  
  public Vector<StatusCondition> getStatusConditions(){
    return this.statusConditions;
  }
}
