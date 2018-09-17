package moves;

import java.util.ArrayList;
import java.util.List;

import types.*;

public class Move {
	public static final int PHYSICAL_ATTACK = 0;
	public static final int SPECIAL_ATTACK = 1;
	
	private String name;
	
	private int damage;
  private int cooldown;
  private int accuracy;
  
  private int contact_type;
  private Type type;
  private boolean priority;
  private AcquireRestriction acqRestriction;
  private List<Effect> effects = new ArrayList<>(); // Special effects like paralizing etc
  private List<Modifiers> modifiers = new ArrayList<>(); // +1s -1s ...
  
  public Move(String name, int dmg, int cd, int acc, int ctyp, Type type, boolean priority, AcquireRestriction acqRestriction) {
  	this.name = name.toLowerCase();
  	this.damage = dmg;
  	this.cooldown = cd;
  	this.accuracy = acc;
  	this.contact_type = ctyp;
  	this.type = type;
  	this.priority = priority;
  	this.acqRestriction = acqRestriction;
  }
  
  public Move addEffect(Effect effect) {
  	this.effects.add(effect);
  	return this;
  }
  
  public void addModifier(Modifiers m) {
  	this.modifiers.add(m);
  }
  
  public Type getType() {
  	return this.type;
  }
}
