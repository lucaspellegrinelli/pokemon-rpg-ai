package pokemon.status;

import pokemon.Pokemon;
import rpg.Dice;

public class StatusCondition {
  private String name;
  private int turnsLeft;
  private StatusEffect effect;
  
  private static int INFINITE_TIME = Integer.MAX_VALUE;
  
  public static StatusCondition BURN = new StatusCondition("burn", INFINITE_TIME, new StatusEffect() {
    public void applyStatus(Pokemon pokemon) {
      int d6 = Dice.d6();
      
      if(d6 == 1) {
        pokemon.removeHP(1);
        pokemon.removeAttack(-2);
      }else if(d6 >= 2 && d6 <= 5) {
        pokemon.removeAttack(-2);
      }else {
        pokemon.removeSpecificStatusCondition("paralize");
      }
    }
  });
  
  public static StatusCondition SLEEP = new StatusCondition("sleep", INFINITE_TIME, new StatusEffect() {
    public void applyStatus(Pokemon pokemon) {
      int d6 = Dice.d6();
      
      if(d6 <= 3) {
        pokemon.setAbleToAttack(false);
        pokemon.setAbleToDefend(false);
      }else {
        pokemon.removeSpecificStatusCondition("sleep");
      }
    }
  });
  
  public static StatusCondition PARALIZE = new StatusCondition("paralize", INFINITE_TIME, new StatusEffect() {
    public void applyStatus(Pokemon pokemon) {
      int d6 = Dice.d6();
      
      if(d6 == 1) {
        pokemon.setAbleToAttack(false);
        pokemon.removeSpeed(-2);
      }else if(d6 >= 2 && d6 <= 4) {
        pokemon.removeSpeed(-2);
      }else {
        pokemon.removeSpecificStatusCondition("paralize");
      }
    }
  });
  
  public static StatusCondition CONFUSE = new StatusCondition("confuse", INFINITE_TIME, new StatusEffect() {
    public void applyStatus(Pokemon pokemon) {
      int d6 = Dice.d6();
      
      if(d6 == 1 || d6 == 2) {
        pokemon.setAbleToAttack(false);
        pokemon.removeHP(1);
      }else if(d6 == 3 || d6 == 4) {
        // Nothing
      }else {
        pokemon.removeSpecificStatusCondition("confuse");
      }
    }
  });
  
  public static StatusCondition FREEZE = new StatusCondition("freeze", 4, new StatusEffect() {
    public void applyStatus(Pokemon pokemon) {
      if(pokemon.getCurrentSpeed() <= 3) {
        pokemon.removeAttack(1);
        pokemon.removeDefense(1);
        pokemon.removeSpAttack(1);
        pokemon.removeSpDefense(1);
        pokemon.removeSpeed(3);
      }else {
        pokemon.removeSpeed(3);
      }
    }
  });
  
  public StatusCondition(String name, int turns, StatusEffect effect) {
    this.name = name.toLowerCase();
    this.turnsLeft = turns;
    this.effect = effect;
  }
  
  public String getName() {
    return this.name;
  }
  
  public StatusEffect getEffect() {
    return this.effect;
  }
  
  public void removeTurnsLeft() {
    this.turnsLeft--;
  }
  
  public boolean isOver() {
    return this.turnsLeft <= 0;
  }
}
