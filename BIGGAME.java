import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdDraw;

public class BIGGAME {
	public int oxygene;
	public int Traceur = 0;
	public int Indicateur = 0;
	public Players tourJoueur;
	public Players player1;
	public Players player2;
	public interfaceGraphique Interface;
	public ArrayList<Players> listeJoueur = new ArrayList<Players>();

	public BIGGAME() {

	}

	public void bigGame() throws InterruptedException {
		listeJoueur.add(player1);
		listeJoueur.add(player2);
		Fusions Liste = new Fusions();
		Liste.laListe();

		Interface.player1 = this.player1;
		Interface.player2 = this.player2;

		int surface = Liste.listeCaves.size() + 1;
		Interface.surface = surface;
		boolean apparition = false;
		this.oxygene = 2 * Liste.listeCaves.size();

		for (int phase = 1; phase <= 3; phase++) {
			Interface.liste = Liste.listeCaves;
			Interface.begin();

			Interface.phase = phase;
			Traceur = 0;
			Indicateur = 0;
			oxygene = 2 * (Liste.listeCaves.size() - player1.ListeLevel.size() - player2.ListeLevel.size());
			player1.locaJoueur = surface;
			player2.locaJoueur = surface;
			Interface.surface = surface;

			while (this.oxygene > 0) {
				player2.niveauDispo = Liste.listeCaves;
				player1.Oxygene = oxygene;
				player2.Oxygene = oxygene;
				if (Traceur % 2 == 0) {
					if (player2.locaJoueur < player1.locaJoueur) {
						Indicateur = 2 * Indicateur + 1;
					} else if (player2.locaJoueur > player1.locaJoueur) {
						Indicateur = 2 * Indicateur;
					} else {
						Indicateur = (int) (Math.random() * (12));
					}

				}

				Interface.liste = Liste.listeCaves;
				Interface.oxygene = oxygene;
				Interface.affichage();

				if (apparition == true) {
					Interface.moreChests();
				}

				if (Indicateur % 2 == 0) {
					Interface.tour(1);
				}
				if (Indicateur % 2 != 0) {
					Interface.tour(2);
				}

				if (Indicateur % 2 == 0) {
					this.tourJoueur = player1;
				}
				if (Indicateur % 2 != 0) {
					this.tourJoueur = player2;
				}

				if (tourJoueur.locaJoueur == surface) {
					Interface.Indicateur = Indicateur;
					tourJoueur.Bloquage();
					Indicateur++;
					Traceur++;
					this.oxygene = this.oxygene - 1;

					if (tourJoueur.ListeLevel.isEmpty() == false) {
						Interface.depotTresor();
						Thread.sleep(1000);
						while (!tourJoueur.ListeLevel.isEmpty()) {
							tourJoueur.coffreDeposer.add(tourJoueur.ListeLevel.get(0));
							tourJoueur.ListeLevel.remove(0);

						}
					}
				}

				else {

					tourJoueur.nextMove();
					int i = 0;
					boolean presence = true;
					if (tourJoueur.capture == true) {

						while (presence == true && Liste.listeCaves.get(i).numeroNiveau != tourJoueur.locaJoueur) {
							i++;
							if (i == Liste.listeCaves.size()) {
								Interface.noChest();
								Thread.sleep(500);
								presence = false;
							}
						}
						if (presence == true) {

							tourJoueur.ListeLevel.add(Liste.listeCaves.get(i));

						}
						if (presence == true) {
							this.oxygene--;
							Liste.listeCaves.remove(i);
							Indicateur++;
							Traceur++;
						}
					} else if (tourJoueur.capture == false) {
						this.oxygene = this.oxygene - tourJoueur.ListeLevel.size() - 1;
						Indicateur++;
						Traceur++;

					}

					Thread.sleep(20);
				}
			}

			for (Players player : listeJoueur) {
				if (player.locaJoueur != surface) {
					for (Levels level : player.ListeLevel) {
						level.set2(1);
						level.set(3);
						Liste.listeCaves.add(level);
						apparition = true;

					}
					player.ListeLevel.clear();
				}
			}
			for (Players player : listeJoueur) {
				if (player.locaJoueur == surface) {
					while (!player.ListeLevel.isEmpty()) {
						player.coffreDeposer.add(player.ListeLevel.get(0));
						player.ListeLevel.remove(0);
					}

				}
			}

			Thread.sleep(20);
			int k = 2;
			for (int i = 3; i > 0; i--) {
				for (Levels level : Liste.listeCaves) {
					if (level.numeroNiveau != 1 && level.numeroCave == i) {
						level.numeroNiveau = k;
						k++;
					}
				}
			}

			surface = k;

		}

		this.calculateScore();
		Interface.affichageScore();

	}

	public void calculateScore() throws InterruptedException {
		for (Levels level : player1.coffreDeposer) {
			player1.Score += level.listeTresor.get(0).valeur;

		}
		for (Levels level : player2.coffreDeposer) {
			player2.Score += level.listeTresor.get(0).valeur;
		}

		Interface.affichageScore();

	}

}
