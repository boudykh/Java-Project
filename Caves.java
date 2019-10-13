import java.util.ArrayList;

public class Caves {
	public int n;
	public ArrayList<Levels> listeNiveau = new ArrayList<Levels>();

	public Caves(int n) {
		this.n = n;
		
	}

	public void Creation() {
		int NombreNiveau;
		int nombreTresor;

		if (n == 1) {
			NombreNiveau = 9 + (int) (Math.random() * ((12 - 9) + 1));

			for (int k = 1; k <= NombreNiveau; k++) {
				nombreTresor = 1 + (int) (Math.random() * ((3 - 1) + 1));
				Levels level = new Levels();
				level.numeroNiveau = k;
				level.numeroCave = 1;
				Chests chest = new Chests();
				chest.valeur = nombreTresor;
				level.Ajout(chest);
				listeNiveau.add(level);
			}
		} else if (n == 2) {
			NombreNiveau = 6 + (int) (Math.random() * ((9 - 6) + 1));

			for (int k = 1; k <= NombreNiveau; k++) {
				nombreTresor = 5 + (int) (Math.random() * ((8 - 5) + 1));
				Levels level = new Levels();
				level.numeroNiveau = k;
				level.numeroCave = 2;
				Chests chest = new Chests();
				chest.valeur = nombreTresor;
				level.Ajout(chest);
				listeNiveau.add(level);

			}
		} else {
			NombreNiveau = 3 + (int) (Math.random() * ((6 - 3) + 1));

			for (int k = 1; k <= NombreNiveau; k++) {
				nombreTresor = 10 + (int) (Math.random() * ((12 - 10) + 1));
				Levels level = new Levels();
				level.numeroNiveau = k;
				level.numeroCave = 3;
				Chests chest = new Chests();
				chest.valeur = nombreTresor;
				level.Ajout(chest);
				listeNiveau.add(level);

			}
		}

	}

	public void size() {
		System.out.print(this.listeNiveau.size());
	}

}
