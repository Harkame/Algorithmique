package algo;

public class Hanoi {
	private int nombre_plateau;
	private int colonne_departs;
	private int colonne_arrivee;
	private int nombre_coups;
	private static int compteur = 0;

	public Hanoi(int nombre_plateau, int colonne_departs, int colonne_arrivee) {
		this.nombre_plateau = nombre_plateau;
		this.colonne_departs = colonne_departs;
		this.colonne_arrivee = colonne_arrivee;
		this.nombre_coups = 0;
	}

	private void resoudrerec(int nombre_plateaux, int colonne_departs,
			int colonne_arivee) {
		System.out.println("--- Etape " + compteur++ + " ---");
		this.nombre_coups++;
		if (nombre_plateaux == 1) {
			System.out.println("--- Cas special ---");
			deplacer(colonne_departs, colonne_arivee);
		} else {
			System.out.println("--- Cas general ---");
			int colonne_tampon = 6 - colonne_departs - colonne_arivee;
			resoudrerec(nombre_plateaux - 1, colonne_departs, colonne_tampon);
			deplacer(colonne_departs, colonne_arivee);
			resoudrerec(nombre_plateaux - 1, colonne_tampon, colonne_arivee);
		}
	}

	private void resoudre(int nb_plateau, int c_depart, int c_arrive) {
		if (nb_plateau == 1) {
			deplacer(c_depart, c_arrive);
		} else {
			int c_tampon = 6 - c_depart - c_arrive;
			resoudre(nb_plateau - 1, c_depart, c_tampon);
			deplacer(c_depart, c_arrive);
			resoudre(nb_plateau - 1, c_tampon, c_arrive);
		}
	}

	private static void deplacer(int colonne_depart, int colonne_arivee) {
		System.out.println(colonne_depart + " --> " + colonne_arivee);
	}

	public void resoudre() {
		this.resoudre(this.nombre_plateau, this.colonne_departs,
				this.colonne_arrivee);
		System.out.println("Fini : " + this.nombre_coups + " coups");
	}

	public static void main(String[] Args) {
		Hanoi h01 = new Hanoi(3, 1, 3);
		h01.resoudre();
	}
}
