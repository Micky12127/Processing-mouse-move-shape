package processing.Mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import processing.core.PApplet;

public abstract class OperateShape extends MoveShape implements MouseMotionListener, MouseListener {
	public OperateShape(PApplet papplet) {
		super(papplet);
		papplet.addMouseListener(this);
		papplet.addMouseMotionListener(this);
		papplet.draw();
	}
	
	// フレームレートをカウントする
	private int fpsCounter = 0;
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
	
	// -------------PApplet MouseListener----------------
	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		mousePressedX = e.getX();
		mousePressedY = e.getY();
		fpsCounter++;
		float radius = this.getWidthFromCenter();
		float shapeCenterX = this.getCenterPointX();
		float shapeCenterY = this.getCenterPointY();
		float mouseAndShapeDistance = PApplet.dist(papplet.mouseX, papplet.mouseY, shapeCenterX, shapeCenterY);
		
		if (mouseAndShapeDistance < radius) {
			this.setX(e.getX());
			this.setY(e.getY());
		}
	}

	public void mouseReleased(MouseEvent e) {
		fpsCounter++;
		float radius = this.getWidthFromCenter();
		float shapeCenterX = this.getCenterPointX();
		float shapeCenterY = this.getCenterPointY();
		float mouseAndShapeDistance = PApplet.dist(papplet.mouseX, papplet.mouseY, shapeCenterX, shapeCenterY);
		
		if (mouseAndShapeDistance < radius) {
			mouseReleasedX = e.getX();
			mouseReleasedY = e.getY();
			moveMouseFps = fpsCounter;
			mouseDistance = PApplet.dist(mousePressedX, mousePressedY, mouseReleasedX, mouseReleasedY);
			mouseAngle = PApplet.degrees(PApplet.atan((mousePressedY - mouseReleasedY) / (mousePressedX - mouseReleasedX)));

			if ((mousePressedX - mouseReleasedX) >= 0 && (mousePressedY - mouseReleasedY) <= 0) {
				mouseAngle += 180;
			} else if ((mousePressedX - mouseReleasedX) >= 0 && (mousePressedY - mouseReleasedY) >= 0) {
				mouseAngle -= 180;
			}

			this.setSpeed(mouseDistance / moveMouseFps);
			this.setAngle(mouseAngle);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}
	
	public void mouseExited(MouseEvent e) {
	}
	// ---------------------------------------------------
	
	// ---------- PApplet MouseMotionListener -------
	public void mouseDragged(MouseEvent e) {
		fpsCounter++;
		float radius = this.getWidthFromCenter();
		float shapeCenterX = this.getCenterPointX();
		float shapeCenterY = this.getCenterPointY();
		float mouseAndShapeDistance = PApplet.dist(papplet.mouseX, papplet.mouseY, shapeCenterX, shapeCenterY);
		
		if (mouseAndShapeDistance < radius) {
			this.setX(e.getX());
			this.setY(e.getY());
		}
	}

	public void mouseMoved(MouseEvent e) {
	}
	// ---------------------------------------------------
}