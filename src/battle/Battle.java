package battle;

import model.field.Battlefield;
import model.pokemon.Pokemon;
import model.pokemon.PokemonTeam;
import rpg.Dice;

public class Battle {
  private PokemonTeam teamA;
  private PokemonTeam teamB;
  
  private Battlefield battlefield;
  
  public Battle(PokemonTeam t1, PokemonTeam t2) {
    this.battlefield = new Battlefield();
    
    this.teamA = t1;
    this.teamB = t2;
  }
  
  public void startBattle() {
    //  1 -> Team A turn
    // -1 -> Team B turn
    //  0 -> Colisão
    int turnTeam = doesTeamAStart(teamA.getActivePokemon(), teamB.getActivePokemon());
    
    if(turnTeam == 0) {
      // Colisão
    }
    
    while(teamA.hasPokemonAlive() && teamB.hasPokemonAlive()) {
      // Aplicar efeitos/modificadores nos pokemons (efeitos de campo, queimadura, paralisia...)
      // Remover cooldowns do time do turno
      // Time do turno decide se quer dar switch (se der, pode acontecer ataque em resposta)
      // Time do turno decide se é força total ou não (se puder usar)
      // Outro time decide se quer dar Switch (rolagem de Switch vs rolagem do ataque para ver se da certo)
      // Outro time decide se é evasiva ou não (se puder usar)
      // Aplicar efeitos/modificadores nos ataques (+1 contra tipos fracos, -1 por efeitos dos tms...)
      // Aplicar dano
      // Aplicar efeitos de contato (chance de paralisar ao contato, ...)
      // Limpar modificadores
      // Forçar switch caso algum pokemon morreu
      turnTeam = -turnTeam;
    }
    
    if(teamA.hasPokemonAlive()) {
      // Team A won
    }else {
      // Team B won
    }
  }
  
  private int doesTeamAStart(Pokemon a, Pokemon b) {
    if(a.getBaseSpeed() > b.getBaseSpeed()) return 1;
    if(a.getBaseSpeed() < b.getBaseSpeed()) return -1;
    return 0;
  }
}
