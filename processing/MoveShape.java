package processing;

import processing.core.PApplet;

public abstract class MoveShape extends Shape implements Movable {
	private float speed, angle;
	public final double FRICTION = 0.997;
	
	public MoveShape(PApplet papplet) {
		super(papplet);
	}
	
	public void setSpeed(float speedValue) {
		speed = speedValue;
	}
	public float getSpeed() {
		return speed;
	}
	
	public void setAngle(float angleValue) {
		angle = angleValue;
	}
	public float getAngle() {
		return angle;
	}
	
	public void calcSpeed() {
		if (speed != 0) {
			speed *= FRICTION;
		}
		x += PApplet.cos(PApplet.radians(angle)) * speed;
		y += PApplet.sin(PApplet.radians(angle)) * speed;
	}
	
	public void move() {
		calcSpeed();
		
		float widthFromCenter = getWidthFromCenter();
		float heightFromCenter = getHeightFromCenter();
		
		if (getX() >= papplet.width - widthFromCenter) {
			setColor(papplet.color(papplet.random(0, 255), papplet.random(0, 255), papplet.random(0, 255)));
			setX(papplet.width - widthFromCenter);
			angle = 180 - angle;
		} else if(getX() <= widthFromCenter) {
			setColor(papplet.color(papplet.random(0, 255), papplet.random(0, 255), papplet.random(0, 255)));
			setX(widthFromCenter);
			angle = 180 - angle;
		} else if(getY() >= papplet.height - heightFromCenter) {
			setColor(papplet.color(papplet.random(0, 255), papplet.random(0, 255), papplet.random(0, 255)));
			setY(papplet.height - heightFromCenter);
			angle = -angle;
		} else if(getY() <= heightFromCenter) {
			setColor(papplet.color(papplet.random(0, 255), papplet.random(0, 255), papplet.random(0, 255)));
			setY(heightFromCenter);
			angle = -angle;
		}
		
		display();
	}

	public abstract float getWidthFromCenter();
	public abstract float getHeightFromCenter();
	public abstract float getCenterPointX();
	public abstract void setCenterPointX(float xValue);
	public abstract float getCenterPointY();
	public abstract void setCenterPointY(float yValue);
}