package td1;

public class ATache implements Runnable {
	int nom;
	int index;

	public ATache(int ident) {
		this.nom = ident;
		this.index = 1;
	}

	@Override
	public void run() {
		System.out.println("	Debut e" + this.nom);
		for (int i = 0; i < 30; i++) {
			this.index = i;
			System.out.println("		Index : " + this.index);
			System.out.println("		Nom : " + this.nom);
			try {
				Thread.sleep((int) Math.floor(Math.random() * 500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("	Fin e" + this.nom);
	}

	public static void main(String[] Args) throws InterruptedException {
		Thread t1 = new Thread(new ATache(1));
		t1.start();
		t1.join(100);
		Thread t2 = new Thread(new ATache(2));
		t2.start();
		t2 .join(100);
		Thread t3 = new Thread(new ATache(3));
		t3.start();
		t3.join(100);
	}
}
