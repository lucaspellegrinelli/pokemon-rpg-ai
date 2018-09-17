package moves;

import java.util.ArrayList;
import java.util.List;

import pokemon.Pokemon;
import types.Type;
import types.TypeInteractions;

public class TMList {
	List<Move> tms = new ArrayList<>();
	
	TMList(){
		initializeTMs();
	}
	
	private void initializeTMs() {
		tms.add(Fissure());
	}
	
	public List<Move> getAllTMs(){
		return this.tms;
	}
	
	public static Move Fissure() {
		Move fissure = new Move("fissure", 6, 4, -7, Move.PHYSICAL_ATTACK, Type.GROUND, false, new AcquireRestriction() {
			public boolean canAcquire(Pokemon p) {
				return TypeInteractions.canLearnTypeMove(p, Type.GROUND);
			}
		});
		
		fissure.addEffect(new Effect(){
			public void applyEffect(Pokemon attacking, Pokemon defending) {
				if(defending.getType() != Type.GROUND) {
					fissure.addModifier(Modifiers.damageModifier(-1, Modifiers.ONE_TURN_ONLY));
				}
			}
		});
		
		return fissure;
	}
}
