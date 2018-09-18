package model.moves;

import model.pokemon.Pokemon;

public interface AcquireRestriction {
  boolean canAcquire(Pokemon p);
}
