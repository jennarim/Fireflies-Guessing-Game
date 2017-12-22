import processing.core.PApplet;
/**
 * Button is the class that defines the choices displayed in the game.
 * Button is a rectangle with a specified x-coor, y-coor, width, height,
 * answer, and choice.
 */
public class Button {
	private float rectX;
	private float rectY;
	private float rectWidth = 100;
	private float rectHeight = 50;
	private int answer; // The correct answer
	private int choice; // The choice that the button represents
	
	private Jar jar;
	
	boolean userCorrect;
	
	/* Constructor that takes jar, x-coor, y-coor, width, height, answer, and choice. */
	public Button(Jar jar, float rectX, float rectY, int answer, int choice) {
		this.jar = jar;
		this.rectX = rectX;
		this.rectY = rectY;
		this.answer = answer;
		this.choice = choice;
	}
	
	/* Draws the button */
	public void drawButton() {
		/* Displays the button rectangle */
		jar.p.stroke(255,255,255,80);
		jar.p.strokeWeight(2);
		jar.p.fill(56,44,90);
		jar.p.rect(rectX, rectY, rectWidth, rectHeight);

		/* Displays the choice in the rectangle */
		jar.p.fill(255,255,255);
		jar.p.textAlign(jar.p.CENTER);
		jar.p.text(choice, rectX + (rectWidth/2), rectY + 10 + (rectHeight/2));
	}
	
	/* Method that returns whether the user is hovering over the button */
	public boolean overRect() {
		if ( ((jar.p.mouseX <= (rectX + rectWidth)) && (jar.p.mouseX >= rectX)) && ((jar.p.mouseY <= (rectY + rectHeight)) && (jar.p.mouseY >= rectY)) ) {
			return true;
		}
		return false;
	}
	
	/* Returns the correct answer */
	public int getAnswer() {
		return answer;
	}
	
	/* Returns the choice the button represents */
	public int getChoice() {
		return choice;
	}
	
}
