package algo;

import java.util.Scanner;

public class Algo {
	static int compteur = 0;

	public static void hanoi(int n, int i, int j) {
		compteur++;
		if (n == 1) {
			System.out.println(i + " --> " + j);
		} else {
			int k = 6 - i - j;
			hanoi(n - 1, i, k);
			System.out.println(i + " --> " + j);
			hanoi(n - 1, k, j);
		}
	}

	public static void hanoi_fini(int n, int i, int j) {
		hanoi(n, i, j);
		System.out.println("Fini : " + compteur + " coups");
	}

	public static int monnaie(int n, int... t) {
		return monnaierec(n, t, t.length - 1);
	}

	public static int monnaierec(int n, int[] t, int i) {
		if (n == 0) {
			return 0;
		} else if (t[i] > n) {
			return 0;
		} else if ((n - 1 - i) > t[i]) {
			return 1 + monnaierec(n - 1, t, i);
		} else {
			return 1 + monnaierec(n, t, i - 1);
		}
	}

	public static int factorielle(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else {
			return n * factorielle(n - 1);
		}
	}

	public static int nbMonnaieAux(int n, int i, int... t) {
		if (n == 0) {
			return 1;
		} else {
			int k = n / t[i];
			return k + nbMonnaieAux(n - t[i], i - 1, t);
		}
	}

	public static long sommesuite(int n) {
		if (n == 1) {
			return 1;
		} else
			return n * sommesuite(n - 1);
	}

	public static boolean trouver(int n, int[] t) {
		return trouverAux(n, t, t.length / 2 - 1);
	}

	private static boolean trouverAux(int n, int[] t, int i) {
		System.out.println(i);
		if (i == 0 || i == t.length - 1) {
			if (t[i] == n) {
				return true;
			} else {
				return false;
			}
		} else if (t[i] == n) {
			return true;
		} else if (n < t[i]) {
			return trouverAux(n, t, i - i / 2);
		} else {
			return trouverAux(n, t, i + i / 2);
		}
	}

	static void nbMyst(int Nmax) {
		nbMystAux(0, Nmax);
	}

	static void nbMystAux(int a, int b) {
		Scanner clavier = new Scanner(System.in);
		System.out.println((a + b) / 2);
		String commande = clavier.nextLine();
		if (commande.equals("T")) {
			System.out.println("WIIIIIIIN");
			return;
		} else if (commande.equals("P")) {
			nbMystAux(a, (a + b) / 2);
		} else {
			nbMystAux((a + b) / 2, b);
		}
	}

	public static void main(String[] Args) {
		int[] t = { 1, 3, 5, 9, 10, 15, 17, 42, 69, 85 };
		nbMyst(1000);
	}
}
