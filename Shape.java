package processing.Mouse;

import processing.core.PApplet;

public abstract class Shape implements Displayable {
	protected float x, y;
	// Javaにはcolor型が存在しないので、int a = color(255, 255, 255);のように記述する
	private int shapeColor, clickedShapeFlag;
	protected PApplet papplet;
	
	public Shape(PApplet papplet) {
		this.papplet = papplet;
	}
	public float getX() {
		return x;
	}
	public void setX(float xValue) {
		x = xValue;
	}
	
	public float getY() {
		return y;
	}
	public void setY(float yValue) {
		y = yValue;
	}
	
	public void setColor(int colorValue) {
		shapeColor = colorValue;
	}
	public int getColor() {
		return shapeColor;
	}
	
	// 図形がクリックされたことを確認するためのフラグ(0ならクリックされていない、1ならクリックされている)
	public void setClickedShapeFlag(int clickedShapeFlagValue) {
		clickedShapeFlag = clickedShapeFlagValue;
	}
	public int getClickedShapeFlag() {
		return clickedShapeFlag;
	}
}