package algo;

public class Polynome {
	private int coeff;
	private int deg;
	private Polynome suiv;

	public Polynome() {
		this.suiv = null;
	}

	public Polynome(int val, int deg) {
		this.coeff = val;
		this.deg = deg;
		this.suiv = null;
	}

	public Polynome(Polynome p) {
		if (p.estVide()) {
			this.coeff = p.coeff;
			this.deg = p.deg;
			this.suiv = null;
		} else {
			this.coeff = p.coeff;
			this.deg = p.deg;
			this.suiv = new Polynome(p.suiv);
		}
	}

	public boolean estVide() {
		return this.suiv == null;
	}

	public String toString() {
		if (this.estVide()) {
			if (this.deg == 0) {
				return "" + this.coeff;
			}
			if (this.deg == 1) {
				return this.coeff + "x";
			} else {
				return this.coeff + "x^" + this.deg;
			}
		} else {
			char c;
			if (this.suiv.coeff < 0) {
				c = '-';
				this.suiv.coeff = 0 - this.suiv.coeff;
			} else {
				c = '+';
			}
			if (this.deg == 0) {
				return "" + this.coeff + ' ' + c + ' ' + this.suiv.toString();
			}
			if (this.deg == 1) {
				return this.coeff + "x" + ' ' + c + ' ' + this.suiv.toString();
			} else {
				return this.coeff + "x^" + this.deg + ' ' + c + ' '
						+ this.suiv.toString();
			}
		}
	}

	public void add(int c, int d) {
		if (this.suiv == null) {
			this.suiv = new Polynome(c, d);
		} else
			this.suiv.add(c, d);
	}

	public void add(Polynome p) {
		if (this.estVide()) {
			this.suiv = new Polynome(p);
		} else
			this.suiv.add(p);
	}

	public int eval(int x) {
		if (this.estVide()) {
			if (this.deg == 0) {
				return this.coeff;
			} else {
				return this.coeff * (int) Math.pow(x, this.deg);
			}
		} else {
			if (this.deg == 0) {
				return this.coeff + this.suiv.eval(x);
			} else {
				return this.coeff * (int) Math.pow(x, this.deg)
						+ this.suiv.eval(x);
			}
		}
	}

	public int degre() {
		return this.degreAux(this.deg);
	}

	private int degreAux(int degre) {
		if (this.estVide()) {
			if (this.deg >= degre) {
				return this.deg;
			} else
				return degre;
		} else {
			if (this.deg >= degre) {
				return this.suiv.degreAux(this.deg);
			} else {
				return this.suiv.degreAux(degre);
			}
		}
	}

	public Polynome simplifie() {
		Polynome tamp = new Polynome();
		tamp.simplifieAux(this);
		return tamp;

	}

	public void simplifieAux(Polynome p) {
		if (p.estVide()) {
			if (p.coeff == 0) {
			} else {
				this.add(p.coeff, p.deg);
			}
		} else {
			if (p.coeff == 0) {
				this.simplifieAux(p.suiv);
			} else {
				this.add(p.coeff, p.deg);
				this.simplifieAux(p.suiv);
			}
		}
	}

	public Polynome deriver() {
		Polynome tamp = new Polynome();
		tamp.deriverAux(this);
		return tamp;
	}

	public void deriverAux(Polynome p) {
		if (p.estVide()) {
			if (p.deg > 0) {
				this.add(p.coeff * p.deg, p.deg - 1);
			} else if (p.deg == 0) {

			}
		} else {
			if (p.deg > 0) {
				this.add(p.coeff * p.deg, p.deg - 1);
				this.deriverAux(p.suiv);
			} else if (p.deg == 0) {
				this.deriverAux(p.suiv);
			}
		}
	}

	public Polynome reduire() {
		Polynome tamp = new Polynome();
		tamp.reduireAux(this);
		return tamp;
	}

	private void reduireAux(Polynome p) {
		if (p.estVide()) {
			return;
		} else if (p.coeff == 0) {

		} else {
			this.add(p.coeff, p.deg);
			this.suiv.simplifieAux(p.suiv);
		}
	}

	public Polynome ajouter(Polynome p) {
		Polynome tampon = new Polynome();
		tampon.add(this);
		tampon.add(p);
		return tampon;
	}

	public Polynome multiplier(Polynome p) {
		return null;
	}

	public static void main(String[] args) {
		Polynome p1 = new Polynome(2, 3);
		p1.add(0, 7);
		p1.add(-6, 1);
		p1.add(5, 2);
		System.out.println("p1.toString() : " + p1.toString());
		System.out.println("p1.eval(5) : " + p1.eval(5));
		System.out.println("p1.degre() : " + p1.degre());
		Polynome p2 = p1.simplifie();
		System.out.println("p1.simplifie() : " + p2.toString());
		Polynome p3 = p2.deriver();
		System.out.println("p2.deriver() : " + p3.toString());
		Polynome p5 = p1.ajouter(p3);
		System.out.println("p1.ajouter(p3) : " + p5.toString());
	}
}
