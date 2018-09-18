package main;

import moves.BasicMoveList;
import moves.Move;
import moves.TMList;
import pokemon.Pokemon;
import types.Type;

public class Main {
  public static void main(String[] args) {
    Pokemon eevee = new Pokemon("eevee", 5, 2, 2, 2, 3, 2, Type.NORMAL);

    eevee.getMoveSet().addBasicMove(BasicMoveList.Tackle());
    
    eevee.getMoveSet().addTMMove(TMList.Fissure());
    eevee.getMoveSet().addTMMove(TMList.SomethingThatParalizes()); // Shouldn't add because rules
    
    printMoves(eevee);
  }
  
  private static void printMoves(Pokemon p) {
    for(Move m : p.getMoveSet().getBasicMoves()) {
      System.out.println("(B) " + m.getName());
    }
    
    for(Move m : p.getMoveSet().getTMs()) {
      System.out.println("(T) " + m.getName());
    }
  }
}
