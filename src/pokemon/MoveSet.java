package pokemon;

import java.util.Vector;

import moves.MoveModifiers;
import moves.Move;
import types.Type;

public class MoveSet {
  private final int MAX_TM_COUNT = 4;
  
  private Pokemon host;
  private Vector<Move> basicMoves = new Vector<>();
  private Vector<Move> tmMoves = new Vector<>();
  
  public MoveSet(Pokemon host) {
    this.host = host;
  }
  
  public Vector<Move> getTMs(){
    return this.tmMoves;
  }
  
  public Vector<Move> getBasicMoves() {
    return this.basicMoves;
  }
  
  public int getNumberOfTMs() {
    return tmMoves.size();
  }
  
  public void addTMMove(Move m) {
    int nTMs = Math.min(MAX_TM_COUNT, host.getBaseSpeed());
    if(tmMoves.size() < nTMs && m.getAcquireRestriction().canAcquire(this.host)) tmMoves.add(m);
  }
  
  public void addBasicMove(Move m) {
    if(m.getAcquireRestriction().canAcquire(this.host)) basicMoves.add(m);
  }
  
  public int countMovesOfType(Type type) {
    int count = 0;
    for(Move m : tmMoves) {
      if(m.getType() == type) count++;
    }
    
    return count;
  }
  
  public void addModifiersToMove(String name, MoveModifiers mod) {
    for(int i = 0; i < basicMoves.size(); i++) {
      if(basicMoves.get(i).getName().equals(name)) {
        basicMoves.get(i).addModifier(mod);
        return;
      }
    }
    
    for(int i = 0; i < tmMoves.size(); i++) {
      if(tmMoves.get(i).getName().equals(name)) {
        tmMoves.get(i).addModifier(mod);
        return;
      }
    }
  }
}
