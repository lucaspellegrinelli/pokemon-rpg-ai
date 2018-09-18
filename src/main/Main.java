package main;

import model.field.Battlefield;
import model.field.FieldModifier;
import model.moves.BasicMoveList;
import model.moves.Move;
import model.moves.TMList;
import model.pokemon.Pokemon;
import model.pokemon.PokemonTeam;
import model.types.Type;

public class Main {
  public static void main(String[] args) {
    Battlefield battlefield = new Battlefield();
    battlefield.addModifier(FieldModifier.SANDSTORM);
    
    Pokemon eevee = new Pokemon("eevee", 5, 2, 2, 2, 3, 2, Type.NORMAL);
    eevee.getMoveSet().addBasicMove(BasicMoveList.Tackle());
    eevee.getMoveSet().addTMMove(TMList.Fissure());
    
    for(FieldModifier f : battlefield.getAllModifiers()) {
      f.getFieldEffect().applyFieldEffect(eevee);
    }
    
    eevee.applyStatusConditions();
    eevee.removeAllStatsModifiers();
    
    System.out.println(eevee);

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
