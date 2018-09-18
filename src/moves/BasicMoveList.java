package moves;

import java.util.ArrayList;
import java.util.List;

import pokemon.Pokemon;
import types.Type;
import types.TypeInteractions;

public class BasicMoveList {
  List<Move> basicMoves = new ArrayList<>();
  
  BasicMoveList(){
    initializeBasicMoves();
  }
  
  private void initializeBasicMoves() {
    
  }
  
  public List<Move> getAllBasicMoves() {
    return this.basicMoves;
  }
  
  public static Move Tackle() {
    String name = "tackle";
    Move m = new Move(name, 1, 1, 0, Move.PHYSICAL_ATTACK, Type.NORMAL, false, new AcquireRestriction() {
      public boolean canAcquire(Pokemon p) {
        return TypeInteractions.canLearnTypeMove(p, Type.NORMAL);
      }
    });
    
    return m;
  }
}
