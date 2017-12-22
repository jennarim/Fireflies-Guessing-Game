import processing.core.PApplet;
/**
 * Fly is the class that defines the fly that jar.pears
 * in the game. It is a circle that moves in random motion. 
 */
public class Fly {
	private float x;
	private float y;
	private int radius = 5;
	protected float noiseNum = 0; // Used to calculate the random movement of the fly
	private Jar jar;
	
	/* Constructor that takes in a jar and the number used for noise() */
	public Fly(Jar jar, float noiseNum) {
		this.jar = jar;
		this.noiseNum = noiseNum;
	}
	
	/* Moves the fly */
	public void move() {	
		/* x and y coor of a fly is contained within the jar */
		x = jar.jarX + jar.p.noise(noiseNum) * jar.jarWidth;
		y = jar.jarY + jar.p.noise(noiseNum + 100) * jar.jarHeight;
		
		/* Draws the fly */
		jar.p.fill(255, 255, 255);
		jar.p.strokeWeight(1);
		jar.p.ellipse(x, y, radius, radius);
		
		noiseNum += 0.005; // Value that moves the fly
		
		/* If the x and y coor go out of bounds, the fly should go in opposite direction */
		if ((x+radius) >= (jar.jarX + jar.jarWidth) || (x-radius) <= jar.jarX)
			x *= -1;
		if ((y+radius) >= (jar.jarY + jar.jarHeight) || (y-radius) <= jar.jarY)
			y *= -1;
	}
	
	/* Returns the jar that the fly uses */
	public Jar getJar() {
		return jar;
	}
	
	/* Makes the fly glow */
	public void glow() {
		jar.p.stroke(jar.p.color(179, 255, 0), 50);
		jar.p.strokeWeight(4);
		jar.p.ellipse(x, y, radius, radius);
		
		jar.p.stroke(jar.p.color(179, 255, 0), 70);
		jar.p.strokeWeight(9);
		jar.p.ellipse(x, y, radius, radius);		
	}
}
