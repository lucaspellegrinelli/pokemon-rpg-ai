package model.types;

import model.pokemon.Pokemon;

public class TypeInteractions {
  public static final int NO_EFFECT = 0;
  public static final int NOT_EFFECTIVE = 1;
  public static final int NORMAL = 2;
  public static final int SUPER_EFFECTIVE = 2;
  
  public static boolean canLearnTypeMove(Pokemon pokemon, Type move) {    
    if(pokemon.getType() == Type.NORMAL) {
      return pokemon.getMoveSet().countMovesOfType(Type.NORMAL) == pokemon.getMoveSet().getNumberOfTMs();
    }
    
    if(pokemon.getType() == Type.STEEL) {
      return move == Type.STEEL || move== Type.FIGHTING || move== Type.ROCK || move== Type.GROUND;
    }
    
    if(pokemon.getType() == Type.FIGHTING) {
      return move == Type.FIGHTING || move== Type.ROCK;
    }
    
    if(pokemon.getType() == Type.GROUND) {
      return move == Type.GROUND || move== Type.FIGHTING;
    }
    
    if(pokemon.getType() == Type.ROCK) {
      return move == Type.ROCK || move== Type.GROUND;
    }
    
    if(pokemon.getType() == Type.DRAGON) {
      return move == Type.DRAGON || move == Type.ICE || move == Type.WATER || move == Type.FIRE || move == Type.ELETRIC;
    }
    
    if(pokemon.getType() == Type.ICE) {
      return move == Type.ICE || move == Type.WATER;
    }
    
    if(pokemon.getType() == Type.WATER) {
      return move == Type.WATER;
    }
    
    if(pokemon.getType() == Type.FIRE) {
      return move == Type.FIRE;
    }
    
    if(pokemon.getType() == Type.ELETRIC) {
      return move == Type.ELETRIC;
    }
    
    if(pokemon.getType() == Type.FLYING) {
      return move == Type.FLYING;
    }
    
    if(pokemon.getType() == Type.GRASS || pokemon.getType() == Type.BUG || pokemon.getType() == Type.POISON) {
      return move == Type.GRASS || move == Type.BUG || move == Type.POISON;
    }
    
    if(pokemon.getType() == Type.DARK) {
      return move == Type.DARK;
    }
    
    if(pokemon.getType() == Type.GHOST) {
      return move == Type.GHOST || move == Type.DARK || move == Type.PSYCHIC;
    }
    
    if(pokemon.getType() == Type.PSYCHIC) {
      return move == Type.PSYCHIC || move == Type.GHOST || move == Type.FAIRY;
    }
    
    if(pokemon.getType() == Type.FAIRY) {
      return move == Type.FAIRY;
    }
    
    return false;
  }
  
  public static int attackEffectiveness(Type attacking, Type defending){
    if(attacking == Type.NORMAL){
      if(defending == Type.GHOST) return TypeInteractions.NO_EFFECT;

      if(defending == Type.ROCK) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.STEEL) return TypeInteractions.NOT_EFFECTIVE;
    }

    if(attacking == Type.FIRE){
      if(defending == Type.FIRE) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.WATER) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.ROCK) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.DRAGON) return TypeInteractions.NOT_EFFECTIVE;

      if(defending == Type.GRASS) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.ICE) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.BUG) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.STEEL) return TypeInteractions.SUPER_EFFECTIVE;
    }

    if(attacking == Type.WATER){
      if(defending == Type.WATER) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.GRASS) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.DRAGON) return TypeInteractions.NOT_EFFECTIVE;

      if(defending == Type.FIRE) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.GROUND) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.ROCK) return TypeInteractions.SUPER_EFFECTIVE;
    }

    if(attacking == Type.ELETRIC){
      if(defending == Type.GROUND) return TypeInteractions.NO_EFFECT;

      if(defending == Type.ELETRIC) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.GRASS) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.DRAGON) return TypeInteractions.NOT_EFFECTIVE;

      if(defending == Type.WATER) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.FLYING) return TypeInteractions.SUPER_EFFECTIVE;
    }

    if(attacking == Type.GRASS){
      if(defending == Type.FIRE) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.GRASS) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.POISON) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.FLYING) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.BUG) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.DRAGON) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.STEEL) return TypeInteractions.NOT_EFFECTIVE;

      if(defending == Type.WATER) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.GROUND) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.ROCK) return TypeInteractions.SUPER_EFFECTIVE;
    }

    if(attacking == Type.ICE){
      if(defending == Type.FIRE) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.WATER) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.ICE) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.STEEL) return TypeInteractions.NOT_EFFECTIVE;

      if(defending == Type.GRASS) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.GROUND) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.FLYING) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.DRAGON) return TypeInteractions.SUPER_EFFECTIVE;
    }

    if(attacking == Type.FIGHTING){
      if(defending == Type.GHOST) return TypeInteractions.NO_EFFECT;

      if(defending == Type.POISON) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.FLYING) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.PSYCHIC) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.BUG) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.FAIRY) return TypeInteractions.NOT_EFFECTIVE;

      if(defending == Type.FIRE) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.ICE) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.ROCK) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.DARK) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.STEEL) return TypeInteractions.SUPER_EFFECTIVE;
    }

    if(attacking == Type.POISON){
      if(defending == Type.STEEL) return TypeInteractions.NO_EFFECT;

      if(defending == Type.POISON) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.GROUND) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.ROCK) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.GHOST) return TypeInteractions.NOT_EFFECTIVE;

      if(defending == Type.GRASS) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.FAIRY) return TypeInteractions.SUPER_EFFECTIVE;
    }

    if(attacking == Type.GROUND){
      if(defending == Type.FLYING) return TypeInteractions.NO_EFFECT;

      if(defending == Type.GRASS) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.BUG) return TypeInteractions.NOT_EFFECTIVE;

      if(defending == Type.FIRE) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.ELETRIC) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.POISON) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.ROCK) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.STEEL) return TypeInteractions.SUPER_EFFECTIVE;
    }

    if(attacking == Type.FLYING){
      if(defending == Type.ELETRIC) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.ROCK) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.STEEL) return TypeInteractions.NOT_EFFECTIVE;

      if(defending == Type.GRASS) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.FIGHTING) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.BUG) return TypeInteractions.SUPER_EFFECTIVE;
    }

    if(attacking == Type.PSYCHIC){
      if(defending == Type.DARK) return TypeInteractions.NO_EFFECT;

      if(defending == Type.PSYCHIC) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.STEEL) return TypeInteractions.NOT_EFFECTIVE;

      if(defending == Type.FIGHTING) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.POISON) return TypeInteractions.SUPER_EFFECTIVE;
    }

    if(attacking == Type.BUG){
      if(defending == Type.FIRE) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.FIGHTING) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.POISON) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.FLYING) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.GHOST) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.STEEL) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.FAIRY) return TypeInteractions.NOT_EFFECTIVE;

      if(defending == Type.GRASS) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.PSYCHIC) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.DARK) return TypeInteractions.SUPER_EFFECTIVE;
    }

    if(attacking == Type.ROCK){
      if(defending == Type.FIGHTING) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.GROUND) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.STEEL) return TypeInteractions.NOT_EFFECTIVE;

      if(defending == Type.FIRE) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.ICE) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.FLYING) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.BUG) return TypeInteractions.SUPER_EFFECTIVE;
    }

    if(attacking == Type.GHOST){
      if(defending == Type.NORMAL) return TypeInteractions.NO_EFFECT;

      if(defending == Type.DARK) return TypeInteractions.NOT_EFFECTIVE;

      if(defending == Type.PSYCHIC) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.GHOST) return TypeInteractions.SUPER_EFFECTIVE;
    }

    if(attacking == Type.DRAGON){
      if(defending == Type.FAIRY) return TypeInteractions.NO_EFFECT;

      if(defending == Type.STEEL) return TypeInteractions.NOT_EFFECTIVE;

      if(defending == Type.DRAGON) return TypeInteractions.SUPER_EFFECTIVE;
    }

    if(attacking == Type.DARK){
      if(defending == Type.FIGHTING) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.DARK) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.FAIRY) return TypeInteractions.NOT_EFFECTIVE;

      if(defending == Type.PSYCHIC) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.GHOST) return TypeInteractions.SUPER_EFFECTIVE;
    }

    if(attacking == Type.STEEL){
      if(defending == Type.FIRE) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.WATER) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.ELETRIC) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.STEEL) return TypeInteractions.NOT_EFFECTIVE;

      if(defending == Type.ICE) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.ROCK) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.FAIRY) return TypeInteractions.SUPER_EFFECTIVE;
    }

    if(attacking == Type.FAIRY){
      if(defending == Type.FIRE) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.POISON) return TypeInteractions.NOT_EFFECTIVE;
      if(defending == Type.STEEL) return TypeInteractions.NOT_EFFECTIVE;

      if(defending == Type.FIGHTING) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.DRAGON) return TypeInteractions.SUPER_EFFECTIVE;
      if(defending == Type.DARK) return TypeInteractions.SUPER_EFFECTIVE;
    }

    return TypeInteractions.NORMAL;
  }
}
