package algo;

public class Baguenaudier {
	private boolean cases[];

	public Baguenaudier(int... valeurs) {
		this.cases = new boolean[valeurs.length];
		for (int i = 0; i < valeurs.length; i++) {
			if (valeurs[i] == 0) {
				this.cases[i] = false;
			} else if (valeurs[i] == 1) {
				this.cases[i] = true;
			}
		}
	}

	public void aff() {
		System.out.print("| ");
		for (int i = 0; i < this.cases.length; i++) {
			if (this.cases[i]) {
				System.out.print("* ");
			} else
				System.out.print("- ");
		}
		System.out.println("|");
	}

	public void separation() {
		for (int i = -2; i < this.cases.length; i++) {
			System.out.print("//");
		}
		System.out.println("");
	}

	private void ajouter(int i) {
		this.cases[i] = true;
		aff();
	}

	private void enlever(int i) {
		this.cases[i] = false;
		aff();
	}

	private void vider(int n) {
		if (n == 0)
			enlever(0);
		else if (n == 1) {
			enlever(1);
			enlever(0);
		} else {
			vider(n - 2);
			enlever(n);
			remplir(n - 2);
			vider(n - 1);
		}
	}

	private void remplir(int n) {
		if (n == 0)
			ajouter(0);
		else if (n == 1) {
			ajouter(0);
			ajouter(1);
		} else {
			remplir(n - 1);
			vider(n - 2);
			ajouter(n);
			remplir(n - 2);
		}
	}

	public void jouer(int n) {
		this.aff();
		this.remplir(n);
		this.separation();
		this.aff();
		this.vider(n);
	}

	public static void main(String args[]) {
		Baguenaudier b01 = new Baguenaudier(0, 0, 0);
		b01.jouer(b01.cases.length - 1);
	}
}
