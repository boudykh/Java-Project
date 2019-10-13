import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Humain extends Players {
	
	public Humain () {
	}
	
	
	public void nextMove() throws InterruptedException {
		this.capture = false;
		if (locaJoueur == 1) {
			while (true) {
				if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
					this.locaJoueur++;
					Thread.sleep(100);
					return;
				
				}
				if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {
					this.capture = true;
					Thread.sleep(100);
					return;
				}
				
			}
			
		}
		else {
		
		while (true) {
			if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
				this.locaJoueur++;
				Thread.sleep(100);
				return;
			
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
				this.locaJoueur--;
				Thread.sleep(100);
				return;
				
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {
				this.capture = true;
				Thread.sleep(100);
				return;
			}
		
		}
		}

}
	public void Bloquage() throws InterruptedException {
		while (true) {
			if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
				this.locaJoueur =this.locaJoueur ; 
				Thread.sleep(100);
				
			
			}
			if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
				this.locaJoueur--;
				Thread.sleep(100);
				return;
				
			}
			
		
	}
}

}
