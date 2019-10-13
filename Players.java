import java.awt.event.KeyEvent;
import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;

abstract class Players {
	public int locaJoueur;
	public int Score = 0;
	public ArrayList<Levels> ListeLevel = new ArrayList<Levels>();
	public boolean capture = false;
	public int Oxygene;
	public ArrayList<Levels> coffreDeposer = new ArrayList<Levels>();
	public ArrayList<Levels> niveauDispo = new ArrayList<Levels>();

	abstract void nextMove() throws InterruptedException;

	abstract void Bloquage() throws InterruptedException;

}
