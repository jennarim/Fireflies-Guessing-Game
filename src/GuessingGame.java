import processing.core.PApplet;
import processing.core.PImage;
/**
 * This game generates a random number of flies (ranging from 5 to 8), 
 * and the player must guess how many flies are in the jar by 
 * clicking the correct button. If the player chooses the correct
 * answer, he or she has the option to play again by pressing 'r'. 
 * If the player chooses an incorrect answer, he or she will also 
 * have the option to play again.
 */
public class GuessingGame extends PApplet {

	int numOfFlies = (int) random(5,9); // Random number of flies
	Jar jar = new Jar(this); // Creates jar
	Fly[] flies = new Fly[numOfFlies]; // Array of flies
	Button[] buttons = new Button[4]; // Array of buttons
	boolean game = true; // Game is running
	PImage background;
		
	public void setup() {
		size(700,500);
		
		background = loadImage("background.jpg");
		
		/* Instantiates the flies */
		for (int i = 0; i < flies.length; i++) {
			float randomNoiseNum = random(0, 20);
			flies[i] = new Fly(jar, randomNoiseNum);			
		}
		
		/* Instantiates the buttons */
		int padding = 50;
		int spaceBW = 30;
		int buttonWidth = (width - (2 * padding) - (3 * spaceBW)) / 4;
		int buttonX = 60;
		for (int i = 0; i < 4; i++) {
			buttons[i] = new Button(jar, buttonX, 425, numOfFlies, i+5);
			buttonX += buttonWidth + spaceBW;
		}
	}
	
	public void draw() {
		if (game) {
			background(background);

			/* Displays the question */
			textSize(32);
			fill(255, 255, 255);
			textAlign(CENTER);
			text("How many flies are in the jar?", 350, 80);

			/* Displays the jar */
			flies[0].getJar().appear();

			/* Draws and moves the flies */
			for (int i = 0; i < flies.length; i++) {
				flies[i].move();
			}
			
			/* Creates the glow effect for each fly */
			for (int j = 0; j < flies.length; j++) {
				flies[j].glow();
			}

			/* Draws the buttons */
			for (int k = 0; k < buttons.length; k++) {
				buttons[k].drawButton();
			}
		}
	}
	
	/* If the mouse is clicked, this displays the 'correct' 'incorrect' screens
	 * depending on whether the player answers correctly or not.
	 * (non-Javadoc)
	 * @see processing.core.PApplet#mouseClicked()
	 */
	public void mouseClicked() {
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i].overRect()) { // If user is hovering over button
				if (buttons[i].getAnswer() == buttons[i].getChoice()) { // If correct, display 'correct'
					buttons[i].userCorrect = true;
					displayCorrect();
				} else if (!buttons[i].userCorrect) // If incorrect, display 'incorrect'
					displayIncorrect();
				game = false; // The game is over
			}
		}
	}
	
	/* If the player presses 'r', restart the game.
	 * (non-Javadoc)
	 * @see processing.core.PApplet#keyPressed()
	 */
	public void keyPressed() {
		if (keyPressed)
			if (key == 'r' || key == 'R')
				restart();
	}
	
	/* Method that restarts the game */
	public void restart() {
		numOfFlies = (int) random(5,9); // Random number of flies
		flies = new Fly[numOfFlies]; // Array of flies
		/* Instantiates the flies again */
		for (int i = 0; i < flies.length; i++) {
			float randomNoiseNum = random(0, 20);
			flies[i] = new Fly(jar, randomNoiseNum);			
		}
		buttons = new Button[4];
		/* Instantiates the buttons again */
		int padding = 50;
		int spaceBW = 30;
		int buttonWidth = (width - (2 * padding) - (3 * spaceBW)) / 4;
		int buttonX = 60;
		for (int i = 0; i < 4; i++) {
			buttons[i] = new Button(jar, buttonX, 425, numOfFlies, i+5);
			buttonX += buttonWidth + spaceBW;
		}
		game = true;
	}
	
	/* Method that displays the 'correct' screen */
	public void displayCorrect() {
		background(background);
		fill(255,255,255);
		textAlign(CENTER);
		text("Correct! Press 'r' to play again.", 350, 250);
	}
	/* Method that displays the 'incorrect' screen */
	public void displayIncorrect() {
		background(background);
		fill(255,255,255);
		textAlign(CENTER);
		text("Incorrect. Press 'r' to play again.", 350, 250);
	}
}
