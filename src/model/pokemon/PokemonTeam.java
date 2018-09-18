package model.pokemon;

import java.util.Vector;
import java.util.function.Predicate;

public class PokemonTeam {
  private final int MAX_POKEMON_COUNT = 6;
  
  private Vector<Pokemon> pokemons = new Vector<>();
  private int activePokemonIndex = 0;
  
  public PokemonTeam() {
  }
  
  public Vector<Pokemon> getPokemons(){
    return this.pokemons;
  }
  
  public void addPokemon(Pokemon p) {
    if(pokemons.size() < MAX_POKEMON_COUNT) {
      pokemons.add(p);
    }
  }
  
  public Pokemon getActivePokemon() {
    return this.pokemons.get(activePokemonIndex);
  }
  
  public void removePokemon(Pokemon p) {
    pokemons.removeIf(new Predicate<Pokemon>() {
      @Override
      public boolean test(Pokemon arg0) {
        return arg0.equals(p);
      }
    });
  }
  
  public boolean hasPokemonAlive() {
    for(Pokemon p : pokemons) {
      if(p.getCurrentHP() > 0) return true;
    }
    
    return false;
  }
  
  private void swapActivePokemon(Pokemon newActive) {
    for(int i = 0; i < this.pokemons.size(); i++) {
      if(this.pokemons.get(i).equals(newActive)) {
        this.activePokemonIndex = i;
        break;
      }
    }
  }
}
