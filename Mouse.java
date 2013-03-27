package processing.Mouse;

import java.util.ArrayList;
import processing.core.*;

public class Mouse extends PApplet {
	
	private ArrayList<MoveShape> shapes = new ArrayList<MoveShape>();
	
	// フレームレートをカウントするカウンター
	private int counter = 0;
	// マウスが移動した間のフレームレート数
	private int moveMouseFps;
	// マウスが押されたときのX座標, Y座標
	private float mousePressedX, mousePressedY;
	// マウスが離れたときのX座標, Y座標
	private float mouseReleasedX, mouseReleasedY;
	// マウスが押されたときの点と離れたときの点を結んだ線のなす角
	private float mouseAngle;
	// マウスが移動した距離
	private float mouseDistance;
	
	public void setup() {
		size(1200, 700);
		smooth();
	}
	public void draw() {
		clearShape();
		
		if (!shapes.isEmpty()) {
			if (!mousePressed) {
				MoveShape moveShape = shapes.get(0);
				moveShape.move();
			} else {
				MoveShape moveShape = shapes.get(0);
				moveShape.display();
			}
		}
		
		if (mousePressed) {
			counter++;
		}
	}
	
	public void clearShape() {
		stroke(255, 255, 255);
		fill(255, 255, 255);
		rect(0, 0, width, height);
	}
	
	public void mouseDragged() {
		if (!shapes.isEmpty()) {
			MoveShape moveShape = shapes.get(0);
			moveShape.setX(mouseX);
			moveShape.setY(mouseY);
		}
	}
	
	public void mousePressed() {
		mousePressedX = mouseX;
		mousePressedY = mouseY;
		if (shapes.isEmpty()) {
			MoveShape moveShape = null;
			float randomShape = random(0, 99);
			int randomShapeNum = (int) randomShape;
			if (randomShapeNum % 2 == 0) {
				moveShape = new Circle(this, random(1, 100));
			} else if (randomShapeNum % 2 == 1) {
				moveShape = new Rectangle(this, random(1, 100), random(1, 100));
			}
			moveShape.setX(mouseX);
			moveShape.setY(mouseY);
			moveShape.setColor(color(random(0, 255), random(0, 255), random(0, 255)));
			shapes.add(moveShape);
		} else {
			MoveShape moveShape = shapes.get(0);
			moveShape.setX(mouseX);
			moveShape.setY(mouseY);
			moveShape.setColor(color(random(0, 255), random(0, 255), random(0, 255)));
		}
	}
	
	public void mouseReleased() {
		MoveShape moveShape = shapes.get(0);
		
		moveMouseFps = counter;
		mouseReleasedX = mouseX;
		mouseReleasedY = mouseY;
		mouseDistance = dist(mousePressedX, mousePressedY, mouseReleasedX, mouseReleasedY);
		mouseAngle = degrees(atan((mousePressedY - mouseReleasedY) / (mousePressedX - mouseReleasedX)));
		
		if ((mousePressedX - mouseReleasedX) >= 0 && (mousePressedY - mouseReleasedY) <= 0) {
			mouseAngle = 180 + mouseAngle;
		} else if ((mousePressedX - mouseReleasedX) >= 0 && (mousePressedY - mouseReleasedY) >= 0) {
			mouseAngle = mouseAngle - 180;
		}
		
		moveShape.setSpeed(mouseDistance / moveMouseFps);
		moveShape.setAngle(mouseAngle);
		
		counter = 0;
	}
}