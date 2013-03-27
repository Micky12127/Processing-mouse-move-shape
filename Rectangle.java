package processing.Mouse;

import processing.core.PApplet;

public class Rectangle extends MoveShape {
	// 四角形の幅と高さ
	float rectWidth, rectHeight;
	
	Rectangle(PApplet papplet, float _rectWidth, float _rectHeight) {
		super(papplet);
		rectWidth = _rectWidth;
		rectHeight = _rectHeight;
	}
	
	public float getWidthFromCenter() {
		return rectWidth / 2;
	}
	
	public float getHeightFromCenter() {
		return rectHeight / 2;
	}
	
	public float getCenterPointX() {
		return getX() + getWidthFromCenter();
	}
	public void setCenterPointX(float xValue) {
		setX(xValue - getWidthFromCenter());
	}
	
	public float getCenterPointY() {
		return getY() + getHeightFromCenter();
	}
	public void setCenterPointY(float yValue) {
		setY(yValue - getHeightFromCenter());
	}
	
	public void display() {
		papplet.fill(getColor());
		papplet.rect(getX(), getY(), rectWidth, rectHeight);
	}
}