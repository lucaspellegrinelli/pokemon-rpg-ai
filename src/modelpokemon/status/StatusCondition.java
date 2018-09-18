package modelpokemon.status;

import model.pokemon.Pokemon;
import model.types.Type;
import rpg.Dice;

public class StatusCondition {
  private String name;
  private int turnsLeft;
  private StatusEffect effect;
  
  public static int INFINITE_TIME = Integer.MAX_VALUE;
  
  public static StatusCondition BURN = new StatusCondition("burn", INFINITE_TIME, new StatusEffect() {
    public void applyStatus(Pokemon pokemon) {
      int d6 = Dice.d6();
      
      if(d6 == 1) {
        pokemon.addHP(-1);
        pokemon.addAttack(-2);
      }else if(d6 >= 2 && d6 <= 5) {
        pokemon.addAttack(-2);
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
        pokemon.addSpeed(-2);
      }else if(d6 >= 2 && d6 <= 4) {
        pokemon.addSpeed(-2);
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
        pokemon.addHP(-1);
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
        pokemon.addAttack(-1);
        pokemon.addDefense(-1);
        pokemon.addSpAttack(-1);
        pokemon.addSpDefense(-1);
        pokemon.addSpeed(-3);
      }else {
        pokemon.addSpeed(-3);
      }
    }
  });
  
  public static String[] CLIMATE_NAMES = {"sunny", "rainy", "sandstorm"};
  
  public static StatusCondition SUNNY_CLIMATE = new StatusCondition("sunny", 1, new StatusEffect() {
    public void applyStatus(Pokemon pokemon) {
      if(pokemon.getType() == Type.FIRE || pokemon.getType() == Type.GRASS) pokemon.addAttack(1);
      else if(pokemon.getType() == Type.WATER) pokemon.addAttack(-1);
    }
  });
  
  public static StatusCondition RAINY_CLIMATE = new StatusCondition("rainy", 1, new StatusEffect() {
    public void applyStatus(Pokemon pokemon) {
      if(pokemon.getType() == Type.WATER || pokemon.getType() == Type.ELETRIC) pokemon.addAttack(1);
      else if(pokemon.getType() == Type.FIRE) pokemon.addAttack(-1);
    }
  });
  
  public static StatusCondition SANDSTORM_CLIMATE = new StatusCondition("sandstorm", 1, new StatusEffect() {
    public void applyStatus(Pokemon pokemon) {
      if(pokemon.getType() != Type.ROCK && pokemon.getType() != Type.GROUND &&
          pokemon.getType() != Type.STEEL && pokemon.getType() != Type.PSYCHIC) {
        pokemon.addAttack(-2);
        pokemon.addDefense(-2);
      }else if(pokemon.getType() == Type.ROCK) {
        pokemon.addSpDefense(1);
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
