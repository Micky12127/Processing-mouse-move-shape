package processing.Mouse;

import java.util.ArrayList;
import processing.core.*;

public class Mouse extends PApplet {
	
	private ArrayList<OperateShape> shapes = new ArrayList<OperateShape>();
	
	// 図形の数
	private float randomShapesNum = random(2, 50);
	private int shapesNum = (int) randomShapesNum;
	
	public void setup() {
		size(1200, 700);
		smooth();
		frameRate(240);
		for (int i = 0; i < shapesNum; i++) {
			OperateShape os = new Circle(this, 50);
			os.setX(random(50, 1150));
			os.setY(random(50, 650));
			os.setColor(color(random(0, 255), random(0, 255), random(0, 255)));
			shapes.add(os);
		}
	}
	public void draw() {
		clearShape();
		
		for (OperateShape os : shapes) {
			if (os.getSpeed() > 0) {
				os.move();
			} else {
				os.display();
			}
		}
	}
	
	public void clearShape() {
		stroke(255, 255, 255);
		fill(255, 255, 255);
		rect(0, 0, width, height);
	}
	/*	
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
	*/
}