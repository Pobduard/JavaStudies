package entities;

public abstract class Entity {
	protected float x,y;		//& Asi tanto esta clase como sus hijos lo van a poseer, no solo esta Abstracta como pasa con "Private"

	public Entity(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
}
