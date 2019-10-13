import java.util.ArrayList;
import java.util.Collections;

import edu.princeton.cs.introcs.StdDraw;

public class interfaceGraphique {
	public final static int X_MAX = 16;
	public final static int Y_MAX = 35;
	public final static float WIDTH = 0.3f;
	public ArrayList<Levels> liste;
	public Players player1;
	public Players player2;
	public int oxygene;
	public int phase;
	public int surface;
	public int Indicateur;
	public int cave2 = 0;
	public int cave3 = 0;
	public boolean IA = false;
	public int cave1 = 0;

	public interfaceGraphique() {
		

		StdDraw.setXscale(-WIDTH, X_MAX + WIDTH);
		StdDraw.setYscale(WIDTH, Y_MAX + WIDTH);
	}

	public void begin() {
		this.cave3 = this.chercher();
		this.cave2 = this.chercher2() + cave3;
		this.cave1 = this.chercher3();

	}

	public void affichage() {
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);

		StdDraw.picture(10, 10, "ocean2.JPG", 35, 55);

		if (cave1 != 0) {
			StdDraw.text(X_MAX - 2, surface - 0.2, "Cave 1");
			StdDraw.line(1, cave2 + 0.5, 16, cave2 + 0.5);
		}
		if (cave2 - cave3 > 0) {
			StdDraw.text(X_MAX - 2, cave2 - 0.2, "Cave 2");
			StdDraw.line(1, cave3 + 0.5, 16, cave3 + 0.5);

		}
		if (cave1 != 0 && cave2 - cave3 > 0) {
			StdDraw.line(1, cave3 + 0.5, 16, cave3 + 0.5);
		}

		StdDraw.text(X_MAX - 2, cave3 - 0.2, "Cave 3");

		for (Levels level : liste) {

			StdDraw.picture(1, level.numeroNiveau, "Image1.png", 1, 1);
		}

		StdDraw.picture(4, player1.locaJoueur, "Image2.png", 2, 2);

		StdDraw.picture(6.5, player2.locaJoueur, "Image2.png", 2, 2);
		StdDraw.text(4, player1.locaJoueur + 1.5, "Joueur1");

		if (IA == true) {
			StdDraw.text(6.5, player2.locaJoueur + 1.5, "IA");

		} else {
			StdDraw.text(6.5, player2.locaJoueur + 1.5, "Joueur2");

		}
		StdDraw.text(X_MAX - 3, Y_MAX - 1, "Oxygene = " + this.oxygene);
		StdDraw.text(1, surface, "Surface");
		StdDraw.text(X_MAX - 15, Y_MAX - 1, "Phase = " + phase);
		StdDraw.text(X_MAX - 4, Y_MAX - 2,
				"Nombre tresor du joueur 1 = " + (player1.coffreDeposer.size() + player1.ListeLevel.size()));
		StdDraw.text(X_MAX - 4, Y_MAX - 3,
				"Nombre tresor du joueur 2 = " + (player2.coffreDeposer.size() + player2.ListeLevel.size()));
	}

	public void affichageScore() throws InterruptedException {
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);

		StdDraw.picture(10, 10, "ocean2.JPG", 35, 55);

		if (player1.Score < player2.Score) {
			StdDraw.text(X_MAX - X_MAX / 2, Y_MAX / 2,
					"Vainqueur = Joueur 2 avec un score de " + player2.Score + " trésors");
			StdDraw.text(X_MAX - X_MAX / 2, Y_MAX / 2.5,
					"Le Joueur 1 n'a obtenu qu'un score de " + player1.Score + " trésors");
		} else if (player1.Score > player2.Score) {
			StdDraw.text(X_MAX - X_MAX / 2, Y_MAX / 2,
					"Vainqueur = Joueur 1 avec un score de " + player1.Score + " trésors");
			StdDraw.text(X_MAX - X_MAX / 2, Y_MAX / 2.5,
					"Le Joueur 2 n'a obtenu qu'un score de " + player2.Score + " trésors");
		} else {
			StdDraw.text(X_MAX - X_MAX / 2, Y_MAX / 2, "Match nul");
			StdDraw.text(X_MAX - X_MAX / 2, Y_MAX / 2.5, "Score Joueur 1 = " + player1.Score + " trésors");
			StdDraw.text(X_MAX - X_MAX / 2, Y_MAX / 3, "Score Joueur 2 = " + player2.Score + " trésors");

		}
		Thread.sleep(4000);
		StdDraw.clear();
	}

	public void noChest() {
		StdDraw.text(X_MAX - 4, Y_MAX - 5, "il n'y a pas de tresors a cet endroit");

	}

	public void tour(int n) {
		if (IA == true && n == 2) {
			StdDraw.text(X_MAX - 10, Y_MAX - 1, "Au tour de l'IA");

		} else {
			StdDraw.text(X_MAX - 10, Y_MAX - 1, "Au tour du Joueur" + n);
		}
	}

	public void moreChests() {
		int tresorDernierNiveau = 0;
		for (Levels level : liste) {
			if (level.numeroNiveau == 1) {
				tresorDernierNiveau++;

			}

		}
		if (tresorDernierNiveau > 1) {

			StdDraw.text(2, 1.2, "+++");
		}
	}

	public void clear() {
		StdDraw.clear();
	}

	public void depotTresor() {
		if (Indicateur % 2 == 0) {
			StdDraw.text(X_MAX - 4.5, Y_MAX - 5, "Le Joueur 1 vient de deposer ses tresors !");

		}
		if (Indicateur % 2 != 0) {
			StdDraw.text(X_MAX - 4.5, Y_MAX - 5, "Le Joueur 2 vient de deposer ses tresors !");

		}

	}

	public int chercher() {
		int i = 0;
		for (Levels level : liste) {
			if (level.numeroCave == 3 && level.numeroNiveau != 1) {
				i++;
			}

		}

		return (i + 1);
	}

	public int chercher2() {
		int i = -1;
		for (Levels level : liste) {
			if (level.numeroCave == 2) {
				i++;
			}

		}

		return (i);

	}

	public int chercher3() {
		int i = 0;
		for (Levels level : liste) {
			if (level.numeroCave == 1) {
				i++;
			}

		}

		return (i);

	}

}
