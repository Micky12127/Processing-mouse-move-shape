package processing.Mouse;

import processing.core.PApplet;

public abstract class MoveShape extends Shape implements Movable {
	private float speed, angle, friction;
	public final double FRICTION = 0.99;
	
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
		x += papplet.cos(papplet.radians(angle)) * speed;
		y += papplet.sin(papplet.radians(angle)) * speed;
	}
	
	public void move() {
		calcSpeed();
		
		float widthFromCenter = getWidthFromCenter();
		float heightFromCenter = getHeightFromCenter();
		float centerPointX = getCenterPointX();
		float centerPointY = getCenterPointY();
		
		if (centerPointX >= papplet.width - widthFromCenter) {
			setColor(papplet.color(papplet.random(0, 255), papplet.random(0, 255), papplet.random(0, 255)));
			setCenterPointX(papplet.width - widthFromCenter);
			angle = 180 - angle;
		} else if(centerPointX <= widthFromCenter) {
			setColor(papplet.color(papplet.random(0, 255), papplet.random(0, 255), papplet.random(0, 255)));
			setCenterPointX(widthFromCenter);
			angle = 180 - angle;
		} else if(centerPointY >= papplet.height - heightFromCenter) {
			setColor(papplet.color(papplet.random(0, 255), papplet.random(0, 255), papplet.random(0, 255)));
			setCenterPointY(papplet.height - heightFromCenter);
			angle = -angle;
		} else if(centerPointY <= heightFromCenter) {
			setColor(papplet.color(papplet.random(0, 255), papplet.random(0, 255), papplet.random(0, 255)));
			setCenterPointY(heightFromCenter);
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