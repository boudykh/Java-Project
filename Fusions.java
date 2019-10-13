import java.util.ArrayList;

public class Fusions {

	public ArrayList<Levels> listeCaves = new ArrayList<Levels>();
	public ArrayList<Caves> listeCave = new ArrayList<Caves>();

	public void laListe() {
		Caves cave1 = new Caves(1);
		cave1.Creation();
		Caves cave2 = new Caves(2);
		cave2.Creation();
		Caves cave3 = new Caves(3);
		cave3.Creation();

		for (Levels level : cave3.listeNiveau) {
			listeCaves.add(level);
		}
		for (Levels level : cave2.listeNiveau) {
			level.numeroNiveau = level.numeroNiveau + cave3.listeNiveau.size();
			listeCaves.add(level);
		}
		for (Levels level : cave1.listeNiveau) {
			level.numeroNiveau = level.numeroNiveau + cave2.listeNiveau.size() + cave3.listeNiveau.size();
			listeCaves.add(level);
		}
		listeCave.add(cave3);
		listeCave.add(cave2);
		listeCave.add(cave1);

	}

}