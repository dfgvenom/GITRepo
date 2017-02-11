package com.playground.invadersmustdie.ui.sprites;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.File;

import javax.swing.ImageIcon;

import com.playground.invadersmustdie.InvadersConst;

public abstract class Sprite extends Component implements InvadersConst {
	private static final long serialVersionUID = -3813149202245138522L;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	private Image image;
	private boolean visible;
	private int speed;
	private int direction;
	
	public Sprite(int x, int y, int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		visible = true;
	}
	
	protected void loadImage(String imageName) {
		File file = new File(imageName);
		if (file != null && file.exists()) {
			ImageIcon icon = new ImageIcon(imageName);
			image = icon.getImage();
			updateDimensions();
		} else {
			System.err.println("File (" + imageName + ") does not exist: " + getClass());
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		if (g instanceof Graphics2D) {
			Graphics2D graphics2d = (Graphics2D) g;
			if (getImage() != null) {
				AffineTransform xform = new AffineTransform();
				xform.rotate(getRotation());
				graphics2d.drawImage(getImage(), xform, null);
			} else {
				String message = "Sprite.paint(): " + getClass();
				System.err.println(message + " image null! ");
			}
		}
		
	}
	
	private double getRotation() {
		return 90 * direction;
	}

	protected void updateDimensions() {
			if (image != null) {
				width = image.getWidth(null);
				height = image.getHeight(null);
			}
	}
	
	public Image getImage() {
		return image;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSpeed() {
		return speed;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void adjustX(int adjustX) {
		int newX = getX() + (adjustX * getSpeed());
		
		if (DEBUG) {
			System.out.println("Sprite.adjustX() - " + getClass().getSimpleName() + " newXPos: " + newX);
		}
		
		setX(newX);
	}
	
	public void adjustY(int adjustY) {
		int newY = getY() + (adjustY * getSpeed());

		if (DEBUG) {
			System.out.println("Sprite.adjustY() - " + getClass().getSimpleName() + " newYPos: " + newY);
		}
		
		setY(newY);
	}
	
}
