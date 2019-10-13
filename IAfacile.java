
public class IAfacile extends Players {

	public IAfacile() {
		

	}

	void nextMove() throws InterruptedException {
		int n = 0;
		this.capture = false;

		n = (int) (Math.random() * (5));
		if (locaJoueur == 1) {
			if (0 <= n && n <= 2) {
				locaJoueur++;
				Thread.sleep(800);
				return;
			}
			if (0 <= 3 && n <= 5) {
				this.capture = true;
				Thread.sleep(800);
				return;
			}

		} else {

			while (true) {
				for (Levels level : niveauDispo) {
					if (level.numeroNiveau == locaJoueur) {
						if (n == 0) {
							locaJoueur--;
							Thread.sleep(800);
							return;
						}
						if ((1 <= n && n <= 3)) {
							this.capture = true;
							Thread.sleep(800);
							return;
						} else {
							locaJoueur++;
							Thread.sleep(800);
							return;
						}

					}
				}

				if (n == 0 || n == 1) {
					locaJoueur--;
					Thread.sleep(800);
					return;
				} else {
					locaJoueur++;
					Thread.sleep(800);
					return;

				}

			}
		}
	}

	void Bloquage() throws InterruptedException {
		locaJoueur--;
		Thread.sleep(800);

		return;

	}

}
