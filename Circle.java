package processing.Mouse;

import processing.core.PApplet;

public class Circle extends OperateShape {
	// 円の半径
	float diameter;
	// マウスが円内に入っているかを判定するための変数(半径、円の中心のXとY、マウスから円の中心までの距離)
	private float radius, circleCenterX, circleCenterY, mouseAndCircleDistance;
	
	Circle(PApplet papplet, float _diameter) {
		super(papplet);
		diameter = _diameter;
	}
	
	public float getWidthFromCenter() {
		return diameter / 2;
	}
	
	public float getHeightFromCenter() {
		return getWidthFromCenter();
	}
	
	public float getCenterPointX() {
		return getX();
	}
	public void setCenterPointX(float xValue) {
		setX(xValue);
	}
	
	public float getCenterPointY() {
		return getY();
	}
	public void setCenterPointY(float yValue) {
		setY(yValue);
	}
	
	public boolean getMouseInShape() {
		radius = getWidthFromCenter();
		circleCenterX = getCenterPointX();
		circleCenterY = getCenterPointY();
		mouseAndCircleDistance = PApplet.dist(papplet.mouseX, papplet.mouseY, circleCenterX, circleCenterY);
		
		if (mouseAndCircleDistance < radius) {
			return true;
		} else {
			return false;
		}
	}
	
	public void display() {
		papplet.fill(getColor());
		papplet.ellipse(getX(), getY(), diameter, diameter);
	}
}
