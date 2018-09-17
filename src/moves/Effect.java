package moves;

import pokemon.*;

public interface Effect {
  void applyEffect(Pokemon attacking, Pokemon defending);
}
