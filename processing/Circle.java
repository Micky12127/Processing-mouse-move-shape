package processing;

import processing.core.PApplet;

public class Circle extends OperateShape {
	// �??半�?
	float diameter;
	// マウスが�?�?��入って�?��かを判定するため�?変数(半�??�??中�??XとY、�?ウスから�??中�?��での距離)
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
