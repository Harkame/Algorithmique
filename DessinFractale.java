package algo;

import java.util.Random;

class DessinFractale {
	private final Turtle bob;
	private static Random r = new Random();
	private final static int LARGEUR = 800;
	private final static int HAUTEUR = 600;

	// taille de la fenetre graphique

	public DessinFractale() {
		bob = new Turtle();
		Turtle.setCanvasSize(LARGEUR, HAUTEUR);// Ã  appeler APRES crÃ©ation de
												// la tortue
	}

	public DessinFractale(int v) {
		// attention, plus v est grand, plus bob va lentement !
		this();
		bob.speed(v);
	}

	public void reset() {
		bob.clear();
		bob.up();
		bob.setPosition(0, 0);
		bob.setDirection(0);
		bob.down();

	}

	public void close() {
		bob.exit();
	}

	public void carre(double l) {
		this.carreAux(l, 360);
	}

	public void carreAux(double l, int angle) {
		if (angle == 0) {
			close();
		} else
			this.bob.down();
		this.bob.forward(l);
		this.bob.right(90);
		carreAux(l, angle - 90);
	}

	public void diago(double l, int n) {
		diagorec(l, n, n);
		// diagorecc(l,n);
	}

	public void diagorec(double l, int n, int n_save) {
		//
		if (n == 0) {
			close();
		} else {
			this.bob.down();
			this.bob.right(90);
			this.bob.forward(l / 2);
			this.bob.left(90);
			this.bob.forward(l / 2);
			this.diagorec(l, n - 1, n_save);
		}
	}

	public void diagorecc(double l, int n, int n_save) {
		//
		if (n == 0) {
			close();
		} else {
			this.bob.down();
			this.bob.right(90);
			this.bob.forward(l / n_save);
			this.bob.left(90);
			this.bob.forward(l / n_save);
			this.diagorecc(l, n - 1, n_save);
		}
	}

	public void Flocon(double l, int n) {
		FloconAux(l, n); // cotÃ© gauche
		this.bob.right(120);
		FloconAux(l, n); // cotÃ© droite
		this.bob.right(120);
		FloconAux(l, n); // cotÃ© bas
	}

	public void FloconAux(double l, int n) {
		if (n == 0) {
			this.bob.forward(l);
		} else {
			FloconAux(l / 3, n - 1);
			this.bob.left(60); // CotÃ© gauche
			FloconAux(l / 3, n - 1);
			this.bob.right(120); // CotÃ© droite
			FloconAux(l / 3, n - 1);
			this.bob.left(60); // CotÃ© bas
			FloconAux(l / 3, n - 1);
		}
	}

	public void Arbre(Double l, int n) {
		if (n == 0) {
			this.bob.forward(l);
			this.bob.backward(l);
		} else {
			this.bob.forward(l);
			this.bob.left(45);
			Arbre(l / 2, n - 1);
			this.bob.right(90);
			Arbre(l / 2, n - 1);
			this.bob.left(45);
			Arbre(l, n - 1);
			this.bob.backward(l);
		}
	}

	public void Sapin(Double l, int n) {
		if (n == 0) {
			this.bob.forward(l);
			this.bob.backward(l);
		} else {
			this.bob.forward(l);
			this.bob.left(45);
			this.bob.forward(l / 2);
			this.bob.backward(l / 2);
			this.bob.right(90);
			this.bob.forward(l / 2);
			this.bob.backward(l / 2);
			this.bob.left(45);
			Sapin(l, n - 1);
		}
	}

	public void GrandeBranche(Double l, int n) {
		this.bob.down();
		this.bob.forward(l);
		if (n > 1) {
			this.bob.left(30);
			GrandeBranche(l / 2, n - 1);
			this.bob.right(60);
			GrandeBranche(l / 2, n - 1);
			this.bob.left(30);
			this.bob.up();
			this.bob.backward(l);
		}
	}

	public static void main(String[] args) {
		DessinFractale d = new DessinFractale(0);
		// d.diago(100, 2);
		// d.Flocon(100, 6);
		d.Arbre(100.0, 10);
		// d.carre(90);
		// d.reset();
		// d.carre(60);
		// d.reset();
		// d.close();
	}

}
