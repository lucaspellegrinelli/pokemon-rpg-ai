package pokemon;

import types.Type;

public class Pokemon {
  private int maxHP;
  private int baseAttack;
  private int baseDefense;
  private int baseSpAttack;
  private int baseSpDefense;
  private int baseSpeed;
  
  private Type type;
  private MoveSet moveSet;
  
  public MoveSet getMoveSet() {
    return this.moveSet;
  }
  
  public Type getType() {
    return this.type;
  }
}
