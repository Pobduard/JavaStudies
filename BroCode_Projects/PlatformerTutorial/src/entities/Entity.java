package entities;

public abstract class Entity {
	protected float x,y;		//& Asi tanto esta clase como sus hijos lo van a poseer, no solo esta Abstracta como pasa con "Private"
	protected int width, height;
	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}
