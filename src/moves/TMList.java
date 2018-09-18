package moves;

import java.util.ArrayList;
import java.util.List;

import pokemon.Pokemon;
import pokemon.status.StatusCondition;
import types.Type;
import types.TypeInteractions;

public class TMList {
  List<Move> tms = new ArrayList<>();
  
  TMList(){
    initializeTMs();
  }
  
  private void initializeTMs() {
    tms.add(Fissure());
  }
  
  public List<Move> getAllTMs(){
    return this.tms;
  }
  
  public static Move SomethingThatParalizes() {
    String name = "paralize_test";
    Move m = new Move(name, 0, 1, +10, Move.SPECIAL_ATTACK, Type.ELETRIC, false, new AcquireRestriction() {
      public boolean canAcquire(Pokemon p) {
        return TypeInteractions.canLearnTypeMove(p, Type.ELETRIC);
      }
    });
    
    m.addEffect(new Effect(){
      public void applyEffect(Pokemon attacking, Pokemon defending) {
        if(defending.getType() != Type.GROUND) {
          attacking.addStatusCondition(StatusCondition.PARALIZE);
        }
      }
    });
    
    return m;
  }
  
  public static Move Fissure() {
    String name = "fissure";
    Move fissure = new Move(name, 6, 4, -7, Move.PHYSICAL_ATTACK, Type.GROUND, false, new AcquireRestriction() {
      public boolean canAcquire(Pokemon p) {
        return TypeInteractions.canLearnTypeMove(p, Type.GROUND);
      }
    });
    
    fissure.addEffect(new Effect(){
      public void applyEffect(Pokemon attacking, Pokemon defending) {
        if(defending.getType() != Type.GROUND) {
          attacking.getMoveSet().addModifiersToMove(name, MoveModifiers.damageModifier(-1, MoveModifiers.ONE_TURN_ONLY));
        }
      }
    });
    
    return fissure;
  }
}
