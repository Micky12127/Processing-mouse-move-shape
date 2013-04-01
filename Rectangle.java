package processing.Mouse;

import processing.core.PApplet;

public class Rectangle extends OperateShape {
	// 四角形の幅と高さ
	private float rectX, rectY;
	float rectWidth, rectHeight;
	
	private boolean isMouseXRectRange; // マウスのX座標が四角形のX座標から四角形の横幅の間に存在するのかをチェックする
	private boolean isMouseYRectRange; // マウスのY座標が四角形のY座標から四角形の横幅の間に存在するのかをチェックする
	
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
	
	public boolean getMouseInShape() {
		// マウスが四角形の内部に存在するかをチェックする
		isMouseXRectRange = papplet.mouseX >= getX() - getWidthFromCenter() && papplet.mouseX <= getX() + getWidthFromCenter();
		isMouseYRectRange = papplet.mouseY >= getY() - getHeightFromCenter() && papplet.mouseY <= getY() + getHeightFromCenter();
		if (isMouseXRectRange && isMouseYRectRange) {
			return true;
		} else {
			return false;
		}
	}
	
	public void display() {
		papplet.fill(getColor());
		rectX = getX() - getWidthFromCenter();
		rectY = getY() - getHeightFromCenter();
		papplet.rect(rectX, rectY, rectWidth, rectHeight);
	}
}