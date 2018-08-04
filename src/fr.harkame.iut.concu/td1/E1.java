package td1;

public class E1 {
	
	public final static void afficher(int p_valeur){
		for(int i = 0; i < 100; i++){
			System.out.println(p_valeur);
		}
	}
	public static void main(String [] Args){
		afficher(100);
		afficher(200);
		afficher(300);
	}
}
