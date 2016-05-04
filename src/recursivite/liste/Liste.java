package algo;

public class Liste {
	private int val;
	private Liste suiv;

	public Liste() {
		this.suiv = null;
	}

	public Liste(int val) {
		this.val = val;
		this.suiv = null;
	}

	public Liste(Liste l) {
		if (l.estVide()) {
			this.val = l.val;
		} else {
			this.val = l.val;
			this.suiv = new Liste(l.suiv);
		}
	}

	public Liste ajoutTete(int x) {
		Liste tampon = new Liste(x);
		tampon.suiv = new Liste(this);
		return tampon;
	}

	public Liste ajoutFin(int x) {
		Liste tampon = new Liste(this);
		tampon.add(x);
		return tampon;
	}

	public void add() {
		if (this.estVide()) {
			this.suiv = new Liste();
		} else {
			this.suiv.add();
		}
	}

	public void add(int val) {
		if (this.estVide()) {
			this.suiv = new Liste(val);
		} else {
			this.suiv.add(val);
		}
	}

	public boolean estVide() {
		return this.suiv == null;
	}

	public int longeur() {
		if (this.estVide()) {
			return 1;
		} else
			return 1 + this.suiv.longeur();
	}

	public int somme() {
		if (this.estVide()) {
			return this.val;
		} else
			return this.val + this.suiv.somme();
	}

	public int nbOccurences(int x) {
		if (this.estVide() && this.val == x) {
			return 1;
		} else if (this.estVide() && this.val != x) {
			return 0;
		} else if (this.suiv != null && this.val == x) {
			return 1 + this.suiv.nbOccurences(x);
		} else if (this.suiv != null && this.val != x) {
			return 0 + this.suiv.nbOccurences(x);
		} else {
			return this.suiv.nbOccurences(x);
		}
	}

	public boolean croissant() {
		if (this.suiv == null) {
			return true;
		} else if (this.val > this.suiv.val) {
			return false;
		} else
			return this.suiv.croissant();
	}

	public void affvaleursAux() {
		if (this.suiv == null) {
			System.out.print(this.val);
			return;
		} else
			System.out.print(this.val + " --> ");
		this.suiv.affvaleurs();
	}

	public void affvaleurs() {
		this.affvaleursAux();
		System.out.println("");
	}

	public int get(int i) {
		return this.getAux(i, 0);
	}

	public int getAux(int i, int compteur) {
		if (compteur == i) {
			return this.val;
		} else
			return this.suiv.getAux(i, compteur + 1);
	}

	public Liste concat(Liste l) {
		Liste tampon = new Liste(this);
		tampon.concatAux(l);
		return tampon;
	}

	public Liste concatAux(Liste l) {
		if (this.suiv == null) {
			this.suiv = l;
			return this.suiv;
		} else {
			this.suiv.concatAux(l);
			return null;
		}
	}

	public int getval() {
		return this.val;
	}

	public Liste getsuiv() {
		return this.suiv;
	}

	public ListeTriee fusion(Liste l) {
		ListeTriee n = new ListeTriee();
		n.getliste().fusionAux(this, l);
		return n;
	}

	private void fusionAux(Liste a, Liste b) {
		if (a.suiv == null && b.suiv == null) {
			if (a.val < b.val) {
				this.add(a.val);
				this.add(b.val);
			} else if (a.val > b.val) {
				this.add(b.val);
				this.add(a.val);
			}
			return;
		} else if (a.suiv == null || b.suiv == null) {
			if (a.suiv == null) {
				if (a.val < b.val) {
					this.add(a.val);
				} else if (a.val > b.val) {
					this.add(b.val);
				} else if (a.val == b.val) {
					this.add(a.val);
					this.add(b.val);
				}
				fusionAux(a, b.suiv);

			} else {
				if (a.val > b.val) {
					this.add(b.val);
				} else if (a.val < b.val) {
					this.add(a.val);
				} else if (a.val == b.val) {
					this.add(a.val);
					this.add(b.val);
				}
				fusionAux(a.suiv, b);
			}
		} else {
			if (a.val < b.val) {
				this.add(a.val);
				this.fusionAux(a.suiv, b);
			} else if (a.val == b.val) {
				this.add(a.val);
				this.add(b.val);
				this.fusionAux(a.suiv, b.suiv);
			} else {
				this.add(b.val);
				this.fusionAux(a, b.suiv);
			}
		}
	}

	public static void main(String[] Args) {
		Liste l1 = new Liste(3);
		l1.add(39);
		l1.add(40);
		Liste l2 = new Liste(6);
		l2.add(6);
		l2.add(39);
		l2.add(45);
		l1.affvaleurs();
		l2.affvaleurs();

		/*
		 * Liste l3 = l2.ajoutTete(573); // l3.affvaleurs(); Liste l4 =
		 * l3.ajoutFin(1024); // l4.affvaleurs(); //
		 * System.out.println(l1.get(1)); Liste l5 = new Liste(5);
		 * l5.add(989658); Liste l6 = l5.concat(l3); l6.affvaleurs();
		 */
		ListeTriee lt = l1.fusion(l2);
		lt.getliste().affvaleurs();
	}
}
