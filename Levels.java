import java.util.ArrayList;

public class Levels {
	public int numeroNiveau;
	public int numeroCave;

	public ArrayList<Chests> listeTresor = new ArrayList<Chests>();

	
	public void Ajout(Chests chest) {
		this.listeTresor.add(chest);
	}

	public void set(int a) {
		numeroCave = a;
	}

	public void set2(int a) {
		numeroNiveau = a;
	}

}
