import java.awt.Font;
import java.util.Scanner;
import edu.princeton.cs.introcs.StdDraw;

public class Menu {
	public final static int X_MAX = 16;
	public final static int Y_MAX = 30;
	public final static float WIDTH = 0.3f;

	public void Jouer() throws InterruptedException {
		StdDraw.setXscale(-WIDTH, X_MAX + WIDTH);
		StdDraw.setYscale(WIDTH, Y_MAX + WIDTH);
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);

		BIGGAME game = new BIGGAME();
		boolean rejouer = true;

		Menu menu = new Menu();
		game.Interface = new interfaceGraphique();
		while (rejouer) {
			boolean continuation = true;
			boolean retour = true;
			StdDraw.clear();
			StdDraw.picture(10, 10, "ocean2.JPG", 35, 55);
			double i = 0;

			double degre = 0;

			while (degre < 360) {

				StdDraw.picture(10, 10, "ocean2.JPG", 35, 55);

				StdDraw.picture(X_MAX - 8, Y_MAX - 4, "snorkunking.png", i, i, degre);

				i = i + 0.1;
				degre = degre + 2;

			}
			StdDraw.picture(X_MAX - 8, Y_MAX - 4, "snorkunking.png", i, i, degre);
			StdDraw.picture(X_MAX - 8.5, Y_MAX - 17, "singleplayer.png");
			StdDraw.picture(X_MAX - 8.5, Y_MAX - 25, "multiplayer.png");
			while (continuation) {
				if (StdDraw.isMousePressed() && StdDraw.mouseY() < 18 && StdDraw.mouseY() > 11.5
						&& StdDraw.mouseX() > 1.5 && StdDraw.mouseX() < 13.25) {
					StdDraw.picture(10, 10, "ocean2.JPG", 35, 55);
					StdDraw.picture(X_MAX - 8.5, Y_MAX - 15, "Tas.png");
					StdDraw.picture(X_MAX - 8.5, Y_MAX - 10, "facile.png");
					StdDraw.picture(X_MAX - 8.5, Y_MAX - 20, "difficile.png");
					Thread.sleep(100);
					while (retour) {
						if (StdDraw.isMousePressed() && StdDraw.mouseY() < 24.4 && StdDraw.mouseY() > 18.75
								&& StdDraw.mouseX() > 4.6 && StdDraw.mouseX() < 10.2) {
							Players player2 = new IAfacile();
							Players player1 = new Humain();
							game.Interface.IA = true;
							game.player2 = player2;
							game.player1 = player1;
							game.bigGame();
							retour = false;
							continuation = false;
							Thread.sleep(200);
						}
						if (StdDraw.isMousePressed() && StdDraw.mouseY() < 14.55 && StdDraw.mouseY() > 8.57
								&& StdDraw.mouseX() > 3.7 && StdDraw.mouseX() < 11.25) {
							Players player2 = new IADifficile();
							game.Interface.IA = true;
							Players player1 = new Humain();
							game.player2 = player2;

							game.player1 = player1;
							game.bigGame();
							retour = false;
							continuation = false;
						}
					}
				}
				if (StdDraw.isMousePressed() && StdDraw.mouseY() < 10.2 && StdDraw.mouseY() > 3.85
						&& StdDraw.mouseX() > 2 && StdDraw.mouseX() < 12.90) {
					StdDraw.clear();
					Players player1 = new Humain();
					Players player2 = new Humain();
					game.Interface.IA = false;
					game.player2 = player2;
					game.player1 = player1;
					game.bigGame();
					continuation = false;
					retour = false;
				}
			}
			StdDraw.clear();
			StdDraw.picture(10, 10, "ocean2.JPG", 35, 55);
			StdDraw.picture(X_MAX - 8.5, Y_MAX - 15, "Tas.png");
			StdDraw.picture(X_MAX - 8.5, Y_MAX - 10, "rejouer.png");
			StdDraw.picture(X_MAX - 8.5, Y_MAX - 20, "quitter.png");
			boolean proposition = false;
			while (proposition == false) {
				if (StdDraw.isMousePressed() && StdDraw.mouseY() < 22.7 && StdDraw.mouseY() > 17.3
						&& StdDraw.mouseX() > 3.6 && StdDraw.mouseX() < 11.3) {
					proposition = true;
				}
				if (StdDraw.isMousePressed() && StdDraw.mouseY() < 13.15 && StdDraw.mouseY() > 7.3
						&& StdDraw.mouseX() > 4.2 && StdDraw.mouseX() < 10.8) {
					proposition = true;
					rejouer = false;
				}
				Thread.sleep(100);
			}
		}
		StdDraw.clear();
		StdDraw.picture(10, 10, "ocean2.JPG", 35, 55);
		StdDraw.text(X_MAX - 8.5, Y_MAX - 12, "FIN DU JEU");
	}

}
