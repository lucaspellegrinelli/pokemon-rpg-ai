package model.pokemon;

import java.util.Vector;
import java.util.function.Predicate;

import model.moves.Move;
import model.types.Type;
import modelpokemon.status.StatusCondition;

public class Pokemon {
  private String name;
  
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
  
  public Pokemon(String name, int hp, int atk, int def, int spa, int sde, int spd, Type type) {
    this.name = name.toLowerCase();
    
    this.baseHP = hp;
    this.currentHP = hp;
    
    this.baseAttack = atk;
    this.currentAttack = atk;
    
    this.baseDefense = def;
    this.currentDefense = def;
    
    this.baseSpAttack = spa;
    this.currentSpAttack = spa;
    
    this.baseSpDefense = sde;
    this.currentSpDefense = sde;
    
    this.baseSpeed = spd;
    this.currentSpeed = spd;
    
    this.type = type;
    
    this.ableToAttack = true;
    this.ableToDefend = true;
    
    this.moveSet = new MoveSet(this);
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
  
  public String getName() {
    return this.name;
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
  
  public void addHP(int howMuch) {
    this.currentHP = Math.max(0, this.currentHP + howMuch);
  }
  
  public int getCurrentHP() {
    return this.currentHP;
  }
  
  public void addAttack(int howMuch) {
    this.currentAttack = Math.max(0, this.currentAttack + howMuch);
  }

  public int getCurrentAttack() {
    return this.currentAttack;
  }
  
  public void addDefense(int howMuch) {
    this.currentDefense = Math.max(0, this.currentDefense + howMuch);
  }
  
  public int getCurrentDefense() {
    return this.currentDefense;
  }
  
  public void addSpAttack(int howMuch) {
    this.currentSpAttack = Math.max(0, this.currentSpAttack + howMuch);
  }
  
  public int getCurrentSpAttack() {
    return this.currentSpAttack;
  }
  
  public void addSpDefense(int howMuch) {
    this.currentSpDefense = Math.max(0, this.currentSpDefense + howMuch);
  }
  
  public int getCurrentSpDefense() {
    return this.currentSpDefense;
  }
  
  public void addSpeed(int howMuch) {
    this.currentSpeed = Math.max(0, this.currentSpeed + howMuch);
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

  @Override
  public boolean equals(Object obj) {
    if(obj == null) return false;
    if(!(obj instanceof Pokemon)) return false;
    
    Pokemon p = (Pokemon)obj;
    return p.getName().equals(this.name);
  }
  
  @Override
  public String toString() {
    return "Name:\t\t" + this.name + "\n" +
           "Attack:\t\t" + this.currentAttack + "\n" +
           "Defense:\t" + this.currentDefense + "\n" +
           "Sp Attack:\t" + this.currentSpAttack + "\n" +
           "Sp Defense:\t" + this.currentSpDefense + "\n" +
           "Speed:\t\t" + this.currentSpeed + "\n";
  }
}
