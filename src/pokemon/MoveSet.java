package pokemon;

import java.util.ArrayList;
import java.util.List;

import moves.Modifiers;
import moves.Move;
import types.Type;

public class MoveSet {
  private final int MAX_TM_COUNT = 4;
  
  private Move basicMove;
  private List<Move> tmMoves = new ArrayList<>();
  
  public MoveSet(Move basicMove) {
    this.basicMove = basicMove;
  }
  
  public List<Move> getTMs(){
    return this.tmMoves;
  }
  
  public Move getBasicMove() {
    return this.basicMove;
  }
  
  public int getNumberOfTMs() {
    return tmMoves.size();
  }
  
  public void addMove(Move m) {
    if(tmMoves.size() < MAX_TM_COUNT) tmMoves.add(m);
  }
  
  public int countMovesOfType(Type type) {
    int count = 0;
    for(Move m : tmMoves) {
      if(m.getType() == type) count++;
    }
    
    return count;
  }
  
  public void addModifiersToMove(String name, Modifiers mod) {
    if(this.basicMove.getName().equals(name)) {
      this.basicMove.addModifier(mod);
    }else {
      for(int i = 0; i < tmMoves.size(); i++) {
        if(tmMoves.get(i).getName().equals(name)) {
          tmMoves.get(i).addModifier(mod);
          break;
        }
      }
    }
  }
}
