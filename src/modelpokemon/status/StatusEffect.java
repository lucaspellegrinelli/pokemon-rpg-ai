package modelpokemon.status;

import model.pokemon.Pokemon;

public interface StatusEffect {
  void applyStatus(Pokemon pokemon);
}
