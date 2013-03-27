package processing.Mouse;

import processing.core.PApplet;

public class Circle extends OperateShape {
	// 円の半径
	float diameter;
	
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
	
	public void display() {
		papplet.fill(getColor());
		papplet.ellipse(getX(), getY(), diameter, diameter);
	}
}
