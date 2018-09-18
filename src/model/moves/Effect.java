package model.moves;

import model.pokemon.*;

public interface Effect {
  void applyEffect(Pokemon attacking, Pokemon defending);
}
