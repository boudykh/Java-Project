
public class IADifficile extends Players {

	public IADifficile() {
		
	}

	@Override
	void nextMove() throws InterruptedException {
		int n = 0;
		this.capture = false;

		n = (int) (Math.random() * (6));

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
				if (!ListeLevel.isEmpty()) {
					for (Levels level : niveauDispo) {
						if (level.numeroNiveau == locaJoueur) {
							this.capture = true;
							Thread.sleep(800);
							return;
						}
					}

					locaJoueur++;
					Thread.sleep(800);
					return;
				}
				for (Levels level : niveauDispo) {
					if (level.numeroNiveau == locaJoueur) {
						if (0 <= n && n <= 2) {
							locaJoueur--;
							Thread.sleep(800);
							return;
						}
						if (0 <= 3 && n <= 5) {
							this.capture = true;
							Thread.sleep(800);
							return;
						}

					}

				}
				locaJoueur--;
				Thread.sleep(800);
				return;

			}
		}

	}

	void Bloquage() throws InterruptedException {
		locaJoueur--;
		Thread.sleep(800);

		return;

	}

}
