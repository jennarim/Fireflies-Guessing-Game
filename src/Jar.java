import processing.core.PApplet;
/** 
 * Jar is the class that defines the rectangle that holds 
 * the flies. Jar is a rectangle, so it has a specified
 *  x-coor, y-coor, width, and height.
 */
public class Jar {
	protected float jarX;
	protected float jarY;
	protected float jarWidth;
	protected float jarHeight;
	
	PApplet p;
	
	/* Constructor that takes in PApplet */
	public Jar (PApplet p) {
		this.p = p;
		jarX = 250;
		jarY = 150;
		jarWidth = 180;
		jarHeight = 200;
	}
	
	/* Draws the rectangle */
	public void appear() {
		p.stroke(255,255,255);
		p.strokeWeight(2);
		p.fill(13, 5, 112, 0);
		p.rect(jarX, jarY, jarWidth, jarHeight, 7);
	}

	/* Getters and Setters */
	public float getJarX() {
		return jarX;
	}

	public void setJarX(float jarX) {
		this.jarX = jarX;
	}

	public float getJarY() {
		return jarY;
	}

	public void setJarY(float jarY) {
		this.jarY = jarY;
	}

	public float getJarWidth() {
		return jarWidth;
	}

	public void setJarWidth(float jarWidth) {
		this.jarWidth = jarWidth;
	}

	public float getJarHeight() {
		return jarHeight;
	}

	public void setJarHeight(float jarHeight) {
		this.jarHeight = jarHeight;
	}
}
